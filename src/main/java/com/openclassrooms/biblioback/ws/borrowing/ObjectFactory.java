//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.06.19 à 06:32:49 PM CEST 
//


package com.openclassrooms.biblioback.ws.borrowing;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.openclassrooms.biblioback.ws.borrowing package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.openclassrooms.biblioback.ws.borrowing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BorrowingGetAllResponse }
     * 
     */
    public BorrowingGetAllResponse createBorrowingGetAllResponse() {
        return new BorrowingGetAllResponse();
    }

    /**
     * Create an instance of {@link Borrowing }
     * 
     */
    public Borrowing createBorrowing() {
        return new Borrowing();
    }

    /**
     * Create an instance of {@link BorrowingGetRequest }
     * 
     */
    public BorrowingGetRequest createBorrowingGetRequest() {
        return new BorrowingGetRequest();
    }

    /**
     * Create an instance of {@link BorrowingGetAllRequest }
     * 
     */
    public BorrowingGetAllRequest createBorrowingGetAllRequest() {
        return new BorrowingGetAllRequest();
    }

    /**
     * Create an instance of {@link BorrowingGetResponse }
     * 
     */
    public BorrowingGetResponse createBorrowingGetResponse() {
        return new BorrowingGetResponse();
    }

    /**
     * Create an instance of {@link BorrowingAddRequest }
     * 
     */
    public BorrowingAddRequest createBorrowingAddRequest() {
        return new BorrowingAddRequest();
    }

    /**
     * Create an instance of {@link BorrowingAddResponse }
     * 
     */
    public BorrowingAddResponse createBorrowingAddResponse() {
        return new BorrowingAddResponse();
    }

}
