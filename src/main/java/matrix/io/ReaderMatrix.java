package matrix.io;
import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import matrix.fabric.MatrixFabric;
import matrix.fabric.MatrixType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;


/**
 * Created by Darth Vader on 08.03.2015.
 */
public class ReaderMatrix {

    /**
     *
     * @param path Path to the matrix file.
     * @param dataType Data type which are stored in the matrix.
     * @return Returns the matrix.
     *
     */
    public static MatrixInterface readFromFile(String path, MatrixType dataType) {
        MatrixInterface matrix = null;
        int rows;
        int cols;
        try {

            Scanner in = new Scanner(new FileReader(path));
            rows = in.nextInt();
            cols = in.nextInt();
            //creates the matrix
            matrix = MatrixFabric.getObjectOfMatrix(rows, cols, dataType);

            in.useLocale(Locale.US);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix.setValue(i, j, in.nextDouble());
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("The specified file is not found!");
        }
        return matrix;
    }
}

