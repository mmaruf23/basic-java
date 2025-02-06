package day2.Interfaces;
/* Interface : Kumpulan method dyang harus dipake oleh class yang mengimplementasikannya*/
public interface User {
    // Method biasa yang wajib dipake oleh class yang mengimplementasikannya.
    String getUsername();
    String getPassword();

    void addUser(String username, String password);
    int getAllUser();

    // Default method = method ini nggak perlu di override (opsional)

    default void getCompany(){
        System.out.println("Company : PT AIGEN GLOBAL TEKNOLOGI");
    }

    // Static method = method yang bisa dipanggil langsung tanpa memerlukan class (method ini nggak bisa di override).
    static void setName(String name){
        System.out.println("nama : " + name);
    }
}
