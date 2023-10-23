package edu.famu.booking.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.booking.Model.Bookings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class    BookingsService {
    private Firestore firestore;

    public BookingsService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Bookings documentSnapshotToBookings(DocumentSnapshot document)
    {
        Bookings bookings = null;
        if(document.exists()){
            bookings = new Bookings(document.getId(),document.getString("userID"),document.getTimestamp("checkInDate").toProto(),
                    document.getTimestamp("checkOutDate").toProto(),document.getDouble("totalPrice"),
                    document.getString("status"),document.getString("paymentStatus"), document.getTimestamp("createdAt"));
        }
        return bookings;
    }

    public ArrayList<Bookings> getAllBookings() throws ExecutionException, InterruptedException
    {
        CollectionReference bookingsCollection = firestore.collection("Bookings");
        ApiFuture<QuerySnapshot> future = bookingsCollection.get();

        ArrayList<Bookings> bookingsList = new ArrayList<>();

        for(DocumentSnapshot document : future.get().getDocuments()){
            Bookings bookings = documentSnapshotToBookings(document);
            if(bookings != null)
                bookingsList.add(bookings);
        }
        return bookingsList;
    } // all bookings

    public Bookings getBookingsById(String bookingID) throws ExecutionException, InterruptedException {
        CollectionReference passengerCollection = firestore.collection("Bookings");
        ApiFuture<DocumentSnapshot> future = passengerCollection.document(bookingID).get();
        DocumentSnapshot document = future.get();

        return documentSnapshotToBookings(document);
    } // one booking
}
