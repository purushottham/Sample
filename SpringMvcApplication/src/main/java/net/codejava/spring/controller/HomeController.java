package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.SchedularService;
import net.codejava.spring.model.Schedule;
import net.codejava.spring.model.ScheduleInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate hanlder
 * methods.
 * 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private SchedularService schedularService;

	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		model.setViewName("index");

		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEngineers", method = RequestMethod.GET)
	public ModelAndView getEngineers(HttpServletRequest request) {
		List<Schedule> schedules = schedularService.generateSchedule();
		List<ScheduleInfo> details = schedularService.updateSchedule(schedules);
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		view.addObject("schedules", details);
		return view;

	}

}
