package entities;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;


public record Manufacturer(int id, String name, LocalDate foundationDate) {
    public String getName() {
        return name;
    }
}
