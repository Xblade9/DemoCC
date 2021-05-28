package reborn.sel.prac;

public class StringBuffer {

	public static void main(String[] args) {

		
		String name="HCL";
		
		StringBuilder builder = new StringBuilder(name);
		
		/*
		 * builder.reverse();
		 * 
		 * System.out.println(builder);
		 */
		
		
		builder.append("Tech");
		
		System.out.println(builder);
		
		
		builder.insert(1, "P");
		
		System.out.println(builder);
		
	}

}
