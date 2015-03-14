package matrix.entity;

import matrix.MatrixAbstract;
import matrix.MatrixInterface;
import matrix.exceptions.MatrixIndexOutOfBoundsException;

public class MatrixDouble extends MatrixAbstract {

	protected double[][] array;// = new double[10][10];

    public MatrixDouble() {

    }

	public MatrixDouble(int i, int j) {
		super.rows = i;
		super.cols = j;
		array = new double[i][j];
		System.out.println("Создан обьект матрицы с Double");
	}

    @Override
    public void setAmountOfRows(int rows) {
        if(cols == 0) {
            super.rows = rows;
        } else {
            super.rows = rows;
            array = new double[rows][cols];
        }
    }

    @Override
    public void setAmountOfCols(int cols) {
        if(rows == 0) {
            super.cols = cols;
        } else {
            super.cols = cols;
            array = new double[rows][cols];
        }
    }

    @Override
    public void setAmountOfRowsAndCols(int rows, int cols) {
        super.rows = rows;
        super.cols = cols;
        array = new double[rows][cols];
    }

    @Override
	public double getValue(int i, int j) throws MatrixIndexOutOfBoundsException {
		if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
		return array[i][j];
	}

	@Override
	public void setValue(int i, int j, double value) throws MatrixIndexOutOfBoundsException {
		if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
		array[i][j] = value;
	}

	@Override
	public MatrixInterface clone() throws CloneNotSupportedException {
		MatrixDouble newClone = (MatrixDouble) super.clone();
		newClone.array = array.clone();
			for (int j = 0; j < getAmountOfRows(); j++) {
				newClone.array[j] = array[j].clone();
			}
		return newClone;
	}
    @Override
    public MatrixInterface create(int size) {
        return new MatrixDouble(size, size);
    }
}
