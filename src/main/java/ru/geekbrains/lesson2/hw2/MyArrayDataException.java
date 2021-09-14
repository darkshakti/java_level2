package ru.geekbrains.lesson2.hw2;

public class MyArrayDataException extends RuntimeException {

    MyArrayDataException(int i, int j) {
        super("Can not parse value in cell [" + i + "," + j + "]");

    }

}
