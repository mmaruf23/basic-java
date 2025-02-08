package day3.Scanner.App.Reviews;

// buat menu review yang bisa nambahin nama reviewer dan rating (int), kemudian tampilin semua review.

import java.util.*;

public class Reviews {
    private String name;
    private int rate;

    public Reviews (String name, int rate){
        this.name = name;
        if (rate > 5){
            this.rate = 5;
        } else if (rate < 1){
            this.rate = 1;
        } else {
            this.rate = rate;
        }

    }

    public static class ReviewController {
        private final List<Reviews> reviewsList;

        public ReviewController() {
            this.reviewsList = new ArrayList<>();
        }

        public void addReviews(Reviews review){
            reviewsList.add(review);
        }

        public void showReviews(){
            if (!reviewsList.isEmpty()){
                System.out.println("Rate reviews : ");
                for (Reviews reviews : reviewsList){
                    System.out.println(" Nama : " + reviews.name + ", Rating : " + reviews.rate);
                }
            } else {
                System.out.println(" Tidak ada data reviews untuk ditampilkan.");
            }
        }
    }
}
