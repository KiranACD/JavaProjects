# Design TicTacToe

This is a game design problem. The ideas that we discuss in this project will also be applicable to designing games like chess, snake & ladders, cards etc.

## Overview

There two possibilities when faced with a new LLD system design problem. We either know the system, or we dont. 

In case we know the system, we have to find out if we are on the same page as the interviewer/stakeholder with respect to the system. So, we have to find out if we are thinking of the same game. Once that is estabished, we need to find out the scope of the system.

**What kind of system do we want to build?** 

Should it be an entity? Or a real-time system? Or a web based game? In this case, we are going to build an interactive application that we will play in one system.

## Gathering Requirements

For all the games, there are some common features/ideas.

1. Leaderboard. This a common feature in games and a good feature to implement because competition is always good. However, we will not be building a leaderboard in this game. 

2. Undo. Can we undo a move that we made? We will implement this in our system.

3. Bot. Should we have a bot to play against? Yes.

4. Tournaments. We will not implement tournaments in this game.

5. Timer. We will not implement timer here.

6. Difficulty levels.

7. Replay. Showing replay after game is done. We will implement this feature.

## Clarifying the Requirements

Here we ask questions about how the features should work.

Board can be of any nxn size. Number of players can be equal to the dimension of the board.

Each player can choose their own symbol. However, every player should have a distinct symbol.

How will the game start and how will the game end? Any random player can start the game. We will end the game when the one player finishes the game or when all the cells are filled and it is a draw. There can also be a feature to quit the game midway, but we will not be implementing it here.

Infinite number of undos can be done.

How can we track the winner in O(1) time?

There is a hidden DSA problem in many design problem. In TicTacToe, we have the problem of finding the winner in O(1) time complexity. Splitwise has a graph problem in it.

We want to have to multiple ways to decide a winner. This is an implementation of the strategy design pattern.

## Use Case Diagram

This is a command line application where one or more players are going to be playing the game on the same system. So a use case diagram is not required.

## Class Diagram

The first part here should be the representation of entities and any design patterns applicable in the system. Any representation of controllers should be done after the first part is done.

The two ways to approach the class diagram is to

1. Track the nouns in the requirements.

2. Visualization. We have to visualize from the outermost layer to the innermost layer.

We start here with the board. Board is a noun and we will have to store information about the board. A board will have a matrix with cells. It is better to have a class represent the cell. A cell can store attributes like player that made the move, row and column location in the matrix. 

A player can also be represented as a class. The player will have attributes like the symbol he has been assigned, name and type of player (bot or human). We can have another class called Bot that will inherit from the Player class. Bot will have an attribute difficulty that sets the difficulty level of the bot.

The symbol in the player class can also be a class. This class will have a character as its attribute. This gives us the flexibility of setting the symbol that a player wants. 

If we make symbol class as enum, then there will be a restriction on the number of symbols that can be there. This is because the number of symbols we store in an enum will be fixed. We cannot increase it. 

All the objects will exist in an object of the class Game. This class will have attributes like list of players, board, game status, last play to move, list of moves, win strategy, winner etc.

The win strategy is an interface that has a method checkVictory(). All the win strategies should implement this method. The win strategies will include things like row winning strategy, column winning strategy, diagonal winning strategy, four corners winning strategy and any other winning strategy that we want. 

We do not need to identify all the attributes of the classes at the class diagram phase. It is okay to identify some at the implementation phase. As long as we figure out the high level design, we should be fine.

There are three ways to implement undo.

1. When it is easy to reverse a move. In TicTacToe, we just need to clear the cell, give the control back to the previous player and change the lastmoveindex by -1.

Here the algorithm will be to 
a. Store the list of moves. 
b. When undo is called, reverse the move.

2. When it is difficult to implement undo. In games like chess, implmeting undo is complicated. In case a piece was taken off the board and we click undo, then the piece taken off has to come back on to the cell and then we have to reverse the piece that was there on the cell to its previous position.

Here the algorithm will be to
a. Store the list of moves.
b. When someone calls undo, create a new board.
c. Redo all the moves except last one on the new board.

3. After every move, in the move object we add the snapshot of the board. When we click undo, we make the previous board the current board.

## Code

There are some good practices that we can follow while writing the code. One of the ways we can structure the code is called package by layer.

Some of the layers are services, repositories, models, controllers, dtos, daos etc. In this project we will be structuring our code into models and controllers. It is an interactive commandline application, so we do not need services. Sevices are used to take data, process it and give it back to the client. We do not need to store any data and all the data is stored in memory each game, so we do not need repositories.

The layer that interacts with the client is called the controller. Controller provides a way/interface for the client to interact with the system. Controller then sends the request to a service, for example a user service. Any work related to users is sent to the user service by the controller. So services do that actual work. Controller provide the interface between the client and the services.

If a client wants to login, they first send a request to the user controller and user controller sends the request to user service. In order to successfully login or deny you, the user service needs data. In this case, it is the username and password. User service gets the data from the database. This layer is called the repository layer. The data that is stored in the storage is called the model. Model is anything/anyone that you get from the repository.

All the classes we have defined are called models. So, we create a models package and start coding the models. Create classes, put attributes in them and set up getters and setters.

Once models are done, we should focus on how users are going to interact with the application and code the application requirements one-by-one.

To avoid null pointer exceptions, we should always define constructors that will initialize the attributes of the class.

The game class requires a builder for a few reasons. 

1. There are many attributes.
2. We need to validate that every player must have a different symbol.


We always pass services through injection, not models.






