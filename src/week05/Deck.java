package week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
  
//2. Deck Class:
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
  
 //This is a new list of Card called cards 
  private List<Card> cards = new ArrayList<Card>();
  

  //---------------------------------------------------------------------------- 

  //constructor:
  /*
   * THIS METHOD CREATES EACH CARD IN THE DECK (52)
   * - create an array of suits
   * - create an array of numbers (2-Ace)
   * - for each suit (in the suits array)
   *    -- and for each number (in the numbers array) --so for each suit, this will iterate through each number
   * - create a new card for each with the parameters equal to the number, suit, and value
   * - add each new card to the List of cards (above)
   * - iterate up 
   *      
   */
  public Deck(){
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] numbers = {"2", "3", "4", "5", "6", "7", "8", 
                        "9", "10", "Jack", "Queen", "King", "Ace"};
    for(String suit : suits) {
      int count = 2;
      for(String number : numbers) {
        Card card = new Card(number, suit, count);
        this.cards.add(card);
        count++;
      }
    }
  }
  
 //---------------------------------------------------------------------------- 


  //getters and setters
  
  public void setCards(List<Card> cards) {
    this.cards = cards;
  }
  
  public List<Card> getCards() {
    return cards;
  }
  
  
  
  //---------------------------------------------------------------------------- 
  //describe, print out each card in the deck
  /*
   * for each card in this list of cards
   * call the describe method on the Card class 
   * 
   */
  public void describe() {
    for(Card card : this.cards) {
      card.describe();
    }
  }
  
  //---------------------------------------------------------------------------- 

  // 3. Deck shuffle() Method:
  //      Add a shuffle method within the Deck Class

  
  public void shuffle() {
    Collections.shuffle(this.cards);
  }

  
  //---------------------------------------------------------------------------- 
  /*
   * draw method
   * after the deck is shuffled (above)
   * 
   * create a new card variable, and remove the top card(0) from the deck and assign it to the card variable
   * 
   */
  public Card draw() {
    Card card = this.cards.remove(0);
    return card;
  }
  
  
  
  
  
 

}
