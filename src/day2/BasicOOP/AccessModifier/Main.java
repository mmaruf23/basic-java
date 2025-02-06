package day2.BasicOOP.AccessModifier;

public class Main {
    public static void main(String[] args) {

        // panggil class didalam object baru
        Person person1 = new Person("Dimas", 30, "Depok");
        Person person2 = new Person("Maruf", 23, "Banten");
        Person person3 = new Person("Alwi", 30, "Tangsel");

        // panggil method
        person1.displayInfo();
        person2.displayInfo();
        person3.displayInfo();

        Person.displayTotalPerson();

        // akses datanya
        System.out.println("public access : " + person1.name);
//        System.out.println("private access : " + person1.age); // akan error karen akasesnya private
        System.out.println("protected access : " + person1.address);
        System.out.println("final access : " + person1.NATIONALITY);

        /*
        * Kapan harus implementasi access modifier?
        * public : biasa dipakai untuk class atay method2 yang biasanya bisa dipanggil dimana aja
        * private : biasanya dipakai untuk mendeklarasikan variabel class dimana tidak bisa sembarangan diubah
        * final : ketika kita mau mendefinisikan nilai default yang konstant untuk suatu variabel
        * */
    }
}
