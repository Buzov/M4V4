package matrix.io;

import matrix.MatrixInterface;

import java.io.IOException;

public interface IO_Interface {

    MatrixInterface read(String path, MatrixInterface matrix);

    void write(String path, MatrixInterface matrix) throws IOException;

    void write(String path, String fileName, MatrixInterface matrix) throws IOException;

}
