package ie.ais.maths.even_odd_query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static final int array_limit = 100000;
	private static final int array_min = 2;

	private double[] A;
	private int X;
	private int Y;

	public static void main(String[] args)
	{
		Solution solution1 = new Solution();
		String input;
		int n;
		System.out.println("Enter values following with pressing ENTER");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
        	System.err.println("Something is wrong");
        	return;
        }
		if (!solution1.isNumber(input.trim()))
  		{
	        	System.err.println("Something is wrong");
	        	throw new NumberFormatException("Wrong Number");
        }

		n = Integer.parseInt(input);

		if (n >= (array_limit +1) || n < array_min)
  		{
	        	System.err.println("Number of array has to be >=2 "+ n);
	        	return;
  		}

        System.err.println("N:: "+ n);
		solution1.initArray(n);
		solution1.mainLoop(n);
		while(true)
		{
			solution1.getXAndY(n);
			solution1.printFind(solution1.getX(), solution1.getY());
		}
    }

	public void  printFind(int x , int y)
	{
		long result = (long)find(x, y);
		System.out.println("... " + result);
		System.out.println((result%2 == 0) ? "Even" : "Odd");
        }

	public void mainLoop(int n) {
			int x;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String input = null;
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				System.err.println("Something is wrong" + e.getMessage());
				return;
    }

			StringTokenizer tokens = new StringTokenizer(input);
		    String[] splited = new String[tokens.countTokens()];

		    int index = 0;
			while(tokens.hasMoreTokens()){
			        splited[index] = tokens.nextToken();
			        ++index;
    }

			if (n!= splited.length)
			{
				System.err.println("Something is wrong");
				throw new NumberFormatException("Wrong Number of input");
}
			int id = 0;
			for (String str : splited) {
				x = Integer.parseInt(str);
				if (x >= (array_limit +1) || x< array_min)
		  		{
			        	System.err.println("Number of array exceeded "+ n);
			        	return;
		  		}
				A[id++] = x;
			}
	}

	public void getXAndY(int num) {
		int n; int k;
		System.out.println("Press only enter if you want to exit ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
			System.err.println("Something is wrong" + e.getMessage());
			return;
		}
		if (!isNumber(input.trim()))
		{
			System.err.println("Something is wrong");
			throw new NumberFormatException("Wrong Number");
		}
		n = Integer.parseInt(input);
		if (n >= array_limit && n< array_min-1)
  		{
	       	System.err.println("Number of array exceeded "+ n);
	       	return;
  		}
        System.out.println("X::"+n);
        setX(n);
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
			System.err.println("Something is wrong" + e.getMessage());
			return;
		}
		if (!isNumber(input.trim()))
		{
			System.err.println("Something is wrong");
			throw new NumberFormatException("Wrong Number");
		}
		k = Integer.parseInt(input);
		if (k >=  array_limit  && k< array_min-1)
  		{
	        	System.err.println("Number of array exceeded "+ k);
	        	return;
  		}
        System.out.println("Y::"+k);
		setY(k);
		if(k<n || num<k || num<n )
			throw new NumberFormatException("Wrong Numbers. X should be <= Y and X,Y < N");
	}

	private void initArray(int n) {
		A = new double[n];
	}

	public double find(int x, int y)
	{
		    if(x>y) return 1l;
		    double ans = Math.pow(A[x-1],find(x+1,y));
		    return ans;
	}

	private boolean isNumber(String toTest) {
	    return toTest.matches("^[1-9]{1}\\d{0,5}$");
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}


}
