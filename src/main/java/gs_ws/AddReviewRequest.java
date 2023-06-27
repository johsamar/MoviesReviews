//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.11.24 a las 12:31:36 AM COT 
//


package gs_ws;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="review" type="{http://spring.io/guides/gs-producing-web-service}review"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "review"
})
@XmlRootElement(name = "addReviewRequest")
public class AddReviewRequest {

    @XmlElement(required = true)
    protected Review review;

    /**
     * Obtiene el valor de la propiedad review.
     * 
     * @return
     *     possible object is
     *     {@link Review }
     *     
     */
    public Review getReview() {
        return review;
    }

    /**
     * Define el valor de la propiedad review.
     * 
     * @param value
     *     allowed object is
     *     {@link Review }
     *     
     */
    public void setReview(Review value) {
        this.review = value;
    }

}
