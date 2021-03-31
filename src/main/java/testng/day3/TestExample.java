package testng.day3;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class TestExample {
	
	
		@Test
		public void createLead() {
			System.out.println("CreateLead");
		}
		@Test
		public void editLead() {
			System.out.println("EditLead");
			throw new NoSuchElementException();
		}
		@Test
		public void mergeLead() {
			System.out.println("MergrLead");
		}
		
		@Test
		public void duplicateLead() {
			System.out.println("DuplicateLead");
		}

		
	
	
	
}

