package week3Day1;

public class Desktop implements HardWare,Software {
	
	public void getdesktopModel(String model) {
		System.out.println("The desktop model is  "  +model);
	}

	public void gethardwareResources() {
		System.out.println("Harware Keyboard is used");
		
	}

	public void getsoftwareResources() {
		System.out.println("The software windows8 is used");
		
	}
	
	public static void main(String[] args) {
		
		Desktop myDesk= new Desktop();
		myDesk.getdesktopModel("Hp");
		myDesk.gethardwareResources();
		myDesk.getsoftwareResources();
		
	}

}
