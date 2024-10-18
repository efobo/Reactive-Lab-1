package entities;

import java.time.LocalDate;

public class Review {
    private LocalDate reviewDate;
    private String reviewerName;
    private int rating;
    private String comment;

    public Review(LocalDate reviewDate, String reviewerName, int rating, String comment) {
        this.reviewDate = reviewDate;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
    }


    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

