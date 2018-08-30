package net.codejava.spring.model;

import java.util.Date;
import java.util.List;

public class Schedule {

	private int id;

	private Date date;

	private List<Engineer> engineers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Engineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}

}
