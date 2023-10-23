package edu.famu.booking.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.booking.Model.Hotels;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class HotelsService {
    private Firestore firestore;

    public HotelsService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Hotels documentSnapshotToHotels(DocumentSnapshot document)
    {
        Hotels hotels = null;
        if(document.exists()){
            ArrayList<String> amenities = null;
            hotels = new Hotels(document.getId(),document.getString("name"),document.getString("description"),document.getString("address"),document.getString("contactInformation"),document.getDouble("rating"), amenities, document.getTimestamp("createdAt"));
        }
        return hotels;
    }

    public ArrayList<Hotels> getAllHotels() throws ExecutionException, InterruptedException
    {
        CollectionReference hotelsCollection = firestore.collection("Hotels");
        ApiFuture<QuerySnapshot> future = hotelsCollection.get();

        ArrayList<Hotels> hotelsList = new ArrayList<>();

        for(DocumentSnapshot document : future.get().getDocuments()){
            Hotels hotels = documentSnapshotToHotels(document);
            if(hotels != null)
                hotelsList.add(hotels);
        }
        return hotelsList;
    }

    public Hotels getHotelsById(String hotelID) throws ExecutionException, InterruptedException {
        CollectionReference hotelsCollection = firestore.collection("Hotels");
        ApiFuture<DocumentSnapshot> future = hotelsCollection.document(hotelID).get();
        DocumentSnapshot document = future.get();

        return documentSnapshotToHotels(document);
    }
}
