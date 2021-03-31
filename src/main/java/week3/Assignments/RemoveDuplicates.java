package week3.Assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String string = "Paypal India";
		char[] charArray = string.toCharArray();
		Set<Character> text= new LinkedHashSet<Character>();
		Set<Character> duptext= new LinkedHashSet<Character>();
		
		
		for (int i=0;i<charArray.length;i++) {
			
				if(text.contains(charArray[i])) {
					duptext.add(charArray[i]);
					
				}
				
				else {
					text.add(charArray[i]);
				}
					}
		
		for (Character character : text) {
			if(character!=' ') {
				System.out.println(character);
				}
			}
		}
		
	}



 