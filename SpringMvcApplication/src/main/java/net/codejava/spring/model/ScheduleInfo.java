package net.codejava.spring.model;

import java.util.List;

public class ScheduleInfo {

	private String date;

	private List<EngineersInfo> engineersInfo;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<EngineersInfo> getEngineersInfo() {
		return engineersInfo;
	}

	public void setEngineersInfo(List<EngineersInfo> engineersInfo) {
		this.engineersInfo = engineersInfo;
	}

}
