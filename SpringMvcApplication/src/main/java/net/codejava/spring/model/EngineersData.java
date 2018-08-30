package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class EngineersData {

	private List<Engineer> data = new ArrayList<>();

	@PostConstruct
	public void init() {
		data.add(new Engineer(1, "Employee1"));
		data.add(new Engineer(2, "Employee2"));
		data.add(new Engineer(3, "Employee3"));
		data.add(new Engineer(4, "Employee4"));
		data.add(new Engineer(5, "Employee5"));
		data.add(new Engineer(6, "Employee6"));
		data.add(new Engineer(7, "Employee7"));
		data.add(new Engineer(8, "Employee8"));
		data.add(new Engineer(9, "Employee9"));
		data.add(new Engineer(10, "Employee10"));
	}

	public Engineer getRandom() {
		Random ran = new Random();
		return this.data.get(ran.nextInt(data.size()));
	}

	public int getSize() {
		return data.size();
	}

}
