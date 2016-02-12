import java.util.Scanner; //for the scanner class
import java.util.Random;  //for the random class
public class projectTwo 
{
	public static void main(String[] args)
	{ 
		// for user keyboard input
		Scanner keyboard = new Scanner(System.in); 
		// variable to hold user's name
		String name;
		// asking for user's name
		System.out.println("Enter your name: ");   
		name = keyboard.nextLine();  
		// personalized greeting for user
		System.out.println("Hello " + name + "!");
		System.out.println("My name is Aaron. Welcome to the game Rockymon!");
		// description of the game
		System.out.println("In this game, you will role two dice.");
		System.out.println("This is called the \"Big start roll\".");
		System.out.println("If you roll a 5 or 10, you win!");
		System.out.println("If you roll a 2, 4, or 11, you lose.");
		System.out.println("Rolling any other number makes the big start roll " + 
		                    "the \"match number\".");
		System.out.println("You must roll the dice until one of two things happen:");
		System.out.println("You roll a 5 and lose or you roll the match number and win!");
		System.out.println("You may also have the computer play the game!");
		System.out.println("You can even decide how many times it should play the game!");
		System.out.println("Good luck and have fun!");
	    
		//initialization of variables
		int input; //used to get user input
		int repeat; // used for while loop
		
		//ask user if they'd like to play the game
		System.out.println("Would you like to roll the dice?");
		System.out.println("Choose 1, 2, or 3: ");
		input = keyboard.nextInt();
		//loop used to check user input
		do
		{
			repeat = input;
			//switch case used to determine action of user's answer
			switch (input)
			{
				case 1:
					manualRollDice();
					break;
				case 2:
					computerRollDice();
					break;
				case 3:
					System.out.println("Thanks for playing Rockymon!");
					break;
				default:
					System.out.println("Please choose 1, 2, or 3: ");
					input = keyboard.nextInt();
					break;
			}
		} while (repeat != 1 && repeat != 2 && repeat != 3);
	}
		//method used for the first roll of the dice
		public static void manualRollDice()
		{
			//needed for scanner class
			Scanner keyboard = new Scanner(System.in);
			//initialization of variables
			int number1;
			int number2;
			int bigStartRoll;
			int matchNumber;
			String input;
			char repeat;
			
			//loop used to roll the dice for the first time
			do
			{
				//rolling of two six-sided dice
				Random rand = new Random();
				number1 = rand.nextInt(6) + 1;
				number2 = rand.nextInt(6) + 1;
				bigStartRoll = number1 + number2;
				System.out.println("The big start roll is " + bigStartRoll + "!");
				
				//switch case used to determine result of the dice roll
				//default calls on method to continue rolling the dice
				switch (bigStartRoll)
				{
					case 5:
					case 10:
						System.out.println("You win!");
						System.out.println("You get a point!");
						break;
					case 2: 
					case 4:
					case 11:
						System.out.println("You lose!");
						break;
					default:
						System.out.println("You have to roll again!");
						System.out.println("The big start roll is now the match number!");
						matchNumber = bigStartRoll;
						System.out.println("The match number is " + matchNumber + "!");
						matchNumberRolls(matchNumber);
				}
				
				//ask if user would like to play again
				//end the game if user doesn't choose yes
				System.out.println("Would you like to start Rockymon again?");
				System.out.println("Please choose Y or N: ");
				input = keyboard.nextLine();
				repeat = input.charAt(0);
			} while (repeat == 'y' || repeat == 'Y');

		}
				//method for default switch of first roll
				//allows player to choose to continue rolling to win or lose
				public static void matchNumberRolls(int newMatchNumber)
				{
					//needed for scanner class
					Scanner keyboard = new Scanner(System.in);
					
					//initialization of variables
					int number1;
					int number2;
					int newRoll;
					String input;
					char repeat;
					
					//asking player if they would like to roll again
					System.out.println("Would you like to roll again?");
					System.out.println("Choose Y or N: ");
					input = keyboard.nextLine();
					repeat = input.charAt(0);
					
					//loop used to roll the dice again after first roll
					//rolls as long as user keeps saying yes
					do
					{
						//switch case for rolling the dice or ending the game
						switch (repeat)
						{
							case 'y':
							case 'Y':
								Random rand = new Random();
								number1 = rand.nextInt(6) + 1;
								number2 = rand.nextInt(6) + 1;
								newRoll = number1 + number2;
								System.out.println("The new roll is " + newRoll);
								
								//if statement used to determine whether user wins, +
								//loses, or has to roll again
								//loop allows user to stop rolling even if they +
								//don't win
								if (newRoll == newMatchNumber)
								{
									System.out.println("You win!");
									System.out.println("You get a point!");
									repeat = 'n';
								}
								else if (newRoll == 5)
								{
									System.out.println("You lose!");
									repeat = 'n';
								}
								else
								{	
									System.out.println("You need to roll again!");
									System.out.println("Would you like to roll again?");
									System.out.println("Choose Y or N: ");
									input = keyboard.nextLine();
									repeat = input.charAt(0);
								}
								break;
							default:
								break;
						}
						
					} while (repeat == 'y' || repeat == 'Y');
					
				}
				
				public static void computerRollDice()
				{
					Scanner keyboard = new Scanner(System.in);
					
					int input;
					int number;
					
					int number1;
					int number2;
					int bigStartRoll;
					int matchNumber;
					
					System.out.print("How many times would you like the computer ");
					System.out.println("to play the game: ");
					input = keyboard.nextInt();
					
					for (number = 0; number < input; number++)
					{
						
						//rolling of two six-sided dice
						Random rand = new Random();
						number1 = rand.nextInt(6) + 1;
						number2 = rand.nextInt(6) + 1;
						bigStartRoll = number1 + number2;
						System.out.println("The big start roll is " + bigStartRoll + "!");
						
						//switch case used to determine result of the dice roll
						//default calls on method to continue rolling the dice
						switch (bigStartRoll)
						{
							case 5:
							case 10:
								System.out.println("You win!");
								System.out.println("You get a point!");
								break;
							case 2: 
							case 4:
							case 11:
								System.out.println("You lose!");
								break;
							default:
								System.out.println("You have to roll again!");
								System.out.println("The big start roll is now the match number!");
								matchNumber = bigStartRoll;
								System.out.println("The match number is " + matchNumber + "!");
								computerMatchNumberRolls(matchNumber);
						}
						
					}
					
							
				}
				
				public static void computerMatchNumberRolls(int newMatchNumber)
				{
					int number1;
					int number2;
					int newRoll;
					
					
					do
					{
						Random rand = new Random();
						number1 = rand.nextInt(6) + 1;
						number2 = rand.nextInt(6) + 1;
						newRoll = number1 + number2;
						System.out.println("The new roll is " + newRoll);
						
						if (newRoll == newMatchNumber)
						{
							System.out.println("You win!");
							System.out.println("You get a point!");
						}
						else if (newRoll == 5)
						{
							System.out.println("You lose!");
						}
						else
						{	
							System.out.println("You need to roll again!");
						}
					} while (newRoll != newMatchNumber && newRoll != 5);
				}
}
