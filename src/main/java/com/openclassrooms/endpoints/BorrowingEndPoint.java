package com.openclassrooms.endpoints;

import com.openclassrooms.services.BorrowingService;
import com.openclassrooms.services.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BorrowingEndPoint {
    private static final String NAMESPACE_URI = "http://ws.biblioback.openclassrooms.com";

    @Autowired
    private IBorrowingService borrowingService;

    public BorrowingEndPoint(IBorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    /**
     *
     * @param request
     */

}

