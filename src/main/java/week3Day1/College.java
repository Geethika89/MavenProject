package week3Day1;

public class College extends University {
	
	public void getug() {
		System.out.println("Applied Electronics was my stream in ug");
	}
	
	public static void main(String[] args) {
		
		College stream = new College();
		stream.getpg();
		stream.getug();
	}

}
