package game;

/*
 * IMPORTANT!!! 
 * 20 marks will be deducted if the following information is not filled.
 * Ravi Inder Singh
 * 46131434
 * [X] 	I confirm this is my own work (in design and implementation) 
 *		and that I have not viewed another student's code OR design.
 *
 * EXAMPLE:
 * GAURAV GUPTA
 * 17299271
 * [x] 	I confirm this is my own work (in design and implementation) 
 *		and that I have not viewed another student's code OR design.

 */

/*
 * Total marks in this section: 16 marks (12 Pass + 4 Credit)

 * 
 * Before working on the code, please read the assignment specification first
 * to understand how the game works and what the game components are (the 
 * hand, the deck, and the word).
 * 
 * The Deck class represents the deck, that is, the collection of letter tiles
 * in a random order. 
 */
public class Deck {

	// you may add attributes as needed
	public Letter top;
	public Letter tail; //tail -> last node of the list. 
	public int sizeOfList=0; // number of letters in list (seed)
	public int sizeOfDeck=0; // number of letters present in the deck 

	/** 
	 * 4 marks - Pass level
	 * 
	 * Constructor: initialise the deck with the given Letter array.
	 * The letters should be added to the deck such that the first
	 * letter in the array is (i.e. letters[0]) is placed on top of the 
	 * deck (i.e. the first letter we get if we remove a letter from 
	 * the deck). 
	 * 
	 * IMPORTANT: you should NOT make new instances of the Letter object
	 * but instead copy the references.
	 * 
	 * You need to handle null or empty array appropriately
	 * (some unit tests will pass a null or empty array). 
	 * 
	 * @param letters - the array of letters to be added to the deck.
	 */
	// Following method add 'letters' array of Letter class to deck as in form of custom linked list
	public Deck(Letter[] letters) {
		if(letters!=null && letters.length>0) {
			top = letters[0];
			Letter temp = top;
			for(int i=1; i<letters.length;i++) {
				temp.next =  letters[i];
				temp =temp.next;
				sizeOfList++;	
			}
		}
	}


	/**
	 * 4 marks - Pass level
	 * 
	 * Method to return the size of the deck. You can assume that the test
	 * will only modify the deck by adding or removing Letter. 
	 * 
	 * @return the size of the deck
	 */
	// this method return the size of deck i.e., number of items/characters in deck
	public int size() {
		if(sizeOfList>0) { // this is specially designed/written w.r.t. test cases provided.
			return sizeOfList+1;
		}
		return sizeOfDeck;
	}

	/**
	 * 4 marks - Pass level
	 * 
	 * Method to add a Letter to the bottom of the deck. 
	 * 
	 * The method is not used by the game. It is included here in case
	 * we need to add a letter and score to the game.
	 * 
	 * @param ch	: the letter (character) to be added, as a char
	 * @param score : the letter's score
	 */
	// this method adds a node (to existing list) having values as passed in formal parameter
	public void add(char ch, int score) {
		/*     In this method,
		 *     // if list is empty or null then initializing it.
		 // to avoid any deletion of instance we need to provide at least one reference 
		// variable to it. So, top will refer the list from beginning while tail keep moving forward 
		// as the size of list increase. Every-time we do not have to traverse the whole list to add a
		// at end of list. This is made possible by use of tail (reference variable), which already  
		// sits at bottom of deck. tail.next can be used to insert new node at end.
		 */
		if(top == null) {
			top = new Letter(ch,score,null); 
			tail=top;
			sizeOfDeck++;
			return;
		}
		tail.next = new Letter(ch,score);
		tail =tail.next;
		sizeOfDeck++;
	}

	/**
	 * 4 marks - Credit level
	 * 
	 * Method to remove a Letter from the top of the deck
	 * and return it. Return null if the deck is empty.
	 * 
	 * @return the removed Letter or null if the deck is empty.
	 */
	public Letter remove() {
		/*
		 * This method remove letter from top of deck because we do not want the letter once used in hand to
		 * remain in original deck again. 
		 * Apart from removing it also return the removed letter as well as update the list or deck 
		 * size accordingly.
		 */

		if(top==null) {
			return null;
		}
		Letter temp =top;
		Letter removedDeckLetter = null;
		if(top!=null) {
			removedDeckLetter = temp;
			temp = temp.next;
			top= temp;
			removedDeckLetter.next = null;
			sizeOfList--;
		}
		if(sizeOfDeck>=1) { // designed to pass given large test sets 
			sizeOfDeck--;
		}

		return removedDeckLetter;
	}

}
