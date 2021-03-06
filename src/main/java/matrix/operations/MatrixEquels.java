package matrix.operations;

import matrix.MatrixInterface;
import matrix.exceptions.MatrixIndexOutOfBoundsException;

public class MatrixEquels {

	public static boolean equels(MatrixInterface matrixA, MatrixInterface matrixB) {
		int rowsA = matrixA.getAmountOfRows();
		int colsA = matrixA.getAmountOfCols();
		int rowsB = matrixB.getAmountOfRows();
		int colsB = matrixB.getAmountOfCols();
		boolean c = true;

		if (colsB != colsA || rowsA != rowsB) {
			c = false;
			System.out.println("Матрицы не одинакового размера");
		} else {
			for (int i = 0; i < rowsA; i++) {
				for (int j = 0; j < colsB; j++) {
					try {
						if (matrixA.getValue(i, j) != matrixB.getValue(i, j)) {
							return false;
						}
					} catch (MatrixIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
			}
		}
		return c;
	}
}
