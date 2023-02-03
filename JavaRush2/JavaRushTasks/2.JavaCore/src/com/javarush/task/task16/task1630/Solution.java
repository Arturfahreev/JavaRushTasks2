package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName;
        String result = "";
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            if (this.isAlive()) {
                return "";
            } else return this.result;
        }

        @Override
        public void run() throws RuntimeException {
            BufferedReader fileReader = null;
            String str;
            try {
                fileReader = new BufferedReader(new FileReader(this.fullFileName));
                while ((str = fileReader.readLine()) != null) {
                    this.result += str + " ";
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}
