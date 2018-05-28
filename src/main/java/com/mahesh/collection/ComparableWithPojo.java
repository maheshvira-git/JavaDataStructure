/**
 * 
 */
package com.mahesh.collection;

import java.util.Arrays;

/**
 * @author mahesh.vira
 *
 */
class Point implements Comparable<Point> {

	int x;
	int y;
	Double distance;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Double getDistance() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	@Override
	public int compareTo(Point p) {
		return this.getDistance().compareTo(p.getDistance());
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", distance=" + getDistance() + "]";
	}

}

public class ComparableWithPojo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Point[] pArr = new Point[2];
		pArr[0] = new Point(-1, 2);
		pArr[1] = new Point(-2, 4);

//		Arrays.stream(pArr).sorted().collect(Collectors.toList()).forEach(System.out::println);

		Arrays.sort(pArr);
		
		Arrays.stream(pArr).forEach(System.out::println);
		
	}

}
