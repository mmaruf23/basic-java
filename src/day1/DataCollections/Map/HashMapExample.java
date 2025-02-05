package day1.DataCollections.Map;

import java.util.HashMap;

/*
* hashMap : implementasi dari interface Map, buat nyimpen data object ke dalam bentuk key-value
* */
public class HashMapExample {
    public static void main(String[] args) {
        // HASHMAP
        HashMap<String, String> daftarNama = new HashMap<>();

        // nambahin data ke hashMap
        daftarNama.put("name", "Rifa");
        daftarNama.put("age", "23");
        daftarNama.put("job", "Admin");

        // cara akses data didalam hashMapB
        System.out.println("Nama : " + daftarNama.get("name"));
        System.out.println("Usia : " + daftarNama.get("age"));
        System.out.println("Pekerjaan : " + daftarNama.get("job"));

        // mengecek ukuran data
        System.out.println("Jumlah data : " + daftarNama.size());

        // mengecek hashMap kosong
        System.out.println("Hashmap kosong : " + daftarNama.isEmpty());


        // nempilin semua key dalam hashMap
        for (String key : daftarNama.keySet()){
            System.out.println("key : " + key);
        }
        // nampilin semua isi data dalam key hashMap
        for (String value : daftarNama.values()){
            System.out.println("data : " + value);
        }

        // nampilin semua data di hashMap pake entry set.
        for (String key : daftarNama.keySet()){
            System.out.println(key + " : " + daftarNama.get(key));
        }

        // cara ubah data di hashMap
        daftarNama.put("name", "Rafa");

        // cara hapus data berdasarkan key
        daftarNama.remove("age");
    }
}
