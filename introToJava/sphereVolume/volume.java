// < Rowan Kill >
// CSCI 262: Assignment 1
//this program will calculate the volume of a sphere
public class Volume{
	//declare a constant variable PI
	private static final double PI = 3.14159265;

	//main method begins execution of Java application
	public static void main(String[] args){
		double radius, volume;
		radius = Double.parseDouble(args[0]);
		volume = 4.0/3.0 * PI * radius * radius * radius;
		System.out.println("The volume of the sphere is " + volume);
	}//end method main
}//end class Volume
