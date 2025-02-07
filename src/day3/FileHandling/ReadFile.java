package day3.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        // gunakan absolute path (path lengkap) untuk mengakses file
        String filePath = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\FileHandling\\test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
//            for (String line; line = reader.readLine();){

        } catch (IOException e) {
//            throw new RuntimeException(e);
            e.getMessage();
        }

    }
}
