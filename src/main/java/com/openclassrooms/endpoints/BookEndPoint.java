package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.GetBookRequest;
import com.openclassrooms.biblioback.ws.GetBookResponse;
import com.openclassrooms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndPoint {
    private static final String NAMESPACE_URI = "https://www.openclassrooms.com/xml/library";

    @Autowired
    private BookService bookService;

    @Autowired
    public BookEndPoint(BookService bookService){
        this.bookService = bookService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {

        GetBookResponse response = new GetBookResponse();

        return response;
    }
}

