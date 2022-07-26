/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 */

package v2;

import java.util.Scanner;

public class Determinant2 {

	public static double[][] createMatrix(int size) {
		return new double[size][size];
	}
	

	//**********************************************
	// Put as many methods you need here
	
	private static void swaprows(double matrix[][], int i, int j) {
		for (int k = 0; k < matrix.length; k++) {
			double temp = matrix[i][k];
			matrix[i][k] = matrix[j][k];
			matrix[j][k] = temp;
		}
	}

	public static double det(double matrix[][]) {
		double temp = 1.0, coeff;
		int size = matrix.length;
		int i, j, l;
		for (i = 0; i < size; i++) {
			if (matrix[i][i] == 0.0) {
				for (j = i; j < size; j++)
					if (matrix[j][i] != 0)
						break;
				if (j < size) {
					swaprows(matrix, i, j);
					temp = -temp;
				} else
					break;
			}
			temp *= coeff = matrix[i][i];
			for (j = i; j < size; j++)
				matrix[i][j] = matrix[i][j] / coeff;
			for (l = i + 1; l < size; l++) {
				coeff = matrix[l][i];
				for (j = i; j < size; j++)
					matrix[l][j] = matrix[l][j] - coeff * matrix[i][j];
			}
		}
		return i < size ? 0.0 : temp;
	}

	public static void displayMatrix(double matrix[][]) {
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%10.2f", matrix[i][j]);
			System.out.println();
		}
	}

	public static void readMatrix(Scanner in, double matrix[][]) {
		int size = matrix.length;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = in.nextDouble();
	}

}
