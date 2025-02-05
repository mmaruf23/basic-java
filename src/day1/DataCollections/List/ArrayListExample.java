package day1.DataCollections.List;

import java.util.ArrayList;

/*
* ARRAY LIST : Implementasi dari interface List yang fungsinya buat nyimpen data berbentuk array
* ArrayList biasanya dipakai buat nyimpen data kompleks seperti object
* kelebihan array list dibandingkan dengan array biasa adalah kemudahan untuk memanipulasi datanya
* */
public class ArrayListExample {
    public static void main(String[] args) {
        // array biasa
        int[] arrayBiasa = new int[5];
        arrayBiasa[0] = 10;
        arrayBiasa[1] = 20;

        // array list
        ArrayList<String> daftarNama = new ArrayList<>();

        // cara nambahin data/element dke dalam arraylist
        daftarNama.add("Rifa");
        daftarNama.add("Rafi");
        daftarNama.add("Refi");

        // cara nambahin element di indeks tertentu
        daftarNama.add(3, "Rafa");

        // cara akses selemen di index tertentu
        System.out.println("data : " + daftarNama.getFirst());
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

        // buat array list dengan tipe data yang berbeda
        ArrayList<Object> dataRandom = new ArrayList<>();
        dataRandom.add("Rifa");
        dataRandom.add(23);
        dataRandom.add(true);
        dataRandom.add(3.2);

        for (Object data : dataRandom){
            System.out.println(data);
        }

    }
}
