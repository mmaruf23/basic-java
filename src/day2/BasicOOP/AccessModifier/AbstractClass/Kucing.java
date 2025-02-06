package day2.BasicOOP.AccessModifier.AbstractClass;

public class Kucing extends Hewan {

    public Kucing(String nama, int umur){
        // kata kunci super buat make variabel yang dimiliki parent.
        super(nama, umur);

    }
    // meng-overrode method makan yang dimiliki class parent.
    @Override
    public void makan(){
        System.out.println(nama + " sedang makan whiskas!");
    }
}
