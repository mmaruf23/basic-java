package day3.Enums;

/*
* ENUM TEST
* Buat class untuk mengelola hak akses user menggunakan role dengan spesifikasi berikut :
* 1. buat enum userAkses dengan nilai : CREATE, EDIT, DELETE, DISPLAY_DASBOARD dan USER_MANAGEMENT
* 2. buat enum role yang masing-masing rola punya akses berikut :
*    - ADMIN punya semua akses
*    - EDITOR punya akses CREATE, EDIT dan DISPLAY_DASHBOARD
*    - GUEST cuma punya akses DISPLAY_DASHBOARD
* 3. buat class User dengan atribut name dan role
* 4. buat method untuk validasi dan menampilkan apakah user punya akses tertentu
* 5. buat main method untuk eksekusinya didalam satu file ini.
* */


import java.util.EnumSet;

public class Test {
    private enum UserAccess {
        CREATE, EDIT, DELETE, DISPLAY_DASHBOARD,USER_MANAGEMENT;
    }

    private enum Role {
        ADMIN(EnumSet.of(UserAccess.CREATE, UserAccess.EDIT, UserAccess.DELETE, UserAccess.DISPLAY_DASHBOARD, UserAccess.USER_MANAGEMENT)),
        EDITOR(EnumSet.of(UserAccess.CREATE, UserAccess.EDIT, UserAccess.DISPLAY_DASHBOARD)),
        GUEST(EnumSet.of(UserAccess.DISPLAY_DASHBOARD));

        private EnumSet<UserAccess> accesses;

        Role(EnumSet<UserAccess> accesses) {
            this.accesses = accesses;
        }
    }

    public static class User {
        public String name;
        public Role role;

        public User(String name, Role role){
            this.name = name;
            this.role = role;
        }

        public void checkAccess(UserAccess access){
            if (role.accesses.contains(access)){
                System.out.println(name + " adalah " + role + " dan punya akses " + access);
            } else {
                System.out.println(name + " adalah " + role + " maka tidak punya akses " + access);
            }
        }

        public void showAccess(){
            System.out.println(name + " memiliki akses : " + role.accesses);
        }
    }

    public static void main(String[] args) {
        User fachri = new User("Fachri",Role.ADMIN);
        fachri.checkAccess(UserAccess.CREATE);

        User rido = new User("Rido", Role.GUEST);
        rido.checkAccess(UserAccess.CREATE);

        User darma = new User("Dharma", Role.EDITOR);
        darma.checkAccess(UserAccess.DELETE);
        darma.showAccess();
    }
}
