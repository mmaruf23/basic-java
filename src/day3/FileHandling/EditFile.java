package day3.FileHandling;
import java.io.*;
public class EditFile {
    public static void main(String[] args) {
        String fileName = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\FileHandling\\writed.txt";
        File file = new File(fileName);

        // buat content baru setelah pengeditan
        StringBuilder newContent = new StringBuilder();

        // cek file exist
        if (file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){

                for (String line; (line = reader.readLine()) != null;){
                    line = line.replace("programmer", "utat");
                    newContent.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                // ini buat overwrite
                writer.write(newContent.toString());
                writer.write("aja sendiri!");// tambah baru
                System.out.println("File berhasil diedit \n path : " + file.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("File tidak ditemukan \n path : " + file.getAbsolutePath());

        }
    }
}
