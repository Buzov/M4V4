import matrix.entity.MatrixDouble;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTestClone {

    @Test//(expected=CloneNotSupportedException.class)
    public void test() throws CloneNotSupportedException {
		MatrixDouble matrixDouble = new MatrixDouble(10, 10);
		matrixDouble.initialize();
		MatrixDouble matrixDoubleClone = null;
		//try {
			matrixDoubleClone = (MatrixDouble) matrixDouble.clone();
		//} catch (CloneNotSupportedException e) {
			//e.printStackTrace();
			//System.out.println(e);
		//}
        assertTrue(matrixDouble.equals(matrixDoubleClone));
	}

}
