package week3.Assignments;


import java.util.Arrays;

public class SortUsingCollection {

	public static void main(String[] args) {
		
		String[] companies= {"HCL","Wipro","Aspire Systems","CTS"};
		int size = companies.length;
		
		for (int i=0;i<=size;i++) {
			
			for (int j=i+1;j<size;j++) {
				if(companies[i].compareTo(companies[j])<0) {
					
					String temp = companies[i];
					companies[i] = companies[j];
					companies[j] = temp;
				}
			}
	
	}
		
		System.out.println(Arrays.toString(companies));

}
}







/* String[] companies= {"HCL","Wipro","Aspire Systems","CTS"};
		
		Arrays.sort(companies,Collections.reverseOrder());
		System.out.println(Arrays.toString(companies));
		*
		*/