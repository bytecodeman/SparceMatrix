/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 */

package v4;

import java.util.Scanner;

public class Determinant4 {

	private double matrix[][];
	
	public Determinant4(int size) {
		matrix = new double[size][size];
	}
	
	// it returns the value assigned
	// Works like mat[row][col] = value
	public double setElement(int row, int col, double value) {
		matrix[row][col] = value;
		return value;
	}

	// returns the value associated with the rowth, colth element
	public double getElement(int row, int col) {
		return matrix[row][col];
	}
	
	// Accessor Function that returns the SpareMatrix's size
	public int getSize() {
		return matrix.length;
	}

	private void swaprows(int i, int j) {
		for (int k = 0; k < getSize(); k++) {
			double temp = getElement(i, k);
			setElement(i, k, getElement(j, k));
			setElement(j, k, temp);
		}
	}

	public double det() {
		double temp = 1.0, coeff;
		int i, j, l;
		for (i = 0; i < getSize(); i++) {
			if (getElement(i, i) == 0.0) {
				for (j = i; j < getSize(); j++)
					if (getElement(j, i) != 0)
						break;
				if (j < getSize()) {
					swaprows(i, j);
					temp = -temp;
				} else
					break;
			}
			temp *= coeff = getElement(i, i);
			for (j = i; j < getSize(); j++)
				setElement(i, j, getElement(i, j) / coeff);
			for (l = i + 1; l < getSize(); l++) {
				coeff = getElement(l, i);
				for (j = i; j < getSize(); j++)
					setElement(l, j, getElement(l, j) - coeff * getElement(i, j));
			}
		}
		return i < getSize() ? 0.0 : temp;
	}

	public void displayMatrix() {
		System.out.println(this);
	}

	// Returns the matrix in a natural row, col order.
	public String toString() {
		String str = "";
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++)
				str += String.format("%10.2f", getElement(i, j));
			str += "\n";
		}
		return str;
	}

	public void readMatrix(Scanner in) {
		int size = getSize();
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = in.nextDouble();
	}

}
