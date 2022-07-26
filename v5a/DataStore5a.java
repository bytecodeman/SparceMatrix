package v5a;

public class DataStore5a {

	private static final int MAXCOUNT = 100;
	private int matrixSize;
	private int count;
	private ValueItem5a data[];

	public DataStore5a(int size) {
		matrixSize = size;
		count = 0;
		data = new ValueItem5a[MAXCOUNT];
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
				data[count] = new ValueItem5a();
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
	
	public int getSize() {
		return matrixSize;
	}
}
