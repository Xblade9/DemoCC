package practice;

public class StringBuilderReverse {

	public static void main(String[] args) {

		StringBuilder str = new StringBuilder("Hello");

		System.out.println(str.reverse());

		
		System.out.println("******************");
		
		
		System.out.println(str.append("Bruce"));
		
		
		System.out.println(str.insert(1, "ver"));
		
	}

}
