package day1.DataCollections.List;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> daftarNama = new LinkedList<>();

        // cara nambahin data/element dke dalam arraylist
        daftarNama.add("Rifa");
        daftarNama.add("Rafi");
        daftarNama.add("Refi");
        daftarNama.addFirst("Rofi");
        // cara nambahin element di indeks tertentu
        daftarNama.add(3, "Rafa");

        // cara akses selemen di index tertentu
//        System.out.println("data : " + daftarNama.getFirst());
        System.out.println("data : " + daftarNama.get(1));

        // ngubah element
        daftarNama.remove(2);
        System.out.println("Jumlah data : " + daftarNama.size());

        // ngecek apakah array list kosong
        System.out.println("Apakah array list kosong ? : " + daftarNama.isEmpty());

        // cek apakah element tertentu ada didalam arrayList
        System.out.println("Nama 'Rifa' ada dalam daftar : " + daftarNama.contains("Rifa"));

        // ngambil index element tertentu
        System.out.println("Indeks 'Rifa' : " + daftarNama.indexOf("Rifa"));

        // nampilin semua element dalma arrayList
        System.out.println("Daftar nama : " + daftarNama);

        // nampilin semua data pake looping
        for (String name : daftarNama){
            System.out.println(name);
        }


    }
}
