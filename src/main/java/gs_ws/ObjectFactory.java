//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.11.24 a las 12:31:36 AM COT 
//


package gs_ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.song_soap.gs_ws package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.song_soap.gs_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddReviewRequest }
     * 
     */
    public AddReviewRequest createAddReviewRequest() {
        return new AddReviewRequest();
    }

    /**
     * Create an instance of {@link Review }
     * 
     */
    public Review createReviewInfo() {
        return new Review();
    }

    /**
     * Create an instance of {@link AddReviewResponse }
     * 
     */
    public AddReviewResponse createAddReviewResponse() {
        return new AddReviewResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link GetReviewByIdRequest }
     * 
     */
    public GetReviewByIdRequest createGetReviewByIdRequest() {
        return new GetReviewByIdRequest();
    }

    /**
     * Create an instance of {@link GetReviewByIdResponse }
     * 
     */
    public GetReviewByIdResponse createGetReviewByIdResponse() {
        return new GetReviewByIdResponse();
    }

    /**
     * Create an instance of {@link GetReviewByNameRequest }
     * 
     */
    public GetReviewByNameRequest createGetReviewByNameRequest() {
        return new GetReviewByNameRequest();
    }

    /**
     * Create an instance of {@link GetReviewByNameResponse }
     * 
     */
    public GetReviewByNameResponse createGetReviewByNameResponse() {
        return new GetReviewByNameResponse();
    }

    /**
     * Create an instance of {@link GetAllReviewsRequest }
     * 
     */
    public GetAllReviewsRequest createGetAllReviewsRequest() {
        return new GetAllReviewsRequest();
    }

    /**
     * Create an instance of {@link GetAllReviewsResponse }
     * 
     */
    public GetAllReviewsResponse createGetAllReviewsResponse() {
        return new GetAllReviewsResponse();
    }

    /**
     * Create an instance of {@link UpdateReviewRequest }
     * 
     */
    public UpdateReviewRequest createUpdateReviewRequest() {
        return new UpdateReviewRequest();
    }

    /**
     * Create an instance of {@link UpdateReviewResponse }
     * 
     */
    public UpdateReviewResponse createUpdateReviewResponse() {
        return new UpdateReviewResponse();
    }

    /**
     * Create an instance of {@link DeleteReviewRequest }
     * 
     */
    public DeleteReviewRequest createDeleteReviewRequest() {
        return new DeleteReviewRequest();
    }

    /**
     * Create an instance of {@link DeleteReviewResponse }
     * 
     */
    public DeleteReviewResponse createDeleteReviewResponse() {
        return new DeleteReviewResponse();
    }

}
