package day3.Scanner.App.Reviews;

import java.util.Scanner;

public class ReviewMain {
    public static void main(String[] args) {
        Reviews.ReviewController reviewsController = new Reviews.ReviewController();
        Scanner input = new Scanner(System.in);

        Reviews review1 = new Reviews("Reviewer1", 4);
        Reviews review2 = new Reviews("Reviewer1", 0);
        Reviews review3 = new Reviews("Reviewer1", 5);
        reviewsController.addReviews(review1);
        reviewsController.addReviews(review2);
        reviewsController.addReviews(review3);

        System.out.println("=== Review ===");
        reviewsController.showReviews();
        System.out.println("==============");

        System.out.print("Apakah anda ingin menambahkan review? (Y/N)" );
        String addReviewChoice = input.nextLine();

        if (addReviewChoice.equalsIgnoreCase("y")){
            while (true){
                System.out.print("Masukan nama reviewer : ");
                String nama = input.nextLine();
                System.out.print("Berapa rating yang diberikan : (1-5)");
                int rate = input.nextInt();
                input.nextLine();
                Reviews review = new Reviews(nama, rate);
                reviewsController.addReviews(review);
                System.out.println("Review berhasil disimpan.");
                System.out.print("Apakah ingin menambahkan review lain? (Y/N)");
                String addReviewAgain = input.nextLine();
                if (!addReviewAgain.equalsIgnoreCase("y")){
                    break;
                }
            }
        }

        System.out.println("=== Review ===");
        reviewsController.showReviews();
        System.out.println("==============");

    }
}
