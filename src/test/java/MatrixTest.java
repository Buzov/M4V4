import java.util.Scanner;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import matrix.fabric.MatrixFabric;
import matrix.fabric.MatrixType;
import matrix.operations.MatrixMultiplay;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class MatrixTest {

    MatrixInterface matrixA = null;
    MatrixInterface matrixB = null;
    MatrixInterface matrixC = null;

    // выполнится в начале теста
    @Before
    public void initialize() {
        int i = 10;
        int j = 10;
        int k = 10;
        int l = 10;

        String type = "1";

        if (type == "1") {
            matrixA = /*new MatrixDouble2(j, i);*/MatrixFabric.getObjectOfMatrix(i, j, MatrixType.DOUBLE);
        } else if (type == "2") {
            matrixA = MatrixFabric.getObjectOfMatrix(i, j, MatrixType.DOUBLE_ARRAY);
        } else {
            matrixA = MatrixFabric.getObjectOfMatrix(i, j, MatrixType.DOUBLE_ONE);
        }
        matrixA.initialize();


        type = "2";

        if (type == "") {
            matrixB = /*new MatrixDouble2(j, i);*/MatrixFabric.getObjectOfMatrix(k, l, MatrixType.DOUBLE);
        } else if (type == "2") {
            matrixB = MatrixFabric.getObjectOfMatrix(k, l, MatrixType.DOUBLE_ARRAY);
        } else {
            matrixB = MatrixFabric.getObjectOfMatrix(k, l, MatrixType.DOUBLE_ONE);
        }
        matrixB.initialize();
    }


    // выполница после тестов обозначенных аннотацией @Before
    // если тест будет длиться больше 1000 мс - то тест не будет пройден
    @Test(timeout=1000)
    public void multiplay() {
        matrixC = (MatrixDouble) MatrixMultiplay.multiplay(matrixA, matrixB);
    }

    // этот тест проигнорируется
    @Ignore
    @Test
    public void printMatrixAandB() {
        matrixA.print();
        matrixB.print();
    }

    // выполница в конце всех тестов
    @After
    public void print() {
        matrixC.print();
    }


}
