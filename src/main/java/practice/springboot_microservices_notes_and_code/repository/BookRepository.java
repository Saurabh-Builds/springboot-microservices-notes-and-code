package practice.springboot_microservices_notes_and_code.repository;

import org.springframework.data.repository.CrudRepository;
import practice.springboot_microservices_notes_and_code.entity.Book;

public interface BookRepository extends CrudRepository <Book,Integer> {

}
