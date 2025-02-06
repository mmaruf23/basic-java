package day2.BasicOOP.AccessModifier.AbstractClass;
/*
* ABSTRACT CLASS : class yang tidak bisa dibuat instance creation secara langsung
* atau tidak bisa dibuat object secara langsung hanya bisa dipake untuk membuat class, subclass dan turunannya.
* */
public abstract class Hewan {
    public String nama;
    private int umur;

    public Hewan(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    /*
    * Abstract method : method yang harus diimplementasikan oleh class turunannya.
    * kalau tidak diimplementasi, maka class turunannya juga akan menajadi abstract
    * dan tidak bisa dibuat object secara langsung.
    * */

    public abstract void makan();

    // method biasa :
    public void tidur() {
        System.out.println(nama + " lagi turu!");
    }

    // getter / setter : untuk mengambil / set data.
    public String getNama(){
        return nama;
    }

    public int getUmur(){
        return umur;
    }

}
