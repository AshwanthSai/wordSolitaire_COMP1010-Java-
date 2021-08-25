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
 * Total marks in this section: 28 (24 Pass + 4 High Distinction) 
 * 
 * Before working on the code, please read the assignment specification first
 * to understand how the game works and what the game components are (the 
 * hand, the deck, and the word).
 * 
 * The Word class represent the word that the player is constructing. 
 * You can add a letter only to either the start or the end of the word.
 */
public class Word {

	public Letter start; // start is of letter (linked list) type

	/**
	 * Constructor: you can modify the constructor, but make sure 
	 * it is still an empty constructor (i.e. doesn't take any 
	 * parameter). No marks are given for this method.
	 */
	public Word() {
		start = null;
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to return the size of the word.
	 * 
	 * @return the size of the word.
	 */
	public int size() {
		/*
		 * this method return the number of letters in 'word' (linked list)
		 */
		Letter temp = start;
		if(start == null) {
			return 0; 
		}
		//Guaranteed: count of letters in 'start' more than 0
		int countOfLetters=1;
		if(temp!=null) {
			while(temp.next!=null) {
				countOfLetters++;
				temp = temp.next;
			}
		}
		return countOfLetters;
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to calculate the score of the word. You can 
	 * obtain this by adding the score of each letter in 
	 * the word.
	 * 
	 * @return the score of the word.
	 */
	public int getScore() {
		/*
		 * this method add scores from all letters of calling 'start' and then return it.
		 */
		int countScore=0;
		Letter temp = start;
		while(temp!=null) {
			countScore+= temp.score; // accessing 'score' of temp node and adding it to 'countScore'
			temp= temp.next;
		}
		return countScore;
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to add a letter to the start of the word.
	 * 
	 * @param letter - the letter to be added.
	 */
	public void addToStart(Letter letter) {

		if(start == null) {
			// if 'start' is null then just add the letter to it (here is no point of adding it first 
			// or end because no elements in list) 
			start = letter;
			return;
		}
		// Guarnateed: start is not null / list is not empty
		Letter temp = start;
		temp = letter; // temp referring to letter
		temp.next = start; // temp.next (letter.next) referring to 'start' list
		start = temp; // now start refers to the 'letter' instance thus making a single list and letter
		// is being added to the start of 'start' list.

	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to add a letter to the end of the word.
	 * 
	 * @param letter - the letter to be added.
	 */
	public void addToEnd(Letter letter) {
		Letter temp = start;
		if(start == null) {
			start = letter;
			return;
		}
		if(temp!=null) {
			/*
			 * traversing till end of list/start and then adding 'letter' at the end
			 */
			while(temp.next!=null) {
				temp= temp.next;
			}
			// Guaranteed: temp is null here, that means we have reached at the end of 'start' list
			temp.next= letter; // letter is added at end of 'start' list 
		}
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to check if the word is a valid word in the 
	 * given dictionary. Return false if word is empty.
	 * 
	 * @param dictionary - an array of String containing all valid words.
	 * @return true if the word is in the dictionary, false otherwise.
	 */
	public boolean isWord(String[] dictionary) {
		String wordToCheck ="";
		Letter temp = start;
		/*
		 * following loop feed the letters from 'start' in String 'wordToCheck'
		 */
		while(temp!=null) {
			wordToCheck+= temp.letter;
			temp= temp.next;
		}
		/*
		 * As now 'wordToCheck' is String we can perform array inbuilt functions on it
		 * it make a lot more easier to check as if 'wordToCheck' is a string of valid word or not
		 * here basis of valid word is 'dictionary' string
		 */
		for(int i =0; i<dictionary.length;i++) {
			if(dictionary[i].equals(wordToCheck)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 4 marks - Pass level.
	 * 
	 * Method to check if the word is a substring of a valid word in the
	 * given dictionary. The purpose of this method is to check whether 
	 * or not it is possible to add more letters to the current word 
	 * to make it valid (see assignment specification for more information).
	 * 
	 * Return true is the word is empty.
	 * 
	 * @param dictionary - an array of String containing all valid words.
	 * @return true if the word is empty or a substring of a valid word, false otherwise.
	 */
	public boolean isPossibleWord(String[] dictionary) {
		String wordToCheck ="";
		Letter temp = start;
		while(temp!=null) {
			/*
			 * this loop feed the letters from 'start' in String 'wordToCheck'
			 */
			wordToCheck+= temp.letter;
			temp= temp.next;
		}
		// As now 'wordToCheck' is String we can perform array inbuilt functions on it
		// it make a lot more easier to check as if 'wordToCheck' is a substring of valid word or not
		if(wordToCheck.isEmpty()) {
			return true;
		}
		for(int i =0; i<dictionary.length;i++) {
			if(dictionary[i].equals(wordToCheck)) {
				return true;
			}
			if(dictionary[i].contains(wordToCheck)) {
				// checking if 'wordToCheck' is a substring of any valid dictionary word
				return true;
			}
		}
		return false;

	}

	/**
	 * 4 marks - High Distinction level.
	 * 
	 * Method to create an array of letters representing the word. 
	 * You should return a reference copy and not an instance
	 * copy of the Letter objects.
	 * 
	 * You may have to complete other methods in this/other classes
	 * in order to receive full marks for this method.
	 * 
	 * @return an array containing the letters in the word.
	 */
	public Letter[] toArray() {
		/*
		 * this method create Letter[] (node array) from the 'start' list
		 * and then return it to the calling object.
		 */
		Letter[] arrOfLetters = new Letter[this.size()];
		Letter temp = start;
		int i=0;
		while(temp!=null && i<this.size()) {
			arrOfLetters[i] = temp;
			temp= temp.next;
			i++;
		}
		return arrOfLetters;
	}
}
