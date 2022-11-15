# Design a Pen

## Overview

We need to figure out the scope of the system. In this case, this is a known system. We have designed a bird before. It falls under the category of representing an entity. So we need to figure out if designing a pen should fall under the same format. Some of the other categories are real-life management system, web APIs, realtime system like a game, engineering probem like an LRU cache.

We are going to represent a diversity of pens using object oriented design. So now we have to start gathering requirements.

## Gathering Requirements

Assuming we are giving an interview, we will gather requirements by suggesting ideas. Let us discuss some of these ideas.

1. There will be different types of pens like ball pens, gel pens, fountain pens, stylus etc.

2. Pens can either have cap or no cap.

3. An important question to ask here is, what qualifies as a pen? An answer could, for example, be, anything that writes is a pen. In this case, pen becomes an interface with a write() method. 

4. If there are certain attributes/information we want to store for all pens, then pen becomes an abstract class instead of an interface. Some attributes can be length, brand, name.

5. Some pens are refillable and nonrefillable.

6. What is a refill? Refill has ink and nib.

7. Ink can be of different colour.

8. Ball pen will have ball pen refill and gel pen will have gel pen refill.

9. We need to store how a pen writes. This can also be called writing behaviour. Many pens can have the same writing behaviour.

10. Nib can have different dimensions.

11. Fountain pen has ink but no refill. Fountain pen itself has a nib.

## Clarifying Requirements

There is a question that we should always ask here. Can multiple entities have the same behaviour? This tells us whether there will be code duplication. In this case, we have already asked this question in regards to the writing behaviour. We decided to implement the writing behaviour using the strategy design pattern based on this behaviour.

## Use Case Diagram

Use case diagram is not need in the design entity category of problems.

## Class Diagram

How do we identify classes? We have to look for nouns in the requirments and we have to visualize the system.

In this case, we have pen, ball pen, gel pen, fountain pen, stylus, cap, refill, ink, nib, ball pen refill, gel pen refill.

The order in which to create classes is a common point of confusion for people. Visualization helps to resolve this confusion. Once we visualize the system, start the class diagram in the outer-to-inner direction. First create the interface of the outside part of the entity. Then progressively create the interfaces of inner layers of the entity.

In this case, the outermost layer is the pen. Pen should be an abstract class because it has a writing behaviour and some attributes like length, brand and name. Pen can also be an interface with getName(), getBrand(), getLength() and write() method. However, the abstract class method is simpler, so we will go with that.

The next layer is the refill in case of pens that are refillable. In this case, the ability to refill is a behaviour, so we will define an interface called Refillable with a method called refill(). An alternative way is to define a boolean in the pen class called canBeRefilled, then define two functions called refill() and canberefilled(). The canberefilled() will be called to decide if refill() needs to be called. However, using this method, we cannot get a list of all pens that can be refilled. So, it is better to use the interface method. 

We can have three other classes called Refill, Ink and Nib. Refill will have attributes like ink, nib, refilltype. Ink will have colour as its attribute which is an enum. Nib will have dimension as its attribute.

We can represent writing behaviour through an interface called WriteBehaviour, which will have a write() method. Since all pens have a writing behaviour, we will include an attribute called writeStrategy in the Pen class. 

In all the write methods of the subclasses of Pen, we will call strategy.write(), where strategy is the object of the respective strategy class applicable in the subclass.


