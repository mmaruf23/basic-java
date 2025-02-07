package day3.Enums;

public class Main {
    public static void main(String[] args) {
        // panggil enum : enum biasa
        EnumDay today = EnumDay.FRIDAY;

        switch (today){
            case SUNDAY :
                System.out.println("today is sunday");
                break;
            case MONDAY:
                System.out.println("today is monday");
                break;
            case THURSDAY:
                System.out.println("today is thursday");
                break;
            case WEDNESDAY:
                System.out.println("today is wednesday");
                break;
            case FRIDAY:
                System.out.println("today is friday");
                break;
        }

        // enum like class
        EnumLikaClass getToday = EnumLikaClass.MONDAY;
        System.out.println("today is " + getToday + " and it's a " + getToday.getType());
    }
}
