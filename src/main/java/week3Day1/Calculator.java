package week3Day1;

public class Calculator {

	public void addInteger(int a, int b)  {
		System.out.println("The added result is  : "  +(a+b));		
	}
	
	public void addInteger(int a,int b, int e) {
		System.out.println("The added result is : " +(a+b+e));
	}
	
	public void multiplyNum(int a, int b) {
		System.out.println("The multiplicaion result is : " +(a*b));
	}
	
	public void multiplyNum(int a, double b) {
		System.out.println("The multiplicaion result is : " +(a*b));
	}
	
	public void substractNum(int a, int b) {
		System.out.println("The subsraction result is : " +(a-b));
	}
	
	public void substractNum(double a, double b) {
		System.out.println("The subsraction result with double is : " +(a-b));
	}
	
	public void divideNum(int a, int b) {
		System.out.println("The Division result is : " +(a/b));
	}
	
	public void divideNum(double a, int b) {
		System.out.println("The division result with double is : " +(a/b));
	}

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		calc.addInteger(2, 4);
		calc.addInteger(2, 3, 6);
		calc.multiplyNum(3, 2);
		calc.multiplyNum(2,5.001);
		calc.substractNum(10, 5);
		calc.substractNum(30.0005, 10.00009);
		calc.divideNum(6,3);
		calc.divideNum(45.0985,5);
	}

}
