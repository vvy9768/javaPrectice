package pgm;

import org.testng.annotations.Test;

public class A extends B{
	 public  A() {
		   System.out.println("constructure of A class");
	   }
	 {
	 System.out.println("instance block of A class");
	 }
	 static void  Mathod() {
		 System.out.println("static method ");
	 } 
	 @Test
	 public static void main() {
		 System.out.println("main class method ");
	}
}
