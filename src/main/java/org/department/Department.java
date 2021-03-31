package org.department;

import org.college.College;

//multilevel inheritance example
public class Department extends College {
	
	public void getdeptName(String departmentName) {
		System.out.println("The department name is : "  +departmentName);
	}

}
