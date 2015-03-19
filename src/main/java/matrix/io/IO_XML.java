package matrix.io;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import org.apache.log4j.Logger;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by artur on 14.03.15.
 */
public class IO_XML implements IO_Interface {

    private static final Logger log = Logger.getLogger(IO_Serialization.class);

    @Override
    public MatrixInterface read(String path, MatrixInterface matrix) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(path))) {
            matrix = (MatrixDouble) xmlDecoder.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    @Override
    public void write(String path, MatrixInterface matrix) {

        long startTime = System.currentTimeMillis();
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(path))) {
            xmlEncoder.writeObject(matrix);
            xmlEncoder.flush();
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
