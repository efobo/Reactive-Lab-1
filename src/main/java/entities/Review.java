package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Review {
    private LocalDate reviewDate;
    private String reviewerName;
    private int rating;
    private String comment;
}

