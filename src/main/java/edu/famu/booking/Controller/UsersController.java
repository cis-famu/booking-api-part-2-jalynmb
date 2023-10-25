package edu.famu.booking.Controller;

import edu.famu.booking.Model.Hotels;
import edu.famu.booking.Model.Users;
import edu.famu.booking.Service.UsersService;
import edu.famu.booking.Util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers()
    {
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", usersService.getAllUsers(), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getUsersById(@PathVariable String userID){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", usersService.getUsersById(userID), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody Users users) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", usersService.createUsers(users), null));
        }
        catch (ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
        catch (InterruptedException e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable String id, @RequestBody Map<String,String> data){
        try{
            usersService.updateUsers(id, data);
            return ResponseEntity.ok(new ApiResponse(true, "User successfully updated",null,null));
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
        try {
            usersService.deleteUsers(userId);
            return ResponseEntity.ok(new ApiResponse(true, "User successfully deleted", null, null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }
}