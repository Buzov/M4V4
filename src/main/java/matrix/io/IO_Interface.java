package matrix.io;

import matrix.MatrixInterface;

public interface IO_Interface {

    MatrixInterface read(String path, MatrixInterface matrix);

    void write(String path, MatrixInterface matrix);

}
