//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.19 à 12:22:44 PM CEST 
//


package com.openclassrooms.biblioback.ws.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="borrowingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newDueReturnDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "borrowingId",
    "newDueReturnDate"
})
@XmlRootElement(name = "borrowingExtendRequest")
public class BorrowingExtendRequest {

    protected int borrowingId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar newDueReturnDate;

    /**
     * Obtient la valeur de la propriété borrowingId.
     * 
     */
    public int getBorrowingId() {
        return borrowingId;
    }

    /**
     * Définit la valeur de la propriété borrowingId.
     * 
     */
    public void setBorrowingId(int value) {
        this.borrowingId = value;
    }

    /**
     * Obtient la valeur de la propriété newDueReturnDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNewDueReturnDate() {
        return newDueReturnDate;
    }

    /**
     * Définit la valeur de la propriété newDueReturnDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNewDueReturnDate(XMLGregorianCalendar value) {
        this.newDueReturnDate = value;
    }

}
