package day3.Enums;

/*
* ENUM bisa juga kaya class : punya variabel, constructor sama method seperti class
* fungsinya biar enum lebih fleksibel.*/

public enum EnumLikaClass {
    SUNDAY("Weekend"), MONDAY("Weekday");

    private String type;
    EnumLikaClass(String type) { this.type = type;}

    public String getType(){return type;}
}
