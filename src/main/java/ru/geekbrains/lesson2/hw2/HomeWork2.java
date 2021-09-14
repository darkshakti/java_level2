package ru.geekbrains.lesson2.hw2;

/**
 * 1. Написать метод, на вход которому подается двумерный строковый
 * массив размером 4х4. При подаче массива другого размера необходимо
 * бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int
 * и просуммировать. Если в каком-то элементе преобразование не удалось
 * (например, если в ячейке лежит символ или текст вместо числа),
 * надо бросить исключение MyArrayDataException с детализацией, в какой ячейке
 * неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class HomeWork2 {
    public static void main(String[] args) {

        String[][] arr1 = new String[][]{
                {"1", "2", "3", "3"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"2", "2", "2", "2"}
        };
        String[][] arr2 = new String[][]{
                {"1", "2", "3", "3"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"1", "2", "3", "2"},
                {"2", "2", "2", "2"}
        };
        String[][] arr3 = new String[][]{
                {"1", "2", "3", "3", "3"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"1", "2", "5", "2"}
        };
        String[][] arr4 = new String[][]{
                {"1", "2", "3", "3"},
                {"2", "2", "2", "3"},
                {"1", "2", "g", "2"},
                {"1", "2", "3", "2"}
        };
        int result = method(arr4);
        System.out.println(result);
    }

    public static int method(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
