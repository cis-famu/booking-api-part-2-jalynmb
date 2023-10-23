[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/hP86jo5x)


### Required Stories

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

| Network         | Description                                   | 
|-----------------|-----------------------------------------------| 
| `/bookings`     | Retrieves all bookings                        | 
| `/booking/{id}` | Retrieves a specific booking based on it's ID |
| `/hotels`       | Retrieves all hotels                          | 
| `/hotel/{id}`   | Retrieves a specific hotel based on it's ID   |
| `/reviews`      | Retrieves all reviews                         | 
| `/review/{id}`  | Retrieves a specific review based on it's ID  |
| `/rooms`        | Retrieves all rooms                           | 
| `/room/{id}`    | Retrieves a specific room based on it's ID    |
| `/users`        | Retrieves all users                           | 
| `/user/{id}`    | Retrieves a specific user based on it's ID    |

### Stretch Stories

- Create an endpoint that allows the user to sort descending or ascending by the createdAt. ***(5 points)***
    - Add this by using a query string (ie, `http://localhost:8080/api/v1/product/?sort=asc`)

### Walkthrough
![](https://i.imgur.com/9KAMTrV.gif)