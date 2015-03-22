package matrix;

import matrix.entity.MatrixDouble;
import matrix.io.IO_Txt;
import matrix.io.IO_XML;

import java.io.IOException;

/**
 * Created by artur on 14.03.15.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String path = "./path/matrix";
        MatrixInterface matrix = new MatrixDouble();
        matrix.setAmountOfRows(10);
        matrix.setAmountOfCols(10);
        matrix.initialize();
        matrix.writeInTheBuffer();
        matrix.write(path, new IO_Txt());
        MatrixInterface matrixB = new MatrixDouble();
        matrixB.read(path, new IO_Txt());
        matrixB.print();
    }
}
