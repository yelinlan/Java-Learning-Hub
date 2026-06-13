package proxy.service.impl;

import proxy.service.Person;

public class Renter implements Person {

	@Override
	public void rentHouse() {
		System.out.println("租客租房成功！");
	}

}
