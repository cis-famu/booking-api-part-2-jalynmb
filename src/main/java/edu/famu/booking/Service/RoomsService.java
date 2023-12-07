package edu.famu.booking.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.booking.Model.Rooms;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class RoomsService {

    private Firestore firestore;

    public RoomsService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Rooms documentSnapshotToRooms(DocumentSnapshot document)
    {
        Rooms rooms = null;
        if(document.exists()) {
            ArrayList<String> images = (ArrayList<String>) document.get("images");
            rooms = new Rooms(document.getId(), document.getString("hotelID"), document.getString("roomType"), document.getDouble("price"), document.getLong("capacity"),
                    document.getString("description"), document.getString("availability"), images, document.getTimestamp("createdAt")   );
            images = new ArrayList<>();
        }
        return rooms;

    }

    public ArrayList<Rooms> getAllRooms() throws ExecutionException, InterruptedException
    {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        ApiFuture<QuerySnapshot> future = roomsCollection.get();

        ArrayList<Rooms> roomsList = new ArrayList<>();

        for(DocumentSnapshot document : future.get().getDocuments()){
            Rooms rooms = documentSnapshotToRooms(document);
            if(rooms != null)
                roomsList.add(rooms);
        }
        return roomsList;
    }

    public Rooms getRoomsById(String roomID) throws ExecutionException, InterruptedException {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        ApiFuture<DocumentSnapshot> future = roomsCollection.document(roomID).get();
        DocumentSnapshot document = future.get();

        return documentSnapshotToRooms(document);
    }

    public String createRooms(Rooms rooms) throws ExecutionException, InterruptedException {
        String roomId = null;
        ApiFuture<DocumentReference> future = firestore.collection("Rooms").add(rooms);
        DocumentReference postRef = future.get();
        roomId = postRef.getId();

        return roomId;
    }

    public void updateRooms(String id, Map<String, String> updateValues)
    {
        String [] allowed = {"roomType", "price", "rating", "capacity", "description", "availability", "images", "createdAt"};
        List<String> list = Arrays.asList(allowed);
        Map<String, Object> formattedValues = new HashMap<>();

        for(Map.Entry<String, String> entry : updateValues.entrySet()){
            String key = entry.getKey();
            if(list.contains(key))
                formattedValues.put(key, entry.getValue());
        }
        DocumentReference RoomDoc = firestore.collection("Rooms").document(id);
        if(RoomDoc != null)
            RoomDoc.update(formattedValues);
    }

    public void deleteRooms(String roomId) {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        DocumentReference roomDoc = roomsCollection.document(roomId);

        if (roomDoc != null) {
            roomDoc.delete();
        }
    }
}
