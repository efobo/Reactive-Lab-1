package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Review {
    private int id;
    private LocalDate date; // дата создания
    private String user; // автор
    private int rating; // оценка от 1 до 5
}

