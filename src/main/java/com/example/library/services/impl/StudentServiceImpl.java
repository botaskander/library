package com.example.library.services.impl;


import com.example.library.entities.Book;
import com.example.library.entities.Response;
import com.example.library.entities.Student;
import com.example.library.entities.Subscription;
import com.example.library.repositories.StudentRepository;
import com.example.library.repositories.SubscriptionRepository;
import com.example.library.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Response saveStudent(Student student) {
        String resMessage= student.getId()==null?"Студент успешно добавлен":"Изменения сохранены";
        try {
            studentRepository.save(student);
        }catch (Exception e){
            log.error("Ошибка при сохранении студента",e);
            return new Response(1,"Ошибка при сохранении студента "+e.getMessage());
        }
        return new Response(0,resMessage);
    }

    @Override
    public Response deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            log.error("Произошла ошибка при удалении студента",e);
            return new Response(1, "Произошла ошибка при удалении студента"+e.getMessage());
        }

        return new Response(0,"Студент успешно удален");
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    @Override
    public Response saveSubscription(Subscription subscription) {
        String resMessage= subscription.getId()==null?"Учет успешно добавлен":"Изменения сохранены";
        try {
            subscriptionRepository.save(subscription);
        }catch (Exception e){
            log.error("Ошибка при сохранении учета",e);
            return new Response(1,"Ошибка при сохранении учета "+e.getMessage());
        }
        return new Response(0,resMessage);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByStudent(Long  id) {
        return subscriptionRepository.findAllByStudentId(id);
    }

    @Override
    public List<Book> getAllBooksByStudent(Long id) {
        return  subscriptionRepository.findAllBookByStudent(id);
    }

    @Override
    public double getSumOfSubscriptions(Long id) {
        return subscriptionRepository.findSumOfBooksByStudent(id)!=0?subscriptionRepository.findSumOfBooksByStudent(id):0;
    }

    @Override
    public Response deleteSubscription(Long id) {
        try {
            subscriptionRepository.deleteById(id);
        }catch (Exception e){
            log.error("Произошла ошибка при удалении учета",e);
            return new Response(1, "Произошла ошибка при удалении учета"+e.getMessage());
        }

        return new Response(0,"Учет успешно удален");
    }
}
