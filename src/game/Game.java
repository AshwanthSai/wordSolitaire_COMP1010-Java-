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
 * Total marks in this section: 11 marks (7 Pass + 4 Distinction)
 * 
 * Before working on the code, please read the assignment specification first
 * to understand how the game works and what the game components are (the 
 * hand, the deck, and the word).
 * 
 * The Game class controls the interaction between the game components
 * with three move methods:
 * - draw(): move a letter from the deck to the hand
 * - moveFromHandToStartOfWord(): move a letter from the hand to start of word
 * - moveFromHandToEndOfWord    : move a letter from the hand to end of word
 *
 * The Game class also has one method to 'score' a word that you need to implement
 * (scoreWord()) and also an attribute score to keep track of the score.
 * 
 * Please DO NOT modify the visibility of any attributes/methods in this class
 * since both the visualiser and the JUnit test may need to access them. 
 * In particular, the visualiser accesses the hand, the deck, and the word from
 * this class, so I have made them all public to simplify the code. 
 */

public class Game {

	// DO NOT MODIFY THESE ATTRIBUTES (but you are welcome to add extra attributes
	// or methods in this class as you see fit). 
	public Deck deck;
	public Hand hand;
	public Word word;

	// the score variable records the game score (don't remove/rename it)
	public int score;

	// the String array to hold the dictionary (this is the only array attribute 
	// you are allowed to have in the assignment).
	public String[] dictionary;

	/** 
	 * 3 marks - Pass level.
	 * 
	 * Constructor: initialises the game components (the hand, the deck, and the word)
	 * using the given dictionary (list of words) and Letter array (the letter tiles). 
	 * To receive marks for this method, you need to also complete the constructor
	 * for the Deck class. 
	 * 
	 * @param dictionary - a String array containing the list of valid words.
	 * @param letters    - a Letter array containing all the Letter objects
	 *                     that should be placed in the deck.
	 */

	/*
	 * THIS GAME CLASS LINK ALL THREE -> DECK, HAND & WORD CLASSES WITH EACH OTHER AND THEY INTERACT 
	 * ACCORDINGLY GIVEN SET OF RULES.
	 */
	public Game(String[] dictionary, Letter[] letters) {
		this.dictionary = dictionary;
		// intialising deck, hand and word instances for calling method.
		// it is worth to note that these attributes belong to their respective class.
		if(letters!=null && letters.length>0) {
			deck = new Deck(letters);
			hand =  new Hand();
			word= new Word();
		}

	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to check if the word entered by the user so far
	 * is a valid word or not. If the word is a valid word, 
	 * then reset the word (making it empty) and add the score
	 * to the score attribute. 
	 * 
	 * If the word entered so far is not a substring of any valid
	 * word, then discard the word (reset the word) and do not
	 * modify the score.
	 *
	 * Otherwise, do nothing.
	 */
	public void scoreWord() {
		// calling 'isPossibleWord' by 'word' and passing String 'dictionary' as parameter
		// if it is not a valid word then reset letters in 'word' to empty and do not increase 
		// score for this.
		if(word.isPossibleWord(dictionary)==false) {
			this.word = new Word();
		}
		// calling 'isWord' by 'word' and passing String 'dictionary' as parameter
		// if it is a valid word then reset letters in 'word' to empty as well as increase 
		// 'score' for this determined in 'getScore' method of 'word' class.
		if(word.isWord(dictionary)) {
			this.score = this.score+ word.getScore();
			this.word = new Word();
		}
	}

	/**
	 * 4 marks - Distinction Level
	 * 
	 * The following three methods deal with moving Letter objects
	 * between the deck, the hand, and the word, so you should ideally
	 * have implemented relevant methods in the other classes. 
	 * This is why this method is assessed at Distinction level even though
	 * it is actually quite simple (do not overthink it). 
	 */

	/**
	 * Method to move a Letter from the top of the deck to the hand
	 * (adding it to the left).
	 */
	public void draw() {
		/*
		 * this method remove the 'top' letter from deck and then add it to 'leftmost' position in
		 *  hand
		 */
		hand.add(deck.remove());
	}

	/**
	 * Method to move a Letter from the hand (leftmost letter) to the
	 * start of the word.
	 */
	public void moveFromHandToStartOfWord() {
		/*
		 * removing leftmost position letter from 'hand' and then adding it to leftmost or start 
		 * of the 'word' 
		 */
		word.addToStart(hand.remove());
	}

	/**
	 * Method to move a Letter from the hand (leftmost letter) to the
	 * end of the word.
	 */
	public void moveFromHandToEndOfWord() {
		/*
		 * removing leftmost position letter from 'hand' and then adding it to last or end 
		 * of the 'word' 
		 */
		word.addToEnd(hand.remove());
	}
}
