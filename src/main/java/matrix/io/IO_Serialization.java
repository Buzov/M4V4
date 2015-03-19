package matrix.io;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by artur on 14.03.15.
 */
public class IO_Serialization implements IO_Interface {

    private static final Logger log = Logger.getLogger(IO_Serialization.class);

    @Override
    public MatrixInterface read(String path, MatrixInterface matrix) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            matrix = (MatrixDouble) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    @Override
    public void write(String path, MatrixInterface matrix) {

        long startTime = System.currentTimeMillis();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        log.info("Recording of the file lasted " + time + " ms.");
    }

    @Override
    public void write(String path, String fileName, MatrixInterface matrix) throws IOException {

    }
}
