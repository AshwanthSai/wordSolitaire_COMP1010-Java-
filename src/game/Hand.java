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
 * Total marks in this section: 16 marks (8 Pass + 4 Credit + 4 Distinction)
 * 
 * Before working on the code, please read the assignment specification first
 * to understand how the game works and what the game components are (the 
 * hand, the deck, and the word).
 * 
 * The Hand class represents the player's hand, that is, the collection of letters
 * that can be played to form a word. Only the leftmost letter in the hand can
 * be moved to form a word. 
 */
public class Hand {

	public Letter leftmost; // leftmost refer to starting of linked list node of letters in Hand
	public int sizeOfHand; // number of letters in hand

	/*
	 * Constructor: you can modify the constructor, but make sure 
	 * it is still an empty constructor (i.e. doesn't take any 
	 * parameter). No marks are given for this method.
	 */
	public Hand() {
		// it is a default constructor -> intialise the leftmost (node) to null when the
		// the program executes
		leftmost = null;
	}

	/**
	 * Method to return the leftmost letter in the hand (the only
	 * letter that can be moved). No marks are given for this method.
	 *  
	 * @return the leftmost Letter in the hand.
	 */
	public Letter leftmost() {
		return leftmost;
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to return the size of the hand.
	 * 
	 * @return the size of the hand.
	 */
	public int size() {
		/*
		 * previous used method -> this method does not pass when executes with (large) test function
		 * 		Letter temp = leftmost;
				int count=1;
				if(leftmost == null) {
					return 0; 
				}
				if(temp!=null) {
					while(temp.next!=null) {
						count++;
						temp = temp.next;
					}
				}
				return count;
		 */

		// this 'sizeOfHand' keeps record of size and get updated in add and remove function
		return sizeOfHand;
	}

	/** 
	 * 4 marks - Pass level.
	 * 
	 * Method to add a letter to the hand, at the leftmost position.
	 * 
	 * @param letter - the letter to be added.
	 */
	public void add(Letter letter) {
		Letter temp = leftmost;
		if(temp == null) {
			// if leftmost is null for the first time it is intialised with 'letter' 
			leftmost = letter;
			leftmost.next =null;
			sizeOfHand++; // incrementing sizeOfHand by one
			return;
		}
		else if(letter!=null){
			// this block gets executed every time when 'add' function is called provided that 
			// that leftmost/list of hand letters is valid and not null.
			temp = letter;
			temp.next = leftmost;
			leftmost = temp;
			sizeOfHand++;

		}
	}

	/**
	 * 4 marks - Credit level.
	 * 
	 * Method to remove the leftmost letter from the hand. Return null
	 * if the hand is empty.
	 * 
	 * @return the leftmost letter in the hand if it exists, or null otherwise
	 */
	public Letter remove() {
		/*
		 * This method remove the leftmost letter in the hand and return it if it exists.
		 */
		if(leftmost==null) {
			return null;
		}
		// temp refers to same instance as leftmost refers to.
		Letter temp =leftmost;
		Letter removedLeftmostLetter = null;
		if(temp!=null) {
			// if there are letters in the instance then first refer 'removedLeftmostLetter'
			// to the instance temp or leftmost referring to then unlink temp/leftmost from that instance
			// so this unlinked instance is only being referred by 'removedLeftmostLetter', set next to null
			// to completely isolate it from the leftmost (linked list)
			removedLeftmostLetter = temp;
			temp = temp.next;
			leftmost= temp;
			removedLeftmostLetter.next=null;
			sizeOfHand--; // size decremented by 1 as each letter is removed.
		}
		return removedLeftmostLetter;
	}

	/**
	 * 4 marks - Distinction level.
	 * 
	 * Method to get the i-th letter in the hand, starting with 0 
	 * for the leftmost letter. Return null if the index given is 
	 * invalid.
	 * 
	 * @param index - the index of the letter to be returned.
	 * @return the letter at the given index.
	 */
	public Letter get(int index) {
		if(index<0) {
			return null;
		}
		Letter temp =leftmost;
		Letter letterAtIdx = null;
		int countIndex=0;
		// following loop executes to match given index with the 'countIndex' (i-th position at which letter
		// present in hand), and return the letter at 'index'
		while(temp!=null) {
			if(countIndex==index) {
				letterAtIdx = temp;
				return letterAtIdx;
			}
			temp = temp.next; // keeps traversing through the hand
			countIndex++; // it increases with the iteration through hand (linked list)
		}
		return letterAtIdx;
	}

}
