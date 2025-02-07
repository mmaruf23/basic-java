package day3.Equals;


public class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // method equals juga bisa di overide untuk bandingin 1 field atau beberapa field aja dalam object
    public boolean equals(Object obj) {
        if (this == obj) return true; // pertama cek jika objectnya sama.

        // cek apa objectnya null atau bukan instance/class User
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj; // downcast object ke User

        // bandingkan username dan email
        return username.equals(user.username) && email.equals(user.email);
    }

    public String getData(){return "username : " + username + ", email : " + email;}
    public String getUsername(){return username;}
}
