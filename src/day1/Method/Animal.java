package day1.Method;

// method overide
// class parent
public class Animal {
    public static String sound(){
        return "Aja sendiri!";
    }
}

class Cat extends Animal {
    public static String sound(){
        return "Miau aug!";
    }
}