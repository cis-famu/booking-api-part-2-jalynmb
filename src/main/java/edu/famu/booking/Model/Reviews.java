package edu.famu.booking.Model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.text.ParseException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {

    @DocumentId
    private @Nullable String reviewID;
    private String hotelID;
    private String userID;
    private double rating;
    private String comment;
    private Timestamp date;
    private com.google.cloud.Timestamp createdAt;

    public void setDate(com.google.cloud.Timestamp date) throws ParseException
    {
        this.date = com.google.cloud.Timestamp.fromProto(Timestamps.parse(String.valueOf(date))).toProto();
    }

    public void setCreatedAt(com.google.cloud.Timestamp createdAt) throws ParseException
    {
        this.createdAt = com.google.cloud.Timestamp.fromProto(Timestamps.parse(String.valueOf(createdAt)));
    }
}
