package com.example.library.services;

import com.example.library.entities.Book;
import com.example.library.entities.Response;
import com.example.library.entities.Student;
import com.example.library.entities.Subscription;

import java.util.List;

public interface StudentService {
    //CRUD STUDENT
    List<Student> getAllStudents();
    Student getStudent(Long id);
    Response saveStudent(Student student);
    Response deleteStudent(Long id);

    //CRUD SUBSCRIPTION
    List<Subscription> getAllSubscriptions();
    Subscription getSubscription(Long id);
    Response saveSubscription(Subscription subscription);

    List<Subscription> getAllSubscriptionsByStudent(Long id);
    List<Book> getAllBooksByStudent(Long id);

    double  getSumOfSubscriptions(Long id);
    Response deleteSubscription(Long id);
}
