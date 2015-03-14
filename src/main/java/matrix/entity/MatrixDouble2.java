package matrix.entity;


import matrix.MatrixInterface;

public class MatrixDouble2 extends MatrixDouble{
	
	public MatrixDouble2(int i, int j) {
		super(i, j);
	}
    @Override public MatrixInterface create(int size) {
        return new MatrixDouble2(size, size);
    }
}
