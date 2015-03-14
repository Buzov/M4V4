package example;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import matrix.fabric.MatrixType;
import matrix.io.ReaderMatrix;
import matrix.io.WriterMatrix;

/**
 * Created by artur on 11.03.15.
 */
public class TestIO {
    public static void main(String[] args) {
        MatrixInterface matrix = new MatrixDouble(10, 10);
        matrix.initialize();
        WriterMatrix.write(matrix, "./txt_file/matrix.txt");
        //MatrixInterface matrix = ReaderMatrix.readFromFile("../matrix.txt", MatrixType.DOUBLE);
        //matrix.print();

    }
}
