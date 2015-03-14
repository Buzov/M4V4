package matrix.operations;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import matrix.exceptions.MatrixIndexOutOfBoundsException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MatrixMultiplay {

    private static final Logger log = Logger.getLogger(MatrixMultiplay.class);

	public static MatrixInterface multiplay(MatrixInterface matrixA, MatrixInterface matrixB) {
		int rowsA = matrixA.getAmountOfRows();
		int colsA = matrixA.getAmountOfCols();
		int rowsB = matrixB.getAmountOfRows();
		int colsB = matrixB.getAmountOfCols();
		MatrixDouble matrixC = new MatrixDouble(rowsA, colsB);
		double temp = 0;
		long startTime = System.currentTimeMillis();
		if (colsA == rowsB) {
			for (int i = 0; i < rowsA; ++i) {
				for (int j = 0; j < colsB; ++j) {
					for (int k = 0; k < colsA; ++k) {			
							try {
								temp += matrixA.getValue(i, k) * matrixB.getValue(k, j);
							} catch (MatrixIndexOutOfBoundsException e) {

							}
					}
						try {
							matrixC.setValue(i, j, temp);
						} catch (MatrixIndexOutOfBoundsException e) {
							System.out.println(e);
						}
					temp = 0;
				}
			}

		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
        log.info("Multiplication of matrixes lasted " + time + " ms.");
		System.out
				.println("Multiplication of matrixes lasted " + time + " ms.");
		return matrixC;
	}
}
