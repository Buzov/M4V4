import matrix.entity.MatrixDouble;
import matrix.entity.MatrixDoubleOne;
import matrix.exceptions.MatrixIndexOutOfBoundsException;

public class NewClass {

	public static void main(String[] Args) {
		MatrixDouble matrix = new MatrixDouble(2, 2);
		MatrixDoubleOne matrixB = new MatrixDoubleOne(2, 2);
		try {
			matrix.setValue(0, 0, 1);
			matrix.setValue(0, 1, 2);
			matrix.setValue(1, 0, 3);
			matrix.setValue(1, 1, 4);
			matrixB.setValue(0, 0, 1);
			matrixB.setValue(0, 1, 2);
			matrixB.setValue(1, 0, 3);
			matrixB.setValue(1, 5, 4);
		} catch (MatrixIndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.print(matrix.equals(matrixB));

	}

}
