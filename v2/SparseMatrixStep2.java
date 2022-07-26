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

package v2;

import java.util.Scanner;

public class SparseMatrixStep2 {
	private final static String TITLE = "Determinant Calculator V2.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter Matrix Size: ");
		var size = input.nextInt();
		var mat = Determinant2.createMatrix(size);
		System.out.println("Enter Matrix Elements:");
		Determinant2.readMatrix(input, mat);
		input.nextLine();
		System.out.println("\nMatrix Elements = ");
		Determinant2.displayMatrix(mat);
		System.out.printf("The determinate = %.2f\n", Determinant2.det(mat));	
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
