package com.example.library.repositories;

import com.example.library.entities.Book;
import com.example.library.entities.CupBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByCupBoardId(Long id);
}
