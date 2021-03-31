package week3Day1;

public class MyPhone extends IOS {

	public static void main(String[] args) {
		
		IPhone myphone=new IPhone();
		myphone.swipeleft();
		myphone.fingerprint();
		myphone.facerecognition();
		myphone.facerecognition(1);
		myphone.facerecognition("Dark");
		myphone.facerecognition("Yes", 1);
	}
	
	

}
