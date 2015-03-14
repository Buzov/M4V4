package matrix.io;

import matrix.MatrixInterface;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by Darth Vader on 08.03.2015.
 */
public class WriterMatrix {
    private static final Logger log = Logger.getLogger(WriterMatrix.class);

    /**
     * This method writes down the matrix in the file.
     *
     * @param matrix Matrix which will be written in the file.
     * @param path Path to the file.
     */
    public static void write(MatrixInterface matrix, String path)  {

        //"C:/hghgjg/kgkgkgk/test.myformat"



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

        //run time
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        log.info("Recording of the file lasted " + time + " ms.");

    }

}
