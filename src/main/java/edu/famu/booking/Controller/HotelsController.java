package edu.famu.booking.Controller;

import edu.famu.booking.Service.HotelsService;
import edu.famu.booking.Util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    private HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllHotels()
    {
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getAllHotels(), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> getHotelsById(@PathVariable String hotelID){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getHotelsById(hotelID), null));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> createHotel(@RequestBody Hotels hotel){
        try{
            payload = hotelsService.createHotel(hotel);
            statusCode = 201;
            name = "hotelId";
        } catch (ExecutionException | InterruptedException e) {
            payload = new ErrorMessage("Cannot create new hotel in database.", CLASS_NAME, e.toString());
        }

        response = new ResponseWrapper(statusCode,name, payload);

        return response.getResponse();
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Map<String,Object>> updatePost(@PathVariable(name="hotelId") String id, @RequestBody Map<String, Object> updateValues){
        try{

            hotelsService.updateHotel(id, updateValues);
            statusCode = 201;
            name = "message";
            payload = "Update successful for hotel with id " + id;

        }catch (ParseException e){
            statusCode = 400;
            payload = new ErrorMessage("Cannot parse JSON",CLASS_NAME, e.toString());
        }
        catch (Exception e) {
            payload = new ErrorMessage("Cannot update hotel with id " + id,CLASS_NAME, e.toString());
        }

        response = new ResponseWrapper(statusCode,name, payload);

        return response.getResponse();
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Map<String,Object>> removePost(@PathVariable(name="hotelId") String id){
        try{
            hotelsService.deleteHotel(id);
            statusCode = 204;
            name = "message";
            payload = "Delete successful for hotel with id " + id;
        }catch (Exception e){
            payload = new ErrorMessage("Cannot delete hotel with id " + id, CLASS_NAME, e.toString());
        }
        response = new ResponseWrapper(statusCode,name, payload);

        return response.getResponse();
    }
}