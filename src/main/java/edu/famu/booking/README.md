[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/hP86jo5x)


### Part 1 Required Stories

- [x] Create a Firebase database for your application. . ***(3 points)***
    - The names of class fields should match the names presented in the last coding assignment (this includes casing)-
    - Add a createdAt field to each table
    - Include sample data
- [x] Create an endpoint for each of the major classes (Hotel, Room, User) ***(6 points)***
    - Create the required models, controllers, and services
    - Each controller should have at least 2 methods
        - Get all
        - Get by id
- [x] Document endpoints. ***(1 point)***
    - Add to the README file the URI for each endpoint and a description (see example below)

All URIs start with: `http://localhost:8080/api/v1`

| Action | Network         | Description                                   | 
|--------|-----------------|-----------------------------------------------| 
|        | `/bookings`     | Retrieves all bookings                        | 
|        | `/booking/{id}` | Retrieves a specific booking based on it's ID |
|        | `/hotels`       | Retrieves all hotels                        | 
|        | `/hotel/{id}`   | Retrieves a specific hotel based on it's ID |
|        | `/reviews`      | Retrieves all reviews                       | 
|        | `/review/{id}`  | Retrieves a specific review based on it's ID |
|        | `/rooms`        | Retrieves all rooms                         | 
|        | `/room/{id}`    | Retrieves a specific room based on it's ID  |
|        | `/users`        | Retrieves all users                         | 
|        | `/user/{id}`    | Retrieves a specific user based on it's ID  |

### Part 1 Stretch Stories

- Create an endpoint that allows the user to sort descending or ascending by the createdAt. ***(5 points)***
    - Add this by using a query string (ie, `http://localhost:8080/api/v1/product/?sort=asc`)

### Part 1 Walkthrough
![](https://i.imgur.com/9KAMTrV.gif)

### Part 2 Required Stories

- [x] Create an endpoint for each of the major classes (Hotel, Room, User) ***(9 points)***
    - [x] Create the required models, controllers, and services
    - [x] Each controller should have 3 methods:
        - Create a new entry
        - Update an existing entry
        - Delete an existing entry
- [x] Document endpoints. ***(1 point)***
    - Add to the README file the URI for each endpoint and a description (see example below)
    - This should include **ALL** endpoints, including those from last week. *Note that there is an extra column*

#### Endpoints
All URIs start with: `http://localhost:8080/api/v1`

|Action| Network      | Description                      | 
|---|--------------|----------------------------------|
|        | `/hotels`       | Retrieves all hotels                        | 
|        | `/hotel/{id}`   | Retrieves a specific hotel based on it's ID |
|`POST`| `/hotels`    | Creates a new hotel              |
|`PUT`| `/{hotelId}` | Updates a hotel based on it's ID |
|`DELETE`| `/{hotelId}` | Deletes a hotel based on it's ID |
|        | `/rooms`        | Retrieves all rooms                         | 
|        | `/room/{id}`    | Retrieves a specific room based on it's ID  |
|`POST`| `/rooms`     | Creates a new room               |
|`PUT`| `/{roomId}`  | Updates a room based on it's ID  |
|`DELETE`| `/roomId}`   | Deletes a room based on it's ID  |
|        | `/users`        | Retrieves all users                         | 
|        | `/user/{id}`    | Retrieves a specific user based on it's ID  |
|`POST`| `/users`     | Creates a new user               |
|`PUT`| `/{userId}`  | Updates a user based on it's ID  |
|`DELETE`| `/{userId}`  | Deletes a user based on it's ID  |
###  Part 2 Stretch Stories

1. Create an endpoint that allows the user to find all hotels with a room available on a specific date. Accept the date as a query parameter ***(3 points)***
2. Create an Reservation collection. *Note: ReservationDetail is not a collection* ***(3 points)***

|field|type|
|---|---|
|customer| User reference|
|hotel| Hotel reference|
|checkIn| Timestamp|
|checkOut|Timestamp|
|total|double|
|rooms|ArrayList<ReservationDetail>|

*ReservationDetail*
|field|type|
|---|---|
|room|RoomNumber|
|adults|integer|
|children|integer|
|pricePerNight|double|

3. Create an endpoint that allows the user to create a reservation. ***(2 points)***
    - Add this end point to the table if you create it.

## Part 2 Walkthrough
![](https://i.imgur.com/naOYpxc.gif)