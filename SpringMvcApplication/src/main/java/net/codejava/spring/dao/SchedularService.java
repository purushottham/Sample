package net.codejava.spring.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.codejava.spring.model.Engineer;
import net.codejava.spring.model.EngineersInfo;
import net.codejava.spring.model.EngineersData;
import net.codejava.spring.model.Schedule;
import net.codejava.spring.model.ScheduleInfo;

@Service
public class SchedularService {

	@Autowired
	private EngineersData engineersData;

	public static int PERIOD_DAYS = 10;
	public static int PER_DAYS_ENGINEERS = 2;
	public static int SHIFTS = 2;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public List<Schedule> generateSchedule() {
		LinkedHashMap<Engineer, Integer> map = new LinkedHashMap<>();
		try {
			Date startDate = new Date();
			// calculate schedule dates
			List<Date> scheduleDates = calculateDays(startDate, PERIOD_DAYS);
			List<Schedule> schedules;
			while (true) {
				try {
					schedules = new ArrayList<>();
					for (Date scheduleDate : scheduleDates) {
						Schedule schedule = new Schedule();
						schedule.setDate(scheduleDate);
						List<Engineer> shiftEngineers = new ArrayList<>();
						for (int i = 1; i <= PER_DAYS_ENGINEERS; i++) {
							Engineer engineer = validate(schedules, shiftEngineers, map);
							shiftEngineers.add(engineer);
						}
						schedule.setEngineers(shiftEngineers);
						schedules.add(schedule);
					}
					break;
				} catch (Exception ex) {
					map.clear();
					continue;
				}
			}
			map.clear();
			return schedules;

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	private Engineer validate(List<Schedule> currentSchedule, List<Engineer> currentShiftEngineers,
			LinkedHashMap<Engineer, Integer> map) {
		Engineer selectedEngineer = null;
		Set<Engineer> invalidEngineer = new HashSet<>();
		while (true) {
			Engineer pickedEngineer = engineersData.getRandom();
			if (invalidEngineer.size() == engineersData.getSize())
				break;
			if (map.get(pickedEngineer) != null && map.get(pickedEngineer) == SHIFTS) {
				invalidEngineer.add(pickedEngineer);
				continue;
			}
			if (currentShiftEngineers.contains(pickedEngineer)) {
				invalidEngineer.add(pickedEngineer);
				continue;
			}
			if (currentSchedule.size() > 0
					&& currentSchedule.get(currentSchedule.size() - 1).getEngineers().contains(pickedEngineer)) {
				invalidEngineer.add(pickedEngineer);
				continue;
			}
			selectedEngineer = pickedEngineer;
			break;
		}
		if (map.get(selectedEngineer) != null) {
			map.put(selectedEngineer, map.get(selectedEngineer) + 1);
		} else {
			map.put(selectedEngineer, 1);
		}
		return selectedEngineer;

	}

	public static List<Date> calculateDays(Date date, int interval) {
		List<Date> workingDates = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		for (int i = 0; i < interval;) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				workingDates.add(calendar.getTime());
				i++;
			}
		}
		return workingDates;
	}

	public List<ScheduleInfo> updateSchedule(List<Schedule> schedules) {
		List<ScheduleInfo> scheduleInfo = new ArrayList<>();
		if (schedules != null && !schedules.isEmpty()) {
			for (Schedule schedule : schedules) {
				ScheduleInfo scheduleData = new ScheduleInfo();
				scheduleData.setDate(sdf.format(schedule.getDate()));
				if (schedule.getEngineers() != null && !schedule.getEngineers().isEmpty()) {
					List<EngineersInfo> engineerinfo = new ArrayList<>();
					for (Engineer engineer : schedule.getEngineers()) {
						if (engineer != null) {
							EngineersInfo engineerData = new EngineersInfo();
							engineerData.setId(engineer.getId());
							engineerData.setName(engineer.getName());
							engineerinfo.add(engineerData);
						}
					}
					scheduleData.setEngineersInfo(engineerinfo);
				}
				scheduleInfo.add(scheduleData);
			}
		}
		return scheduleInfo;

	}

}
