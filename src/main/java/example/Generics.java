package example;

import matrix.MatrixInterface;
import matrix.entity.MatrixDouble;
import matrix.entity.MatrixDoubleArray;

/**
 * Created by artur on 21.03.15.
 */
// при указании example.Generics(обобщений) можно указывать наследниками какого класса или интерфеса будут используемые типы
public class Generics<T extends MatrixInterface, E> {
    // если использовать стандартные массивы, то они не могут быть типизированы при помощи дженериков
    // необходимо использовать массивы типа Object
    private Object[] temp;
    private E temp2;

    public static void main(String[] args) {
        // создали массив матриц
        MatrixInterface[] matrixInterface = {new MatrixDouble(), new MatrixDoubleArray(10, 10)};
        // при объявлении переметой в ее типе указываем типы используемых обобщений
        // начиная с java 7 типы обобщений можно не указывать у вызываемого контсруктора<>
        Generics<MatrixInterface, String> test = new Generics<>(matrixInterface, "");
    }

    public Generics(T[] temp, E temp2) {
        this.temp = temp;
        this.temp2 = temp2;
    }

    public T getTemp(int i) {
        // при использовании Object-массивов необходимо во время возврата производить приведение типов
        return (T) temp[i];
    }

    public void setTemp(T[] temp) {
        this.temp = temp;
    }
}
