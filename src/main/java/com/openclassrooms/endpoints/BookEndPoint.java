package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.*;
import com.openclassrooms.entities.BookEntity;
import com.openclassrooms.services.BookService;
import com.openclassrooms.services.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BookEndPoint {
    private static final String NAMESPACE_URI = "http://book.ws.biblioback.openclassrooms.com";

    @Autowired
    private IBookService bookService;

    @Autowired
    public BookEndPoint(BookService bookService){
        this.bookService = bookService;
    }

    /**
     *
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public void addBook(@RequestPayload BookAddRequest request){

        BookEntity book = new BookEntity();
        book.setAuthorFirstName(request.getAuthorFirstName());
        book.setAuthorName(request.getAuthorName());
        book.setTitle(request.getTitle());
        bookService.addBook(book);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "bookGetRequest")
    @ResponsePayload
    public BookGetResponse getBookByName(@RequestPayload BookGetRequest request){

        BookGetResponse response = new BookGetResponse();
        Book book = new Book();
        BeanUtils.copyProperties(bookService.getBookByTitle(request.getTitle()), book);
        response.setBook(book);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "bookGetAllRequest")
    @ResponsePayload
    public BookGetAllResponse getAllBooks() {

        BookGetAllResponse response = new BookGetAllResponse();
        List<Book> books = new ArrayList<>();
        List<BookEntity> bookEntities = bookService.getAllBooks();

        for(int i = 0; i < bookEntities.size(); i++){
            Book b = new Book();
            BeanUtils.copyProperties(bookEntities.get(i), b);
            books.add(b);
        }
        response.getBookGetAll().addAll(books);
        return response;
    }



}

