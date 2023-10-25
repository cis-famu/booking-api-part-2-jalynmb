package edu.famu.booking.Controller;

import edu.famu.booking.Model.Hotels;
import edu.famu.booking.Model.Rooms;
import edu.famu.booking.Service.HotelsService;
import edu.famu.booking.Util.ApiResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.glassfish.jersey.internal.Errors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    private HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllHotels() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getAllHotels(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> getHotelsById(@PathVariable String hotelID) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getHotelsById(hotelID), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createHotel(@RequestBody Hotels hotels) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.createHotels(hotels), null));
        }
        catch (ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
        catch (InterruptedException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> updateHotel(@PathVariable String id, @RequestBody Map<String,String> data){
        try{
            hotelsService.updateHotels(id, data);
            return ResponseEntity.ok(new ApiResponse(true, "Hotel successfully updated",null,null));
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String hotelId) {
        try {
            hotelsService.deleteHotels(hotelId);
            return ResponseEntity.ok(new ApiResponse(true, "Hotel successfully deleted", null, null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }
}

