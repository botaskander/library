package com.example.library.services;

import com.example.library.entities.Book;
import com.example.library.entities.CupBoard;
import com.example.library.entities.Response;
import com.example.library.entities.Student;

import java.util.List;

public interface BookService {
    //CRUD BOOK
    List<Book> getAllBooks();
    Book getBook(Long id);
    Response saveBook(Book book);

    Response deleteBook(Long id);

    //CRUD CUPBOARD
    List<CupBoard> getAllCupBoards();
    CupBoard getCupBoard(Long id);
    Response saveCupBoard(CupBoard cupBoard);

    List<Book> getAllBooksByCupBoard(Long id);
    Response deleteCupBoard(Long id);
}
