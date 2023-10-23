package edu.famu.booking.Controller;

import edu.famu.booking.Service.UsersService;
import edu.famu.booking.Util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}