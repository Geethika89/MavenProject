package org.system;

//single level inheritance example
public class Desktop extends Computer{
	
	public void desktopSize(String size) {
		System.out.println("To print the desktop size :  " +size );
	}
	
	public static void main(String[] args) {
		
		Desktop mysys= new Desktop();
		mysys.computermodel("Cognitive");
		mysys.desktopSize("14.4 inches");
		
	}	

}
