package day1.DataCollections.Set;

import java.util.HashSet;

/*
* HashSet : implementasi dari interface set buat nyimpen data-data yang unik (tidak boleh duplikat)
* dalam bentuk himpunan atay set.
* */
public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> himpunanNama = new HashSet<>();

        himpunanNama.add("Rifa");
        himpunanNama.add("Rafa");
        himpunanNama.add("Rifa"); // ini tidak akan ditambahkan lagi karena sudah ada.

        System.out.println("set nama : " + himpunanNama);

    }
}
