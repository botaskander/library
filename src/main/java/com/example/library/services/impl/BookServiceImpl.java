package com.example.library.services.impl;

import com.example.library.entities.Book;
import com.example.library.entities.CupBoard;
import com.example.library.entities.Response;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.CupBoardRepository;
import com.example.library.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CupBoardRepository cupBoardRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Response saveBook(Book book) {
        String resMessage= book.getId()==null?"Книга успешно добавлена":"Изменения сохранены";
        try {
            bookRepository.save(book);
        }catch (Exception e){
            log.error("Ошибка при сохранении книги",e);
            return new Response(1,"Ошибка при сохранении книги "+e.getMessage());
        }
        return new Response(0,resMessage);
    }

    @Override
    public Response deleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
        }catch (Exception e){
            log.error("Произошла ошибка при удалении книги",e);
            return new Response(1, "Произошла ошибка при удалении книги"+e.getMessage());
        }

        return new Response(0,"Книга успешно удалена");
    }

    @Override
    public List<CupBoard> getAllCupBoards() {
        return cupBoardRepository.findAll();
    }

    @Override
    public CupBoard getCupBoard(Long id) {
        return cupBoardRepository.findById(id).get();
    }

    @Override
    public Response saveCupBoard(CupBoard cupBoard) {
        String resMessage= cupBoard.getId()==null?"Полка успешно добавлена":"Изменения сохранены";
        try {
            cupBoardRepository.save(cupBoard);
        }catch (Exception e){
            log.error("Ошибка при сохранении полки",e);
            return new Response(1,"Ошибка при сохранении полки "+e.getMessage());
        }
        return new Response(0,resMessage);
    }

    @Override
    public List<Book> getAllBooksByCupBoard(Long id) {
        return bookRepository.findAllByCupBoardId(id);
    }

    @Override
    public Response deleteCupBoard(Long id) {
        try {
            cupBoardRepository.deleteById(id);
        }catch (Exception e){
            log.error("Произошла ошибка при удалении полки",e);
            return new Response(1, "Произошла ошибка при удалении полки"+e.getMessage());
        }

        return new Response(0,"Полка успешно удалена");
    }
}
