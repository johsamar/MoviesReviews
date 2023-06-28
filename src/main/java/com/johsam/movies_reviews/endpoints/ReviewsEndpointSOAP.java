package com.johsam.movies_reviews.endpoints;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.johsam.gs_ws.CreateReviewRequest;
import com.johsam.gs_ws.CreateReviewResponse;
import com.johsam.gs_ws.DeleteReviewRequest;
import com.johsam.gs_ws.DeleteReviewResponse;
import com.johsam.gs_ws.GetAllReviewsResponse;
import com.johsam.gs_ws.GetReviewByIdRequest;
import com.johsam.gs_ws.GetReviewByIdResponse;
import com.johsam.gs_ws.ReviewSchema;
import com.johsam.gs_ws.ServiceStatus;
import com.johsam.gs_ws.UpdateReviewRequest;
import com.johsam.gs_ws.UpdateReviewResponse;
import com.johsam.movies_reviews.models.Review;
import com.johsam.movies_reviews.services.interfaces.ReviewsService;

@Component
@Endpoint
public class ReviewsEndpointSOAP {

    private static final String NAMESPACE_URI = "http://www.johsam.com/gs_ws";

    @Autowired
    private ReviewsService reviewsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReviewsRequest")
    @ResponsePayload
    public GetAllReviewsResponse getAllReviews() {
        GetAllReviewsResponse response = new GetAllReviewsResponse();
        try {
            List<Review> reviewListFound = reviewsService.getAll();

            for (Review review : reviewListFound) {
                ReviewSchema reviewSchema = new ReviewSchema();
                BeanUtils.copyProperties(review, reviewSchema);
                reviewSchema.setId(review.get_id());
                response.getReview().add(reviewSchema);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(),

        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createReviewRequest")
    @ResponsePayload
    public CreateReviewResponse addReview(@RequestPayload CreateReviewRequest request) {
        Review addReview = new Review();

        CreateReviewResponse response = new CreateReviewResponse();
        String message = "Review added successfully";
        BeanUtils.copyProperties(request.getReview(), addReview);
        try {
            Review reviewCreated = reviewsService.create(addReview);
            response.setServiceStatus(getServiceStatus(HttpStatus.OK.toString(), message));
            response.setReview(request.getReview());
        } catch (Exception e) {
            response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getReviewByIdRequest")
    @ResponsePayload
    public GetReviewByIdResponse getReviewId(@RequestPayload GetReviewByIdRequest request) {
        GetReviewByIdResponse response = new GetReviewByIdResponse();
        ReviewSchema reviewSchema = new ReviewSchema();
        String message = "Content Found";

        try {
            Review reviewFound = reviewsService.getById(request.getId());
            BeanUtils.copyProperties(reviewFound, reviewSchema);
            reviewSchema.setId(reviewFound.get_id());
            response.setReview(reviewSchema);
            response.setServiceStatus(getServiceStatus(HttpStatus.OK.toString(), message));
        } catch (Exception e) {
            response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReviewRequest")
    @ResponsePayload
    public DeleteReviewResponse deleteReview(@RequestPayload DeleteReviewRequest request) {
        DeleteReviewResponse response = new DeleteReviewResponse();

        try {
            Review wasDeleted = reviewsService.deleteById(request.getId());
            String message = "Content Deleted Successfully";
            response.setServiceStatus(getServiceStatus(HttpStatus.OK.toString(), message));
        } catch (Exception e) {
            response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateReviewRequest")
    @ResponsePayload
    public UpdateReviewResponse updateReview(@RequestPayload UpdateReviewRequest request) {
        Review updateReview = new Review();
        UpdateReviewResponse response = new UpdateReviewResponse();
        String message = "Content Updated Successfully";
        BeanUtils.copyProperties(request.getReview(), updateReview);
        try {
            reviewsService.update(updateReview);
            response.setServiceStatus(getServiceStatus(HttpStatus.OK.toString(), message));
        } catch (Exception e) {
            response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }
        return response;
    }

    /**
     * 
     * @param status  200, 400, 500
     * @param message message to show
     * @return ServiceStatus
     */
    private ServiceStatus getServiceStatus(String status, String message) {
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus(status);
        serviceStatus.setMessage(message);

        return serviceStatus;
    }
}
