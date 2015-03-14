package matrix.entity;

import matrix.MatrixAbstract;
import matrix.MatrixInterface;
import matrix.exceptions.MatrixIndexOutOfBoundsException;

public class MatrixDoubleOne extends MatrixAbstract {

    protected double[] array;// = new double[10][10];

    public MatrixDoubleOne() {

    }

    public MatrixDoubleOne(int i, int j) {
        super.rows = i;
        super.cols = j;
        array = new double[i * j];
        System.out.println("Создан обьект матрицы с DoubleOne");
    }

    @Override
    public void setAmountOfRows(int rows) {
        if(cols == 0) {
            super.rows = rows;
        } else {
            super.rows = rows;
            array = new double[rows*cols];
        }
    }

    @Override
    public void setAmountOfCols(int cols) {
        if(rows == 0) {
            super.cols = cols;
        } else {
            super.cols = cols;
            array = new double[rows*cols];
        }
    }

    @Override
    public void setAmountOfRowsAndCols(int rows, int cols) {
        super.rows = rows;
        super.cols = cols;
        array = new double[rows*cols];
    }

    @Override
    public double getValue(int i, int j) throws MatrixIndexOutOfBoundsException {
    	if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
        int temp = cols * i + j;
        return array[temp];
    }

    @Override
    public void setValue(int i, int j, double value) throws MatrixIndexOutOfBoundsException {
    	if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
        int temp = cols * i + j;
        array[temp] = value;
    }

    @Override
	public MatrixInterface clone() throws CloneNotSupportedException {
    	MatrixDoubleOne newClone = (MatrixDoubleOne) super.clone();
		newClone.array = array.clone();
		return newClone;
	}
    @Override
    public MatrixInterface create(int size) {
        return new MatrixDoubleOne(size, size);
    }
}
