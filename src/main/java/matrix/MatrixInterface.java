package matrix;

import matrix.exceptions.MatrixIndexOutOfBoundsException;
import matrix.io.IO_Interface;
import java.io.Serializable;

public interface MatrixInterface extends Serializable {

	int getAmountOfRows();

    void setAmountOfRows(int rows);

	int getAmountOfCols();

    void setAmountOfCols(int cols);

    void setAmountOfRowsAndCols(int rows, int cols);

	double getValue(int i, int j) throws MatrixIndexOutOfBoundsException;

	void setValue(int i, int j, double value) throws MatrixIndexOutOfBoundsException;

	void print();

	void initialize();
	
	void initialize(int number);
	
	void transpone();

	String toStringSlow();

    MatrixInterface create(int size);

    @Override
	String toString();

	@Override
	boolean equals(Object obj);

    double getDeterminant();

    void read(String path, IO_Interface io);

    void write(String path, IO_Interface io);





    //@Override
	//MatrixInterface clone() throws CloneNotSupportedException;

}
