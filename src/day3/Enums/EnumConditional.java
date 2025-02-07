package day3.Enums;

public class EnumConditional {
    enum userStatus {
        ACTIVE, NONACTIVE, BANNED;
    }

    static class User {
        private String name;
        private userStatus status;

        public User(String name, userStatus status){
            this.name = name;
            this.status = status;
        }

        public void setStatus(userStatus status){this.status = status;}
        public  void cekStatus(){
            System.out.println("User " + name + " is " + status);
        }
    }

    public static void main(String[] args) {
        userStatus user1 = userStatus.ACTIVE;

        if (user1 == userStatus.ACTIVE){
            System.out.println("User is Active");
        } else {
            System.out.println("User is non-active");
        }

        User rifa = new User("rifa", userStatus.ACTIVE);
        System.out.println("=== Check Status ===");
        rifa.cekStatus();

        System.out.println(("=== Update Status ==="));
        rifa.setStatus(userStatus.BANNED);
        rifa.cekStatus();
    }

}
