package edu.famu.booking.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.booking.Model.Hotels;
import edu.famu.booking.Model.Reviews;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class ReviewsService {
    private Firestore firestore;

    public ReviewsService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Reviews documentSnapshotToReviews(DocumentSnapshot document)
    {
        Reviews reviews = null;
        if(document.exists()){
            reviews = new Reviews(document.getId(),document.getString("hotelID"),document.getString("userID"),document.getDouble("rating"),document.getString("comment"), document.getTimestamp("date").toProto(), document.getTimestamp("createdAt"));
        }
        return reviews;
    }

    public ArrayList<Reviews> getAllReviews() throws ExecutionException, InterruptedException
    {
        CollectionReference reviewsCollection = firestore.collection("Reviews");
        ApiFuture<QuerySnapshot> future = reviewsCollection.get();

        ArrayList<Reviews> reviewsList = new ArrayList<>();

        for(DocumentSnapshot document : future.get().getDocuments()){
            Reviews reviews = documentSnapshotToReviews(document);
            if(reviews != null)
                reviewsList.add(reviews);
        }
        return reviewsList;
    }

    public Reviews getReviewsById(String reviewID) throws ExecutionException, InterruptedException {
        CollectionReference reviewsCollection = firestore.collection("Reviews");
        ApiFuture<DocumentSnapshot> future = reviewsCollection.document(reviewID).get();
        DocumentSnapshot document = future.get();

        return documentSnapshotToReviews(document);
    }
}
