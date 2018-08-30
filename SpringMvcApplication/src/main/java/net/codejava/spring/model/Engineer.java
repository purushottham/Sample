package net.codejava.spring.model;

import java.util.List;

public class Engineer {

	public Engineer() {
	}

	public Engineer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private int id;

	private String name;

	private List<Schedule> schedules;

	@Override
	public String toString() {
		return "Engineer [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
