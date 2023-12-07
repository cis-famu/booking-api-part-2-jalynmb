package edu.famu.booking.Model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.text.ParseException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @DocumentId
    private @Nullable String userID; //Unique identifier for a user.
    private String name; //	Name of the user.
    private String email; //Email address of the user.
    private String phone; //Phone number of the user.
    private String address; //Address of the user.
    private PaymentInformation paymentInformation; //Payment information of the user, including card number, expiration date, and billing address.
    private Timestamp createdAt;


    public void setCreatedAt(Timestamp createdAt) throws ParseException
    {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(String.valueOf(createdAt)));
    }
}

