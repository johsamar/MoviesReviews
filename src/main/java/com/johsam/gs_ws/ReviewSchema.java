//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.06.27 a las 09:43:04 PM COT 
//

package com.johsam.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para reviewSchema complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reviewSchema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="review" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="movie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reviewSchema", propOrder = {
        "id",
        "user",
        "rating",
        "review",
        "movie"
})
public class ReviewSchema {

    @XmlElement(name = "_id")
    protected String id;
    @XmlElement(required = true)
    protected String user;
    @XmlElement(required = true)
    protected double rating;
    @XmlElement(required = true)
    protected String review;
    @XmlElement(required = true)
    protected String movie;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad user.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getUser() {
        return user;
    }

    /**
     * Define el valor de la propiedad user.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Obtiene el valor de la propiedad rating.
     * 
     */
    public double getRating() {
        return rating;
    }

    /**
     * Define el valor de la propiedad rating.
     * 
     */
    public void setRating(double value) {
        this.rating = value;
    }

    /**
     * Obtiene el valor de la propiedad review.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getReview() {
        return review;
    }

    /**
     * Define el valor de la propiedad review.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setReview(String value) {
        this.review = value;
    }

    /**
     * Obtiene el valor de la propiedad movie.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getMovie() {
        return movie;
    }

    /**
     * Define el valor de la propiedad movie.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setMovie(String value) {
        this.movie = value;
    }

}
