import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

   /* This is a Java programme for playing the game Hangman
    */

static List<Character> secretWord = new ArrayList<>();
static String chosenWord;
static List<Character> gameBoard = new ArrayList<>();
static char guess;
static int incorrectGuesses;

   public static void main(String []args) {
      chooseWord();
	  
	  generateGameboard();
	  
	  printGameboardState();
	  
	  while(incorrectGuesses<10 && checkWin() == false){
	  takeUserGuess ();
	  
	  checkUserGuess();
	  
	  printGameboardState();
	  }
	  
	  if (checkWin()) {
		System.out.println("You have correctly guessed the full word! Congratulations, you have won!");
	  }
	  
	  if (incorrectGuesses == 10){
		  System.out.println("Sorry, you have made too many incorrect guesses! You lose!");
	  }
   }
   
   public static void chooseWord() {
	Random randomNumbers = new Random ();
	int randomSelection = randomNumbers.nextInt(1, 6);
	
	chosenWord = "WORD";
	
	switch (randomSelection) {
		case 1: 
			chosenWord = "GAME";
			break;
		case 2: 
			chosenWord = "HANGMAN";
			break;
		case 3: 
			chosenWord = "BERMUDA";
			break;
		case 4: 
			chosenWord = "ALPHABET";
			break;
		case 5: 
			chosenWord = "FLOCCINAUCINIHILIPILIFICATION";
			break;	
		default:
			break;
	}
		
	for (char ch:chosenWord.toCharArray()) {
		secretWord.add(ch);
	}
	
	/* The following code was used to check the functioning of the application, by displaying the chosen word ahead of the game
	System.out.println ("The randomly chosen word is: " + secretWord);
	
	System.out.println("The size of the chosen word is: " + secretWord.size());
	*/
   }
   
   public static void generateGameboard(){

	for (char ch : secretWord){
	gameBoard.add('_');
	}
	
   }
   
   public static void printGameboardState(){
	System.out.println("The gameboard currently looks like this: " + gameBoard);
	System.out.println("You have made: " + incorrectGuesses + " out of 10 incorrect guesses");
   }
   
   public static void takeUserGuess (){
	Scanner input = new Scanner(System.in);
	
	System.out.println("Please enter your guess");
	
	guess = input.findInLine(".").charAt(0);
	
	guess = Character.toUpperCase(guess);
	
	System.out.println("The guess you have entered is: " + guess);
	}

   public static void checkUserGuess (){
	   
	   boolean correctGuess = false;
	   
	   for(int i=0;i<secretWord.size();i++)
	   {
		if (secretWord.get(i) == guess){
			 gameBoard.set(i, guess);
			 correctGuess = true;
		}		   
	   }
		
		if(correctGuess){
			System.out.println("Well done, that letter is in the word!");
		}
		else {
			System.out.println("Sorry, that guess is incorrect");
			incorrectGuesses++;
		}
   }
   
   public static boolean checkWin (){
	if (gameBoard.equals(secretWord)){
		return true;
	}
	else {
		return false;
	}
   }
}