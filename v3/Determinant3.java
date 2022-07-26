/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 */

package v3;

import java.util.Scanner;

public class Determinant3 {

	private double matrix[][];
	
	public Determinant3(int size) {
		this.matrix = new double[size][size];
	}
	
	private void swaprows(int i, int j) {
		for (int k = 0; k < matrix.length; k++) {
			double temp = matrix[i][k];
			matrix[i][k] = matrix[j][k];
			matrix[j][k] = temp;
		}
	}

	public double det() {
		double temp = 1.0, coeff;
		int size = matrix.length;
		int i, j, l;
		for (i = 0; i < size; i++) {
			if (matrix[i][i] == 0.0) {
				for (j = i; j < size; j++)
					if (matrix[j][i] != 0)
						break;
				if (j < size) {
					swaprows(i, j);
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

	public void displayMatrix() {
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%10.2f", matrix[i][j]);
			System.out.println();
		}
	}

	public void readMatrix(Scanner in) {
		int size = matrix.length;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = in.nextDouble();
	}

}
