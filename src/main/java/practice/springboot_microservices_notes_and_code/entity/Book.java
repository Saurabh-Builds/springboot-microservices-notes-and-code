package practice.springboot_microservices_notes_and_code.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {

    @Id
    private Integer bookId;

    private String bookName;

    private Double bookPrice;
}
