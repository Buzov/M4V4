package matrix.io;

import matrix.MatrixInterface;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by artur on 14.03.15.
 */
public class IO_Txt implements IO_Interface {

    private static final Logger log = Logger.getLogger(IO_Txt.class);

    @Override
    public MatrixInterface read(String path, MatrixInterface matrix) {
        int rows;
        int cols;
        try {

            Scanner in = new Scanner(new FileReader(path));
            rows = in.nextInt();
            cols = in.nextInt();
            matrix.setAmountOfRowsAndCols(rows, cols);
            //matrix = MatrixFabric.getObjectOfMatrix(rows, cols, dataType);

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


    @Override
    public void write(String path, MatrixInterface matrix) {
        int rows = matrix.getAmountOfRows();
        int cols = matrix.getAmountOfCols();

        BufferedWriter buffer = null;

        long startTime = System.currentTimeMillis();

        try/*(BufferedWriter buffer = new BufferedWriter(new FileWriter(path)))*/ {
            buffer = new BufferedWriter(new FileWriter(path));
            buffer.write(rows + " " + cols + "\r\n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    buffer.write(matrix.getValue(i, j) + " ");
                }
                buffer.write("\r\n");
            }
        } catch (IOException e) {
            System.out.println("It is not possible to make record in the specified file.");
        } finally {
            try {
                buffer.flush();
                buffer.close();
            } catch (IOException ex) {
                log.error("Error write");
            }

        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        log.info("Recording of the file lasted " + time + " ms.");
    }
}
