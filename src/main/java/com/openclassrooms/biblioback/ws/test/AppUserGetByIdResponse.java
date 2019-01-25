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
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="appUserGet" type="{http://test.ws.biblioback.openclassrooms.com}appUser"/>
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
    "appUserGet"
})
@XmlRootElement(name = "appUserGetByIdResponse")
public class AppUserGetByIdResponse {

    @XmlElement(required = true)
    protected AppUser appUserGet;

    /**
     * Obtient la valeur de la propriété appUserGet.
     * 
     * @return
     *     possible object is
     *     {@link AppUser }
     *     
     */
    public AppUser getAppUserGet() {
        return appUserGet;
    }

    /**
     * Définit la valeur de la propriété appUserGet.
     * 
     * @param value
     *     allowed object is
     *     {@link AppUser }
     *     
     */
    public void setAppUserGet(AppUser value) {
        this.appUserGet = value;
    }

}
