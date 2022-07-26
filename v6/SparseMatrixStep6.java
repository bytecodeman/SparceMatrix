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

package v6;

import java.util.Scanner;

public class SparseMatrixStep6 {
	private final static String TITLE = "Determinant Calculator V6.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter Matrix Size: ");
		var size = input.nextInt();
		var mat = new Determinant6(size);
		System.out.println("Enter Matrix Elements:");
		mat.readMatrix(input);
		input.nextLine();
		System.out.println("\nMatrix Elements = ");
		mat.displayMatrix();
		System.out.printf("The determinate = %.2f\n", mat.det());	
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
