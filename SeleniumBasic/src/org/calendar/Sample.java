package org.calendar;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name ="Fri Aug 11 2023 : 12:30 PM - 1:00 PM";
		//System.out.println("time print "+name);
		String[] name2 = name.split("Fri");
		
		System.out.println("name"+name2[1]);
	}

}
