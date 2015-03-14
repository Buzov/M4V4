package matrix;

import matrix.entity.MatrixDouble;
import matrix.io.IO_XML;

/**
 * Created by artur on 14.03.15.
 */
public class Test {
    public static void main(String[] args) {
        String path = "./matrixNew.xml";
        MatrixInterface matrix = new MatrixDouble();
        matrix.setAmountOfRows(10);
        matrix.setAmountOfCols(10);
        matrix.initialize();
        matrix.write(path, new IO_XML());
        MatrixInterface matrixB = new MatrixDouble();
        matrixB.read(path, new IO_XML());
        matrixB.print();
    }
}
