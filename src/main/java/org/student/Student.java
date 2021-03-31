package org.student;

import org.department.Department;

//multilevel inheritance example
public class Student extends Department{
	
	public void getstudentName(String studentName) {
		System.out.println("The stuent name is : " +studentName);
	}
	
	public void getstudentDept(String studentDept) {
		System.out.println("Te student department name is :  " +studentDept);
	}
	
	public void getstudentId(int studentId) {
		System.out.println("The student id is : " +studentId);
		
	}
	
	public static void main(String[] args) {
		
		Student studetails = new Student();
		studetails.getCollegeName("PSG");
		studetails.getCollegeCode(99);
		studetails.getcollegeRank(32);
		studetails.getdeptName("ECE");
		studetails.getstudentName("Eva");
		studetails.getstudentId(12345);
		studetails.getstudentDept("safety");
	}

}
