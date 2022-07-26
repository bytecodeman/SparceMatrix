/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 */

package v6a;

import java.util.Scanner;

public class Determinant6a {

	private DataStore6a matrix;

	public Determinant6a(int size) {
		this.matrix = new DataStore6a(size);
	}

	// Accessor Function that returns the SpareMatrix's size
	public int getSize() {
		return matrix.getSize();
	}

	private void swaprows(int i, int j) {
		for (int k = 0; k < matrix.getSize(); k++) {
			double temp = matrix.getElement(i, k);
			matrix.setElement(i, k, matrix.getElement(j, k));
			matrix.setElement(j, k, temp);
		}
	}

	public double det() {
		double temp = 1.0, coeff;
		int i, j, l;
		for (i = 0; i < matrix.getSize(); i++) {
			if (matrix.getElement(i, i) == 0.0) {
				for (j = i; j < matrix.getSize(); j++)
					if (matrix.getElement(j, i) != 0)
						break;
				if (j < matrix.getSize()) {
					swaprows(i, j);
					temp = -temp;
				} else
					break;
			}
			temp *= coeff = matrix.getElement(i, i);
			for (j = i; j < matrix.getSize(); j++)
				matrix.setElement(i, j, matrix.getElement(i, j) / coeff);
			for (l = i + 1; l < matrix.getSize(); l++) {
				coeff = matrix.getElement(l, i);
				for (j = i; j < getSize(); j++)
					matrix.setElement(l, j, matrix.getElement(l, j) - coeff * matrix.getElement(i, j));
			}
		}
		return i < matrix.getSize() ? 0.0 : temp;
	}

	public void displayMatrix() {
		System.out.println(this);
	}

	// Returns the matrix in a natural row, col order.
	public String toString() {
		String str = "";
		for (int i = 0; i < matrix.getSize(); i++) {
			for (int j = 0; j < matrix.getSize(); j++)
				str += String.format("%10.2f", matrix.getElement(i, j));
			str += "\n";
		}
		return str;
	}

	public void readMatrix(Scanner in) {
		int size = matrix.getSize();
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix.setElement(i, j, in.nextDouble());
	}

}
