package practice;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {

	public static void main(String[] args) {

		/*
		 * int[] arr = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };
		 * 
		 * Arrays.sort(arr);
		 * 
		 * System.out.println("Elements of array sorted in ascending order :");
		 * 
		 * for (int i = 0; i < arr.length; i++) {
		 * 
		 * System.out.println(arr[i]); }
		 */
		
		
		
		
		//int[] arr= new int[] { 90, 23, 5, 109, 12, 22, 67, 34};
		
		
		Integer[]arr={ 90, 23, 5, 109, 12, 22, 67, 34};
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		System.out.println(Arrays.toString(arr));
		
	}

}
