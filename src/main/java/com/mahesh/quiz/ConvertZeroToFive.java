/**
 * 
 */
package com.mahesh.quiz;

/**
 * @author mahesh.vira
 *
 */
public class ConvertZeroToFive {

	private static int czfRec(int d) {
		
		if(d==0) {
			return 0;
		}
		
		int r = d%10;
		if(r==0) {
			r=5;
		}
		
		return czfRec(d/10)* 10 + r;
		
	}
	
	public static int czf(int n) {
		
		if(n==0) {
			return 5;
		}
		
		return czfRec(n);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 02030;
		System.out.println(n);
		
		//System.out.println(""+czf(02030));
	}

}
