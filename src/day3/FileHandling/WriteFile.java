package day3.FileHandling;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String fileName = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\FileHandling\\writed.txt";

        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("Aku adalah lelaki, ");
            writer.newLine();
            writer.write("yang tak pernah menyerah ");
            writer.newLine();
            writer.write("menjadi programmer.");

            System.out.println("===================");
            System.out.println("File berhasil dibuat \n path : " + file.getAbsolutePath());
            System.out.println("===================");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
