package com.example.library.controllers;

import com.example.library.entities.*;
import com.example.library.services.BookService;
import com.example.library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @GetMapping("/books/get-all")
    public List<Book> getAllBooks(){
            return bookService.getAllBooks();
    }

    @GetMapping("/books/get-by-id/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") Long id){
        if(bookService.getBook(id)!=null){
            return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>( "Нет книг", HttpStatus.OK);
        }
    }

    @PostMapping("/books/save")
    public Response saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/books/delete/{id}")
    public Response deleteBook(@PathVariable("id") Long id){
        return bookService.deleteBook(id);
    }

    @GetMapping("/cupboards/get-all")
    public List<CupBoard> getAllCupBoards(){
            return bookService.getAllCupBoards();
    }

    @GetMapping("/cupboards/get-by-id/{id}")
    public ResponseEntity<?> getCupBoard(@PathVariable("id") Long id){
        if(bookService.getCupBoard(id)!=null){
            return new ResponseEntity<>(bookService.getCupBoard(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>( "Нет полки", HttpStatus.OK);
        }
    }

    @PostMapping("/cupboards/save")
    public Response saveCupBoard(@RequestBody CupBoard cupBoard){
        return bookService.saveCupBoard(cupBoard);
    }

    @DeleteMapping("/cupboards/delete/{id}")
    public Response deleteCupBoard(@PathVariable("id") Long id){
        return bookService.deleteCupBoard(id);
    }
    @GetMapping("/books/get-all-by-cupboard/{id}")
    public List<Book> getAllBooksByCupBoard(@PathVariable("id") Long id){
       return bookService.getAllBooksByCupBoard(id);
    }
    @GetMapping("/students/get-all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/get-by-id/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id){
        if(studentService.getStudent(id)!=null){
            return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>( "Нет студента", HttpStatus.OK);
        }
    }

    @PostMapping("/students/save")
    public Response saveBook(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students/delete/{id}")
    public Response deleteStudent(@PathVariable("id") Long id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("/subscriptions/get-all")
        public List<Subscription> getAllSubscriptions(){
            return studentService.getAllSubscriptions();
    }

    @GetMapping("/subscriptions/get-by-id/{id}")
    public ResponseEntity<?> getSubscription(@PathVariable("id") Long id){
        if(studentService.getSubscription(id)!=null){
            return new ResponseEntity<>(studentService.getSubscription(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>( "Нет такого учета", HttpStatus.OK);
        }
    }

    @PostMapping("/subscriptions/save")
    public Response saveSubscription(@RequestBody Subscription subscription){
        return studentService.saveSubscription(subscription);
    }

    @DeleteMapping("/subscriptions/delete/{id}")
    public Response deleteSubscription(@PathVariable("id") Long id){
        return studentService.deleteSubscription(id);
    }

    @GetMapping("/subscriptions/get-all-by-student/{id}")
    public List<Subscription> getAllSubscriptionsByStudent(@PathVariable("id") Long id){
        return studentService.getAllSubscriptionsByStudent(id);
    }

    @GetMapping("/books/get-all-by-student/{id}")
    public List<Book> getAllBookByStudent(@PathVariable("id") Long id){
        return studentService.getAllBooksByStudent(id);
    }
    @GetMapping("/subscriptions/get-sum-by-student/{id}")
    public double getAllSumByStudent(@PathVariable("id") Long id){
        return studentService.getSumOfSubscriptions(id);
    }



}
