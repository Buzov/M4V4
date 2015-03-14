package matrix.entity;



import java.util.ArrayList;

import matrix.MatrixAbstract;
import matrix.MatrixInterface;
import matrix.exceptions.MatrixIndexOutOfBoundsException;

public class MatrixDoubleArray extends MatrixAbstract{
	
	private ArrayList<ArrayList<Double>> array;// = new double[10][10];
	
	public MatrixDoubleArray(int i, int j) {
		super.rows = i;
		super.cols = j;
		array = new ArrayList<>(rows);
        for (int m = 0; m < rows; m++) {
        	array.add(new ArrayList<Double>(cols));
            for (int n = 0; n < cols; n++) {
            	array.get(m).add(Double.NaN);
            }
        }
        System.out.println("Создан обьект матрицы с DoubleArray");
	}

    @Override
    public void setAmountOfRows(int rows) {
        if(cols == 0) {
            super.rows = rows;
        } else {
            super.rows = rows;
            array = new ArrayList<>(rows);
            for (int m = 0; m < rows; m++) {
                array.add(new ArrayList<Double>(cols));
                for (int n = 0; n < cols; n++) {
                    array.get(m).add(Double.NaN);
                }
            }
        }
    }

    @Override
    public void setAmountOfCols(int cols) {
        if(rows == 0) {
            super.cols = cols;
        } else {
            super.cols = cols;
            array = new ArrayList<>(rows);
            for (int m = 0; m < rows; m++) {
                array.add(new ArrayList<Double>(cols));
                for (int n = 0; n < cols; n++) {
                    array.get(m).add(Double.NaN);
                }
            }
        }
    }

    @Override
    public void setAmountOfRowsAndCols(int rows, int cols) {
        super.rows = rows;
        super.cols = cols;
        array = new ArrayList<>(rows);
        for (int m = 0; m < rows; m++) {
            array.add(new ArrayList<Double>(cols));
            for (int n = 0; n < cols; n++) {
                array.get(m).add(Double.NaN);
            }
        }
    }

	@Override
	public double getValue(int i, int j) throws MatrixIndexOutOfBoundsException {
		if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
		return array.get(i).get(j);
	}

	@Override
	public void setValue(int i, int j, double value) throws MatrixIndexOutOfBoundsException {
		if(!checkIndices(i, j)) {
			throw new MatrixIndexOutOfBoundsException("Inadmissible value of an index.");
		}
		array.get(i).set(j, (double) value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MatrixInterface clone() throws CloneNotSupportedException {
		MatrixDoubleArray newClone = (MatrixDoubleArray) super.clone();
		newClone.array = (ArrayList<ArrayList<Double>>) array.clone();
		return newClone;
	}
    @Override
    public MatrixInterface create(int size) {
        return new MatrixDoubleArray(size, size);
    }
}
