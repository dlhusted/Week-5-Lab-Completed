package week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week05OOPLab {
  
  // This Lab will give you a basic look at creating an Object Oriented Card Game.  
  //      The idea here is to prepare you for your Week 6 Unit Final Project.
  //      There are many ways to implement this Lab, please use the tools that you know,
  //      and go from there.
  // These exercises are intended to be coded in order 1 through 5.

  public static void main(String[] args) {
    
    
    
    // A standard deck of playing cards has 52 cards as specified below 
    //      i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
    //              
    //     ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven, 
    //                                   Eight, Nine, Ten, Jack, Queen, King & Ace
    //
    //    iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
    //                           to make this easy, a Two will have a value of 2, a
    //                           Three will have a value of 3, ... and an Ace will have
    //                           a value of 14.
    //

    
    // 1. Card Class:
    //      Create a class called Card to represent a standard playing card. 
    //      Fields:   The Card class should have the following fields:
    //          a. name field
    //          b. suit field
    //          c. value field for comparing against other cards.
    //
    //      Methods:  This class can have any useful method.
    //          a. describe() to display the card information to the Console.
    //          b. Getters & Setters 
    //
    System.out.println("\nQuestion 1: Card Class");

    // Add your code here to instantiate a Card
    
    
   
    
      // Call the describe method on the newly instantiated card.
    Card card = new Card("2", "Hearts", 2);
    card.describe();

    System.out.println("----------------------------------------------");

    // 2. Deck Class:
    //      Create a class called Deck.
    //      Fields:  This class should have a list of Card field called cards 
    //               that will hold all the cards in the deck. 
    //          List<Card> cards = new ArrayList<Card>(); 
    //
    //      Constructor: The constructor for the Deck Class should
    //          instantiate all 52 standard playing cards and add them to the cards list.
    //
    //      Methods:  
    //          a.  describe() to describe the deck to the Console -- 
    //                  print out all of the cards in the deck.
    //
    System.out.println("\nQuestion 2: Deck Class");

    // Add your code here to instantiate a Deck 
    Deck deck = new Deck();

    
    
    
    
    
    // Call the describe method on the newly instantiated deck.
    deck.describe();
    
    System.out.println("----------------------------------------------");
  
    // 3. Deck shuffle() Method:
    //      Add a shuffle method within the Deck Class
    System.out.println("\nQuestion 3: Deck shuffle() method");
    // Test your method here
    deck.shuffle();
    
    
    // Call the describe method on the newly shuffled deck.
    deck.describe();
    
    
    System.out.println("----------------------------------------------");
   
    // 4. Deck draw() Method:
    //      Add a draw method within the Deck Class
    System.out.println("\nQuestion 4: Deck draw() method");
    // Test your method here
    Card drawnCard = deck.draw(); //draw the first card from the deck and assign it to a variable
    drawnCard.describe(); //print out what the card is
    System.out.println("----------------------------------------------");


    
    
    
    // 5. Create Game Board:
    //      Create and test a method that takes an int as a parameter (representing the
    //          number of players for a game) and returns a Map<String, List<Card>>
    //          that represents each player (i.e. "Player 1", "Player 2", etc..) 
    //          and their cards.
    //
    //          The method should create a new instance of Deck, shuffle it,
    //          and deal the cards out to the "players" in the Map.
    System.out.println("\nQuestion 5: Create Game");
    // Call your method here
    Map<String, List<Card>> newGameBoard = new HashMap<>(); //create a new empty map
    int numberOfPlayers = 5;                                //variable for the num of players
    newGameBoard = createGame(numberOfPlayers);             //call the method for the new map
    
    /*
     * testing the method below to see that it works by printing each List of cards for each player
     * -- for - iterate up to the number of players variable
     *        - create variable for playerName that is equal to the key in the map
     *        - print player name and underline
     *        - use the key to retrieve the list from our map
     *        - retrieve List of Card from the Map using get.(key)
     *        - for every card from the list (each players "hand")
     *        - describe() --method from the card Class
     */
    System.out.println("-------------------------------------------");
    for(int i = 1; i<= numberOfPlayers; i++) {
      String playerName = "Player " + i;
      System.out.println(playerName + "\n--------");
      List<Card> playerList = newGameBoard.get(playerName);
      for(Card handCard : playerList) {
        handCard.describe();
      }
      System.out.println("-------------------------------------------");
    }
    
    
    
} 

// Method 5:
  /*
   * -empty map
   * -create new deck
   * -shuffle deck
   * -- for - iterate up to the number of players
   *        - create new List of Card (playerHand) for each value space in the map
   *        - create playerName for each key space in the Map
   *        - add each player name to the key space in the map
   *        - add empty list of Card to each value space in the map
   *        
   * -- for - iterate up to 52 divided by the number of players
   *        - iterate up to the number of players (to alternate players) - to deal a new card each time around
   *        - create playerName (again in this scope) based on which index we are on
   *        - get the list of cards that was added to the map via the key (playerName)
   *        - then add a card from the deck to that list
   *        - then replace the blank list with the updated list
   *        
   * -return the new Map        
   *        
   */

public static Map<String, List<Card>> createGame(int numOfPlayers) {
  Map<String, List<Card>> newGame = new HashMap<>();
  
  
  Deck newDeck = new Deck();
  System.out.println("The deck has 52 Cards!");
  newDeck.shuffle();
  for(int i = 1; i <= numOfPlayers; i++) {
    List<Card> playerHand = new ArrayList<Card>();
    String playerName = "Player " + i;
    newGame.put(playerName, playerHand);
  }
  for(int i = 0; i < 52/ numOfPlayers; i++) {
    for(int j = 1; j<= numOfPlayers; j++) {
      String playerName = "Player " + j;
      List<Card> playerHand = newGame.get(playerName);
      playerHand.add(newDeck.draw());
      newGame.replace(playerName, playerHand);
    }
  }
  if(52 % numOfPlayers != 0) {
    System.out.print("With " + numOfPlayers + " players -- ");
    System.out.println("Cards left in deck: " + 52%numOfPlayers);
  } else {
    System.out.println("All cards have been dealt.");
  }
  
  return newGame;
}



}
