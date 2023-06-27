package com.johsam.movies_reviews.endpoints;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.johsam.movies_reviews.models.Review;
import com.johsam.movies_reviews.services.interfaces.ReviewsService;

import gs_ws.*;

@Endpoint
public class ReviewsEndpoints {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    @Autowired
    ReviewsService reviewsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addReviewRequest")
    @ResponsePayload
    public AddReviewResponse addReview(@RequestPayload AddReviewRequest request) {
        Review addReview = new Review();
        AddReviewResponse response = new AddReviewResponse();
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
        ReviewSchema songInfo = new ReviewSchema();
        String message = "Content Found";

        try {
            Review songFound = reviewsService.getById(request.getId());
            BeanUtils.copyProperties(songFound, songInfo);
            response.setReview(songInfo);
            response.setServiceStatus(getServiceStatus(HttpStatus.OK.toString(), message));
        } catch (Exception e) {
            response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReviewsRequest")
    @ResponsePayload
    public GetAllReviewsResponse getAllReviews() {
        GetAllReviewsResponse response = new GetAllReviewsResponse();
        try {
            List<Review> reviewListFound = reviewsService.getAll();

            for (Review review : reviewListFound) {
                ReviewSchema reviewSchema = new ReviewSchema();
                BeanUtils.copyProperties(review, reviewSchema);
                response.getReview().add(reviewSchema);
            }
        } catch (Exception e) {
            // response.setServiceStatus(getServiceStatus(HttpStatus.BAD_REQUEST.toString(),
            // e.getMessage()));
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

    private ServiceStatus getServiceStatus(String status, String message) {
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus(status);
        serviceStatus.setMessage(message);

        return serviceStatus;
    }
}
