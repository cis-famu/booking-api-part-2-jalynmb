package edu.famu.booking.Model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {

    @DocumentId
    private @Nullable String hotelID;
    private String name;
    private String description;
    private String address;
    private String contactInformation;
    private double  rating;
    private ArrayList<String> amenities;
    private Timestamp createdAt;

    public void setCreatedAt(Timestamp createdAt) throws ParseException
    {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(String.valueOf(createdAt)));
    }
}
