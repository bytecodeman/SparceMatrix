package v6a;

import java.util.ArrayList;

public class DataStore6a {
	
	private static class ValueItem6a {
		int row;
		int col;
		double value;
	}
	
	private int matrixSize;
	private ArrayList<ValueItem6a> data;

	public DataStore6a(int size) {
		matrixSize = size;
		data = new ArrayList<ValueItem6a>();
	}

	private int search(int row, int col) {
		for (int i = 0; i < data.size(); i++)
			if (data.get(i).row == row && data.get(i).col == col)
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
				var vi = new ValueItem6a();
				vi.row = row;
				vi.col = col;
				vi.value = value;
				data.add(vi);
			}
		} else {
			if (value == 0.0) {
				data.remove(index);
			} else {
				data.get(index).value = value;
			}
		}
		return value;
	}

	// returns the value associated with the rowth, colth element
	public double getElement(int row, int col) {
		int index = search(row, col);
		return (index != -1) ? data.get(index).value : 0.0;
	}

	// Accessor Function that returns the SpareMatrix's size
	public int getSize() {
		return matrixSize;
	}

}
