package day3.FileHandling;
import java.io.*;
public class DeleteFile {
    public static void main(String[] args) {
        String fileName = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\FileHandling\\test.txt";
        File file = new File(fileName);

        if (file.exists()){
            if (file.delete()){
                System.out.println("File berhasil dihapus!");
            }
        } else {
            System.out.println("File tidak ditemukan!");
        }
    }
}
