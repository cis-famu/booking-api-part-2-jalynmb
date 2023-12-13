package edu.famu.booking.Controller;

import edu.famu.booking.Service.ReviewsService;
import edu.famu.booking.Util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllReviews()
    {
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", reviewsService.getAllReviews(), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ApiResponse> getReviewsById(@PathVariable String reviewID){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", reviewsService.getReviewsById(reviewID), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }
}