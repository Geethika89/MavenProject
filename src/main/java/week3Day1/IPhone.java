package week3Day1;

public  class IPhone extends IOS{

	public void facerecognition() {
		System.out.println("Face recognition not enabled");
	}	
	
	
public void facerecognition(String mode) {
	System.out.println("Face recognition based on mode enabled "  +mode );
}

public void facerecognition(int index) {
	System.out.println("Face recognition light mode enabled" + index);
}

public void facerecognition(String darkMode,int lightMode) {
	System.out.println("Face recognition dark and light enabled");
}

}
