package ru.geekbrains.lesson2.hw2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Wrong array size!");
    }
}