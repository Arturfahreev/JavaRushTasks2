package com.javarush.task.task19.task1917;

import java.io.*;
import java.util.Arrays;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private PrintStream printStream;
    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
        this.printStream = new PrintStream(System.out);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
        this.printStream = new PrintStream(System.out);
    }
    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
        this.printStream = new PrintStream(System.out);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
        this.printStream = new PrintStream(System.out);
    }
    public FileConsoleWriter(FileDescriptor fileDescriptor) throws IOException {
        this.fileWriter = new FileWriter(fileDescriptor);
        this.printStream = new PrintStream(System.out);

    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        this.printStream.println(Arrays.copyOfRange(cbuf, off, off + len));

    }
    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        this.printStream.println(c);

    }
    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        this.printStream.println(str);

    }
    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        this.printStream.println(str.substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        this.printStream.println(cbuf);

    }
    public void close() throws IOException {
        this.fileWriter.close();
        this.printStream.close();

    }

    public static void main(String[] args) {

    }

}
