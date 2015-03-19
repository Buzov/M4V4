package matrix;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import matrix.exceptions.MatrixIndexOutOfBoundsException;
import matrix.io.IO_Interface;

public abstract class MatrixAbstract implements MatrixInterface, Cloneable {

	protected int rows = 0;
	protected int cols = 0;
    protected static final long serialVersionUID = 8433147861334322335L;

	@Override
	public int getAmountOfRows() {
		return rows;
	}

	@Override
	public int getAmountOfCols() {
		return cols;
	}

	@Override
	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					System.out.format("%.3f", getValue(i, j));
				} catch (MatrixIndexOutOfBoundsException e) {
					System.out.println(e);
				}
				System.out.print("    ");
			}
			System.out.println();
		}
	}

	@Override
	public void initialize() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					setValue(i, j, Math.random() * 20 - 10);
				} catch (MatrixIndexOutOfBoundsException e) {
					System.out.println(e);
				}
			}
		}
	}

	@Override
	public void initialize(int number) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					setValue(i, j, number);
				} catch (MatrixIndexOutOfBoundsException e) {
					System.out.println(e);
				}
			}
		}
	}

	public static BigDecimal roundNumber(double value, int digits) {
		// we approximate the transferred number "value" with accuracy "digits"
		BigDecimal num = new BigDecimal("" + value).setScale(digits,
				BigDecimal.ROUND_HALF_UP);
		return num;
	}

	public void transpone() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i != j) {
					try {
						setValue(i, j, getValue(j, i));
					} catch (MatrixIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
			}
		}
	}

	protected boolean checkIndices(int rows, int cols) {
		if ((rows < 0) || (cols < 0) || (rows >= this.rows) || (cols >= this.cols)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		String s = "";
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					s += getValue(i, j);
				} catch (MatrixIndexOutOfBoundsException e) {
					System.out.println(e);
				}
			}
			s += "\r\n";
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out
				.println("Multiplication of matrixes lasted " + time + " ms.");
		return s;
	}

	@Override
	public String toStringSlow() {
		long startTime = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					stringBuilder.append(getValue(i, j));
				} catch (MatrixIndexOutOfBoundsException e) {
					System.out.println(e);
				}
				stringBuilder.append(" ");
			}
			stringBuilder.append("\r\n");
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out
				.println("Multiplication of matrixes lasted " + time + " ms.");
		return stringBuilder.toString();

	}

	@Override
	public boolean equals(Object obj) {

		// если мы проверяем объек с самим собой
		if (obj == this) {
			return true;
		}

		/* obj ссылается на null */
		if (obj == null) {
			return false;
		}

		/* Удостоверимся, что ссылки имеют тот же самый тип */

		/*
		 * if (!(getClass() == obj.getClass())) { return false; }
		 */
		MatrixInterface matrixB;

		// если объект реализует интерфейс MatrixInterface
		if (!(obj instanceof MatrixInterface)) {
			return false;
		} else {
			matrixB = (MatrixInterface) obj;
		}
		int rowsB = matrixB.getAmountOfRows();
		int colsB = matrixB.getAmountOfCols();
		boolean c = true;

		// проверяем размер матриц
		if (colsB != cols || rows != rowsB) {
			c = false;
			System.out.println("Матрицы не одинакового размера");
		} else {
			// проверяем все элементы матриц между собой
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colsB; j++) {
					try {
						if (getValue(i, j) != matrixB.getValue(i, j)) {
							return false;
						}
					} catch (MatrixIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
			}
		}
		return c;
	}
    public double getDeterminant() {
        double calcResult = 0.0;
        if (getAmountOfRows() == 2) {
            calcResult = getValue(0, 0) * getValue(1, 1) - getValue(1, 0) * getValue(0, 1);
        } else {
            int koeff = 1;
            for (int i = 0; i < getAmountOfRows(); i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                calcResult += koeff * getValue(0, i) * getMinor(this, 0, i).getDeterminant();
            }
        }
        return calcResult;
    }

    protected MatrixInterface getMinor(MatrixInterface mas, int row, int column) {
        int minorLength = mas.getAmountOfRows()- 1;
        MatrixInterface minor = create(minorLength);
        int dI = 0;
        int dJ = 0;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor.setValue(i - dI, j - dJ, mas.getValue(i, j));
                    }
                }
            }
        }
        return minor;
    }
    public MatrixInterface getInvert() {
        MatrixInterface C = create(getAmountOfRows());
        double determ = getDeterminant();
        double minor = 0;
        for (int i = 0; i < getAmountOfRows(); i++) {
            for (int j = 0; j < getAmountOfRows(); j++) {
                minor = getMinor(this, i, j).getDeterminant();
                C.setValue(j, i, (1 / determ) * Math.pow(-1, i + j) * minor);
            }
        }
        return C;
    }

    public void read(String path, IO_Interface io) {
        MatrixInterface matrix = io.read(path, this);
        int rows = matrix.getAmountOfRows();
        int cols = matrix.getAmountOfCols();
        setAmountOfRowsAndCols(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    setValue(i, j, matrix.getValue(i, j));
                } catch (MatrixIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void write(String path, IO_Interface io) throws IOException {
        io.write(path, this);
    }

    public void write(String path, String fileName, IO_Interface io) throws IOException {
        io.write(path, this);
    }

    public void setClipboard() {

    }

}
