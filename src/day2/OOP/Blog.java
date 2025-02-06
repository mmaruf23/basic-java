package day2.OOP;

/*
* ENKAPSULASI : cara untuk membatasi dan melindungi data/method dari access langsung
* untuk meningkatkan keamanan dari perubahan data yang tidak disengaja/sengaja
*/

import java.util.ArrayList;
import java.util.List;
public class Blog {

    // encapsulasi terjadi disini.
    private String title;
    private String content;

    /*
    * List : interface yang menandai bahwa variabel ini adalah sebuah List/Daftar/Array
    * Kenapa menggunakan List? karena agar bisa menggunakan ArrayList.
    * */
    private List<Comment> comments;

    public Blog(String blogTitle, String blogContent){
        title = blogTitle;
        content = blogContent;
        comments = new ArrayList<>();
    }
    // getter blog
    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String newContent){
        content = newContent;
    }

    // method blog
    public void displayInfo(){
        System.out.println("Title : " + title);
        System.out.println("Content : " + content);
    }


    // inner class
    public class Comment {
        private String author;
        private String text;

        public Comment(String name, String comment){
            author = name;
            text = comment;
        }

        // getter
        public String getAuthor(){
            return author;
        }
        public String getText(){
            return text;
        }
    }

    // method buat nambahin comment ke blog
    public void addComment(String author, String text){
        Comment newComment = new Comment(author, text);
        comments.add(newComment);
    }

    public void displayComments(){
        System.out.println("Comments : ");
        for (Comment comment : comments){
            System.out.println("Author : " + comment.getAuthor());
            System.out.println("Text : " + comment.getText());
        }
    }
}
