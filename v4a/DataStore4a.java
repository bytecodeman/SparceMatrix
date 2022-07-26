package v4a;

public class DataStore4a {

	private double matrix[][];
	
	public DataStore4a(int size) {
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
	
	public int getSize() {
		return matrix.length;
	}
}
