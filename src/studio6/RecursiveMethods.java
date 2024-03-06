package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		if (n == 0)
			return 0;
		else
			return Math.pow(0.5, n) + geometricSum(n - 1);
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p == q)
			return p;
		int test = 0;
		int returnVal = 0;
		if (p > q)
		{
			test = p % q;
			if (test == 0)
				return q;
			returnVal = q;
		}
		else if (p < q)
		{
			test = q % p;
			if (test == 0)
				return p;
			returnVal = p;
		}
		return gcd(returnVal, test);
			// FIXME compute the gcd of p and q using recursion
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
			return reverseArray(array, 0 , new int[array.length]);
			// FIXME create a helper method that can recursively reverse the given array
		
	}
	
	public static int[] reverseArray(int[] array, int index, int[] finalArray) {
		if (array.length / 2 - 1 < index)
		{
			if (array.length % 2 != 0)
				finalArray[index] = array[index];
			return finalArray;
		}
		else 
		{
			finalArray[index] = array[array.length - 1 - index];
			finalArray[array.length - 1 - index] = array[index];
			return reverseArray(array, index + 1, finalArray);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius / 3.0 <= radiusMinimumDrawingThreshold)
			StdDraw.circle(xCenter, yCenter, radius);
		else
		{
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles(xCenter - radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter + radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius / 3.0, radiusMinimumDrawingThreshold);
		}
	}

}
