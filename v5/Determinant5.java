/*
 * Name:
 * Date:
 * Course Number:
 * Course Name:
 * Problem Number:
 * Email: 
 * Short Description of the Problem
 */

package v5;

import java.util.Scanner;

public class Determinant5 {

	private static final int MAXCOUNT = 100;
	private int matrixSize;
	private int count;
	private ValueItem data[] = new ValueItem[MAXCOUNT];

	public Determinant5(int size) {
		matrixSize = size;
		count = 0;
	}

	private int search(int row, int col) {
		for (int i = 0; i < count; i++)
			if (data[i].row == row && data[i].col == col)
				return i;
		return -1;
	}

	// Sets the value of the rowth, colth element to value
	// it returns the value assigned
	// Works like mat[row][col] = value
	public double setElement(int row, int col, double value) {
		int index = search(row, col);
		if (index == -1) {
			if (value != 0.0) {
				data[count] = new ValueItem();
				data[count].row = row;
				data[count].col = col;
				data[count].value = value;
				count++;
			}
		} else {
			if (value == 0.0) {
				data[index] = data[count - 1];
				count--;
			} else {
				data[index].value = value;
			}
		}
		return value;
	}

	// returns the value associated with the rowth, colth element
	public double getElement(int row, int col) {
		int index = search(row, col);
		return (index != -1) ? data[index].value : 0.0;
	}

	// Accessor Function that returns the SpareMatrix's size
	public int getSize() {
		return matrixSize;
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
		for (int i = 0; i < getSize(); i++)
			for (int j = 0; j < getSize(); j++)
				setElement(i, j, in.nextDouble());
	}

}
