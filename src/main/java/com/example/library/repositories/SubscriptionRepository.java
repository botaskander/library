package com.example.library.repositories;

import com.example.library.entities.Book;
import com.example.library.entities.Student;
import com.example.library.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {

    @Query("SELECT b  FROM Book b, Subscription s where s.student.id=:studId and s.book.id=b.id "
       )
    List<Book> findAllBookByStudent(@Param("studId") Long id);

    @Query("SELECT sum(b.price)  FROM Book b, Subscription s where s.student.id=:studId and s.book.id=b.id")
    double findSumOfBooksByStudent(@Param("studId") Long id);
    List<Subscription> findAllByStudentId(Long  id);
}
