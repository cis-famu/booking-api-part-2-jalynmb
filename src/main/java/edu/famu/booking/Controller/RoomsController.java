package edu.famu.booking.Controller;

import edu.famu.booking.Model.Rooms;
import edu.famu.booking.Service.RoomsService;
import edu.famu.booking.Util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRooms()
    {
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getAllRooms(), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<ApiResponse> getRoomsById(@PathVariable String roomID){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getRoomsById(roomID), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PostMapping("/rooms")
    public ResponseEntity<ApiResponse> createRoom(@RequestBody Rooms rooms) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.createRooms(rooms), null));
        }
        catch (ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
        catch (InterruptedException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<ApiResponse> updateRoom(@PathVariable String id, @RequestBody Map<String,String> data){
        try{
            roomsService.updateRooms(id, data);
            return ResponseEntity.ok(new ApiResponse(true, "Room successfully updated",null,null));
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<ApiResponse> deleteRoom(@PathVariable String roomId) {
        try {
            roomsService.deleteRooms(roomId);
            return ResponseEntity.ok(new ApiResponse(true, "Room successfully deleted", null, null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }
}