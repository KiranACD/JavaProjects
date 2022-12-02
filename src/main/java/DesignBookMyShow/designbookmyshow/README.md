# Design BookMyShow

When faced with a low level design problem, we need to start with an overview of the problem.

## Overview

The purpose of getting an overview is to determine the system we need to design.

There can be 2 situations here, either we know the system or we don't. 

In case we know the system, we have to first clarify if we are thinking of the same system. Then we need to determine the scope of the system we need to build. This is especially true with respect to a problem like this, where we can design a complete working application. In the design phase, the scope can range from just identifying the entities that might be there in the system to making use case diagrams, class diagrams and schema designs. In the implementation phase, the scope can range from just implementing the entities that you have identified to creating the entire application with a few use cases implemented.

In case we dont know the system, we should ask questions in the form of clarifications. For example, we can ask questions like, as bookmyshow sounds like an application for booking things, do you want me to design an application for booking some kind of ticket for events/shows? Questions like this will help us determine the nature of application we need to design and implement.

For applications like bookmyshow (retaurant booking system) the expectation is to implement classes, schema etc for most basic features. 

## Gathering Requirement 

Now that we have decided the kind of system we need to build, we have to gather the features we want to build. The best way to do this is to generate ideas. Visualizing the system in our mind will help us come up with ideas. Ideas that can impact the design of the system should be given primacy.

1. Location or Universal store. There will be multiple cities and there will be multiple theatres.
2. A theatre can have multiple screens.
3. Each screen has different set of features. One screen might be 2d, another screen might be 3d etc.
4. Each hall will have multiple seats. 
5. Those seats can be of different types. There are can be VIP seats, GOLD seats etc. 

6. Each type of seat will have a different price for a show. This means show level pricing.
7. Inside every theatre, there might be multiple shows running at one time.
8. Every show is for a movie at a particular at a particular screen.
9. Features are also associated to a show (2D, 3D etc).
10. For a movie, we want to store its name, its language, genre, cast, duration, grade, features.
11. User should be able to search movie.
12. Partial payment is allowed.
13. We only support online payment.
14. Handling payment is outsourced. We use a third party provider to handle payment.
15. Support cancellation and refund.
16. Do we have to implement a theatre aggregator (we call theatre API) or do we maintain data with us? We have to maintain data ourselves. This means we have to implement locks so that we prevent multiple users from booking the same seat.
17. Only one person should be able to book a seat at a time.
18. We reserve seats upto 10 mins when someone is booking.
19. Whatever shows are available, anyone can book.

## Clarifying Requirements

Clarifying requirements is mostly about making certain choices of behviours we want to supports. We have already made a few choices in this case. Some of these are:

1. We have decided that only 1 person should be able to book a seat at a time. 
2. We have allotted 10 minutes to complete a booking where a seat will be reserved. 
3. We have made the choice to let anyone book a show as long as seats are available.
4. We have the made the choice to maintain the seats data ourselves.
5. We are going to support partial payment.

## Class Diagram

The two ways to approach class diagram is to

1. Track the nouns in the requirements.
2. Make visualizations. We have to go from the outermost layer to the innermost layer. There are two visualization here. One is the part where we select a movie. The other is the part where we make a booking.

In the first visualization, we start with the city class. The city class will have id and name. We will not store the list of theatres. In Bookmyshow, for a given city, we do not see the list of theatres. We usually see the list of shows.

Then we have the theatre class. This class will have id, name, address and list of screens. Screen class will have id, a list of seats and a list of features like 2D, 3D, Dolby. Seat class will have id, row, column, name, type, status. The name attribute will represent the seat number. The row and column attribute assumes a 100x100 grid which will be used to display the layout to a user while making seat selection. The show class will have id, screen, movie, startTime, endTime and a list of features as attributes. Price of any seat is an attribute of the relationship between show and seat type. So we create a mapping class called SeatTypeShow which will have id, show, seat type and price as attributes.

We could have a list of seats in the show class. With this design, it will be difficult to implement seat blocking as the Seat class does not have a booking status. We could put the booking status attribute in the Seat class, but the booking status is not an attribute of the Seat entity class, rather it is an attribute of the Show-Seat relationship class. So, we should create a mapping class called ShowSeat which will have id, show, seat and status as attributes. The status will take values AVAILABLE, BOOKED, LOCKED.

![BookMyShow](images/BookMyShowClassDiagram1.png)

There are two ways to represent enums in the table. One is as a mapping table, other is to represent them as string. Enums are not primitive attributes. Enum tables have two columns, id and value.

In the second visualization, we have a movie class with id, name, list of actors, list of features and genre. The Actor class will have id and name of actor. In the actor class, we can have a list of movies attribute if required due to access pattern. Feature is an enum with values 2D, 3D and DOLBY. Genre is also and enum with values like COMEDY, THRILLER, ROM-COM. Once a movie is selected, and seat selection is done, we move to payment. Payment class will have attributes id, amount, mode, ticket, transaction number, timeOfPayment, status. Mode is an enum with value CREDIT_CARD, DEBIT_CARD, UPI, CASH. Status is PaymentStatus which is also an enum with values SUCCESS, FAILURE, ABORTED, PROCESSING, REFUNDED. Ticket class will have id, show, time, list of showseats, amount, list of payments (list of partial payments), status. Status in the ticket class is TicketStatus which is an enum that has values BOOKED, CONFIRMED, CANCELLED.

![BookMyShow](images/BookMyShowClassDiagram2.png)

## Schema Design

We will add the primitive attributes first.
```
Cities
id      |       name

Theatres
id      |       name

Screens
id      |

Seats
id      |       row     |       column      |       name

SeatTypes
id      |       value

Shows
id      |       startTime       |       endTime

SeatType_Shows
id      |       price

Show_Seats
id      

Movies
id      |       name

Actors
id      |       name

Genres
id      |       value

Features
id      |       value

Payments
id      |       amount      |       time        |       transactionNumber

Tickets
id      |       time        |       amount

PaymentStatuses
id      |       value

PaymentModes
id      |       value

TicketStatuses
id      |       value

```

The first non-primitive attribute we run into is the list of screens in a theatre. We have to find the cardinality between theatre and screen. One theatre can have many screens. One screen can belong to one theatre. So the cardinality is 1:m. We have to add the id of the side with 1 to the column of the table of the m side. So we have to add the theatre id to the screens table.

The cardinality between theatre and city is m:1.

The cardinality between screen and seats is 1:m. 

The cardinality between screen and features is m:m. One screen can support multiple features. One feature can be in mutiple screens.

The cardinaity between seat and seat type is m:1. One seat is of one seat type. One seat type will be associated with multiple seats.

The cardinality between seat and status is M:1. One seat can have one status. One status can be associated with many seats. So the seats tables will have the status id.

The cardinality between show and movie is M:1. One show will have one movie, but one movie will have multiple shows. So, shows table will have movie_id.

The cardinality between show and screen is M:1. One show will be playing in one screen, but one screen will play many shows. So, the shows table will have a screen id.

The cardinality betwen show and feature is M:M. One show can support multiple features and one feature will be supported by mulltiple shows. So, we need to make a mapping table of shows and features.

The cardinality between seatTypeShow and show is M:1. So, we have a show_id in the seatTypeShows table. The same is true for seatTypeShow and seatType.

The cardinality between showSeat and show is M:1 and same is applicable for showSeat and seat. So in the ShowSeats table we will have both show_id and seat_id. The cardinality between showSeat and status is M:1 as one showSeat will have one status, but one status can be associated with multiple showSeats. So we will have the status id on the showseats table.

The cardinality between movie and actor is M:M. The cardinalility between movie and features is M:M. The cardinality between movie and genre is M:M.

```
Cities
id      |       name

Theatres
id      |       name        |       city_id

Screens
id      |       theatre_id

Seats
id  |   row   |   column  |   name  |   screen_id   |   seatType_id   |   status_id

Screen_Features
screen_id       |       feature_id

SeatTypes
id      |       value

Shows
id   |   startTime   |   endTime   |   movie_id   |   screen_id   |   

Show_features
show_id     |       feature_id

SeatType_Shows
id      |       price       |       show_id     |       seatType_id

Show_Seats
id      |       show_id     |       seat_id     |       status_id

Movies
id      |       name

Actors
id      |       name

Movie_Actors
movie_id        |       actor_id

Movie_Features
movie_id        |       

Movie_Genres
movie_id        |       genre_id

Genres
id      |       value

Features
id      |       value

Payments
id      |       amount      |       time        |       transactionNumber

Tickets
id      |       time        |       amount

PaymentStatuses
id      |       value

PaymentModes
id      |       value

TicketStatuses
id      |       value

```


How to handle enums in spring boot.

What the application.properties config means.

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialtect - Spring boot needs to know about the type of database (Postgre, MySQL, SQLite). 

spring.jpa.hibernate.ddl-auto = update - This tells spring boot the way to handle application restart. We have update here, but it takes other values like create (this will delete the existing tables and create new tables), update (will update current schema based on current application code).

spring.jpa.properties.hibernate.show-sql = true - Setting this to true means spring boot will show us the queries that spring boot runs.

spring.datasource.url = - This is the url of the database.

spring.datasource.username=
spring.datasource.password=

kiran@kiran-Lenovo-ideapad-310-15ISK:~$ sudo -u postgres psql
[sudo] password for kiran: 
psql (12.12 (Ubuntu 12.12-0ubuntu0.20.04.1))
Type "help" for help.

postgres=# create database scalerbms;
CREATE DATABASE
postgres=# create user scalerbms;
CREATE ROLE
postgres=# grant all privileges on database scalerbms to scalerbms;
GRANT

## Controllers/Services/Repositories

When we want create a use case, we should identify the primary entity or table that will be impacted the most. Then create a controller for the entity. If we want to book a ticket, then the ticket entity will be at the centre of all activity. So, we create a TicketController. In this controller, we will have a method called bookTicket().

The admin should be able to add a new screen in a theatre. If it is just an admin api, then we can have an admin controller (/admin/______). However, if the api could be used elsewhere, then we can have a TheatreController (/theatre/addScreen), or a ScreenController (/screen/addScreen). Ideally, we must determine the model being affect the most and then structure the design around that model.

Another way to think about where a behaviour should be housed is to think about API requests. If the APIs are in /admin, then all the APIs with /admin will be in AdminController. If all APIs are in /users then all the APIs will be in UserController. All the APIs in /theatre will be in TheatreController. A controller should ideally not talk to other controllers. They ideally talk to other services.

If you annotate a controller class as @Controller, then Spring creates an object of the class and stores it in an internal registry. Spring acts as a dependency injection framework, which means when we need an object of the controller anywhere in the application, spring injects this object where required. 

Service methods have to be generic because, one service can be used by multiple controllers. Therefore service should not have dtos as parameters or return types.

We can annotate services with @Service and spring will store an object of the service in an internal registry, injecting the object where required.

Wherever we are passing objects that need to be autowired, we need to annotate the function with @Autowired. Variable injection using @Autowired is not recommended.

We should never create dependencies ourselves. We should get dependencies from the parent.

```
Optional<object> obj1 = Optional.of(null);
if (obj1.isPresent()) {}; // Otherwise compile time error.
```

## Types of Locks for databases

Transactions are a group for SQL statements. Transactions are atomic which means either everything will run or nothing will run. Transactions have 4 isolation levels.

1. Read uncommitted
2. Read committed
3. Repeatable read
4. Serializable

The behaviour of one transcation in the presence of other transactions depends on the isolation levels.

Consider two transactions
```
        T1                      |                       T2
1. Read A                       |     1. 
2. A = A + 2                    |     2. 
3.                              |     3. Read A
4. Commit                       |     4.
5.                              |     5. Read A
```

The value of A that will be read in transaction T2 will depend on the isolation level. If the isolation level of T2 is read uncommitted, then the value of A that is read the first time is 4 and the second time is also 4. If it is read committed, value of A that is read the first time is 2 and the second time is 4.

Suppose we want to send an email to all the students of a batch that they have been sent a code of JetBrain coupon. The query to run is 
```
1. SELECT * FROM Students WHERE Batch = _________;
2. Send emails (Takes 4 hours)
3. UPDATE Students SET email_sent = true WHERE batch = __________;
```
An edge case here is if a new student is added while sending the emails. In that case, the update statement will update for all students including the new one, which is undesirable.

Repeatable read isolation level says that across all transactions the row will remain same.

Going back to the first example, with repeatable read isolation level, the value of A read the first time and second time is 2. If the first read A happened after the commit in transaction T1, then the value of A read both times is 4. The value read first remains the same throughout the transaction.

The most restrictive isolation level is serializable. In this level, once a value is read, no one will be allowed to read till the transaction is done. It serializes the transactions.It works by taking locks.


For bms, taking a lock for 15 minutes or till payment is done is too long. In the ShowSeats table, we have a column called status. There are two ways to take locks.

1. Tell the database to take lock. However, this will stop other transactions. 
2. We can set the status to LOCKED/PROCESSING. While setting the status from AVAILABLE to LOCKED, we can take a database level lock. Once status is updated, remove the lock. This reduces the time the database in under lock to about a second. 

save() can be used to create as well as update. If the ID in the parameter is null, then create else update is called.
