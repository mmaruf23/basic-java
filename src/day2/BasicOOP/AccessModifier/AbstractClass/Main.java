package day2.BasicOOP.AccessModifier.AbstractClass;

public class Main {
    public static void main(String[] args) {
        // bikin object dari turunan class hewan.
        Kucing kucingOren = new Kucing("nguyen", 2);

        // akses method
        kucingOren.makan();
        kucingOren.tidur();

        // akses getter
        System.out.println("Nama Kucing : " + kucingOren.getNama());
        System.out.println("Umur Kucing : " + kucingOren.getUmur());
    }
}
