/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 * 
 * Generate Random Matrix: https://onlinemathtools.com/generate-random-matrix
 * Determinant Calculator: https://onlinemathtools.com/matrix-determinant
 */

package v1;

import java.util.Scanner;

public class SparseMatrixStep1 {
	private final static String TITLE = "Determinant Calculator V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	private static void swaprows(double a[][], int i, int j) {
		for (int k = 0; k < a.length; k++) {
			double temp = a[i][k];
			a[i][k] = a[j][k];
			a[j][k] = temp;
		}
	}

	private static double det(double a[][]) {
		double temp = 1.0, coeff;
		int size = a.length;
		int i, j, l;
		for (i = 0; i < size; i++) {
			if (a[i][i] == 0.0) {
				for (j = i; j < size; j++)
					if (a[j][i] != 0)
						break;
				if (j < size) {
					swaprows(a, i, j);
					temp = -temp;
				} else
					break;
			}
			temp *= coeff = a[i][i];
			for (j = i; j < size; j++)
				a[i][j] = a[i][j] / coeff;
			for (l = i + 1; l < size; l++) {
				coeff = a[l][i];
				for (j = i; j < size; j++)
					a[l][j] = a[l][j] - coeff * a[i][j];
			}
		}
		return i < size ? 0.0 : temp;
	}

	private static void displayMatrix(double a[][]) {
		int size = a.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%10.2f", a[i][j]);
			System.out.println();
		}
	}

	private static void readMatrix(Scanner in, double a[][]) {
		int size = a.length;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				a[i][j] = in.nextDouble();
	}

	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter Matrix Size: ");
		var size = input.nextInt();
		var mat = new double[size][size];
		System.out.println("Enter Matrix Elements:");
		readMatrix(input, mat);
		input.nextLine();
		System.out.println("\nMatrix Elements = ");
		displayMatrix(mat);
		System.out.printf("The determinate = %.2f\n", det(mat));	
	}
	
	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner input, String prompt) {
		System.out.print(prompt); 
		String doOver = input.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) throws Exception {
		System.out.println("Welcome to " + TITLE);
		Scanner input = new Scanner(System.in);
		do {
			process(input, args);
		} while (doThisAgain(input, CONTINUE_PROMPT));
		input.close();
		System.out.println("Thank you for using " + TITLE);
	}

}
