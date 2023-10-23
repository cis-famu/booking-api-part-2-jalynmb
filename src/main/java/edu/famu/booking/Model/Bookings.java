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
public class Bookings {

    @DocumentId
    private @Nullable String bookingID;
    private String userID;
    private Timestamp checkInDate;
    private Timestamp checkOutDate;
    private double totalPrice;
    private String status;
    private String paymentStatus;
    private com.google.cloud.Timestamp createdAt;

    public void setCheckInDate(Timestamp checkInDate) throws ParseException
    {
        this.checkInDate = com.google.cloud.Timestamp.fromProto(Timestamps.parse(String.valueOf((checkInDate)))).toProto();
    }

    public void setCheckOutDate(Timestamp checkOutDate) throws ParseException
    {
        this.checkOutDate = com.google.cloud.Timestamp.fromProto(Timestamps.parse(String.valueOf(checkOutDate))).toProto();
    }

    public void setCreatedAt(com.google.cloud.Timestamp createdAt) throws ParseException
    {
        this.createdAt = com.google.cloud.Timestamp.fromProto(Timestamps.parse(String.valueOf(createdAt)));
    }

}
