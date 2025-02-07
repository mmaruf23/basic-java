package day3.InnerClass;

/*
* INNER CLASS : class yang berada dalam class, inner class bisa mengakases atribut dan method milik outer class
* implementasi innerclass bisa dipakai ketika kita ingin membuat struktur data object didalam object.
* atau untuk grouping antara atribut dan fungsionalitas
* */

public class OuterClass {
    private String outerVar = "20";

    public class InnerClass {
        public void display(){
            System.out.println("outer var : " + outerVar);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}

/*
* VISUAL
* const outer = {
*   outerVar: "20",
*   innerCLass: {
*       inner: outerVar
*   }
* }
* */