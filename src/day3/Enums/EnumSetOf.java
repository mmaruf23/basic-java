package day3.Enums;

import java.util.EnumSet;
import java.util.Set;
// ENUM juga bisa disimpan kedalam Set.

public class EnumSetOf {
    enum Menu {
        INDOMIE,
        PECEL_AYAM,
        ES_TEH,
        KOPI,
    }

    public static void main(String[] args) {
        // nambahin menu kedalam set
        Set<Menu> availabelMenu = EnumSet.of(Menu.INDOMIE, Menu.PECEL_AYAM);

        // nambahin menu lain
        availabelMenu.add(Menu.ES_TEH);
        availabelMenu.add(Menu.KOPI);

        // cek menu ada atau tidak
        if (availabelMenu.contains(Menu.ES_TEH)){
            System.out.println("Es teh is available");
        } else {
            System.out.println("STEH out of stock");
        }

        System.out.println("Todays menu : " + availabelMenu);
    }
}
