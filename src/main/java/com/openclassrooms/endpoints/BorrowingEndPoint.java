package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.test.*;
import com.openclassrooms.services.IBorrowingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BorrowingEndPoint {
    private static final String NAMESPACE_URI = "http://test.ws.biblioback.openclassrooms.com";

    @Autowired
    private IBorrowingService borrowingService;

    public BorrowingEndPoint(IBorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    /**
     *
     * @param request
     * @return response: liste de tous les emprunts
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "borrowingGetAllRequest")
    @ResponsePayload
    public BorrowingGetAllResponse getAllBorrowings(@RequestPayload BorrowingGetAllRequest request){
        BorrowingGetAllResponse response = new BorrowingGetAllResponse();

        List<Borrowing> borrowingList = new ArrayList<>();
        List<com.openclassrooms.entities.Borrowing> borrowings = borrowingService.borrowingReport();

        for(int i = 0; i < borrowings.size(); i++){
            Borrowing b = new Borrowing();
            BeanUtils.copyProperties(borrowings.get(i), b);
            borrowingList.add(b);
        }
        response.getBorrowingGetAll().addAll(borrowingList);
        return response;
    }

    /**
     * enregistre un emprunt
     * @param request
     * @return response: confirmation booléenne que l'emprunt a été enregistré
     */
       @PayloadRoot(namespace = NAMESPACE_URI, localPart = "borrowingAddRequest")
       @ResponsePayload
       public void addBorrowing(@RequestPayload BorrowingAddRequest request){


       }

}

