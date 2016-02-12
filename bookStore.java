//Needed for scanner class
import java.util.Scanner;

public class bookStore {
	
	//static variables to be accessed by all methods
	static int customerNumber = 0; //Used to determine 10% discount
	static int numBooks = 0; //Number of books bought
	static int numBookMarks = 0; //Number of book marks bought
	static int numPaintBooks = 0; //Number of paintings of books bought
	
	public static void main(String[] args){
		
		//Creation of new scanner object and input variable
		Scanner scanner = new Scanner(System.in);
		int input;
		
		//Asking user if there is someone in line to use program
		System.out.println("Is there a customer waiting in line?");
		System.out.print("Type 1 for yes or 2 for no: ");
		input = scanner.nextInt();
		//Switch case used to read user input
		switch (input){
			case 1:
				//Sends user to customerService method
				customerService();
			case 2:
				//Exits the program
				System.exit(0);
			
				
				
		}
	}
	
	//Method used to present the store to the user
	public static void customerService(){
		
		//New scanner object and input
		Scanner scanner = new Scanner(System.in);
		int input;
		double input2;
		//Initializing variables
		boolean bool = true; //Used to determine loop result
		double totalBookPrice = 0; //Total price of books bought
		double totalBookMarkPrice = 0; //Total price of book marks bought
		double totalPaintBookPrice = 0; //Total price of paintings of books bought
		double totalPrice; // Total price of order before taxes
		double discountTotalPrice; //Total price of order before taxes and after 10% discount
		double taxTotalPrice; //Total price after taxes
		double change = 0; //Change given to user after paying for order
		customerNumber++; //Incrementing this value for each customer to come to store
		
		//Welcoming message and presentation of items in store with prices
		System.out.print("Hello valued customer! This is the Oakland Bookstore!");
		System.out.println(" You are customer number " + customerNumber + "!");
		System.out.print("Here, you may choose from a few different things to buy.");
		System.out.println("These items and their prices are: ");
		System.out.println("Books: $5.00 each");
		System.out.println("Bookmarks: $1.00 each or $5.00 for a pack of 6");
		System.out.println("Paintings of Books: $100.00 each");
		System.out.print("Every third customer gets a 10% discount and don't forget ");
		System.out.println("sales tax is 7%!");
		
		//Loop used to allow user to buy books
		do{
			System.out.print("How many books would you like to buy? ");
			//If statement used for input validation
		if (scanner.hasNextInt()){
			//Determining number of books bought and price of order
			numBooks = scanner.nextInt();
			System.out.print("Do you have a bookworm card to get 25% off your books? ");
			System.out.print("Type 1 for yes or 2 for no: ");
			input = scanner.nextInt();
			//Switch case used to read user input
			switch (input){
			case 1:
				totalBookPrice = (numBooks * 5.00) - (numBooks * 5.00 * .25);
				System.out.printf("The total price of the books comes to $%.2f.\n", totalBookPrice);
				//Question and switch statement used to allow user to change order
				System.out.print("Is this okay? Type 1 for yes or 2 for no: ");
				input = scanner.nextInt();
				switch (input){
					case 1:
						bool = true;
						//Tells user their order as they buy more
						System.out.println("You have ordered " + numBooks + " books.");
						break;
					case 2:
						bool = false;
						break;
				}
				break;
			case 2:
				totalBookPrice = numBooks * 5.00;
				System.out.printf("The total price of the books comes to $%.2f.\n", totalBookPrice);
				//Question and switch statement used to allow user to change order
				System.out.print("Is this okay? Type 1 for yes or 2 for no: ");
				input = scanner.nextInt();
				switch (input){
					case 1:
						bool = true;
						//Tells user their order as they buy more
						System.out.println("You have ordered " + numBooks + " books.");
						break;
					case 2:
						bool = false;
				}
			}
		}
		else{
			scanner.nextLine();
			System.out.println("That is not a valid answer.");
			bool = false;
		}
		} while (bool == false);
		
		//Loop used to allow user to buy book marks
		do{
			System.out.print("How many bookmarks would you like to buy? ");
			//If statement used for input validation
		if (scanner.hasNextInt()){
			//Determining number of book marks bought and price of order
			numBookMarks = scanner.nextInt();
			//Equation used to allow user to buy packs of 6 book marks for 5 dollars
			totalBookMarkPrice = ((numBookMarks / 6) * 5.00) + (numBookMarks % 6) * 1.00; 
			System.out.printf("The total price of the bookmarks comes to $%.2f.\n", totalBookMarkPrice);
			//Question and switch statement used to allow user to change order
			System.out.print("Is this okay? Type 1 for yes or 2 for no: ");
			input = scanner.nextInt();
			switch (input){
				case 1:
					bool = true;
					//Tells user their order as they buy more
					System.out.println("You have ordered " + numBooks + " books and " + numBookMarks + " book marks.");
					break;
				case 2:
					bool = false;
			}
		}
		else{
			scanner.nextLine();
			System.out.println("That is not a valid answer.");
			bool = false;
		}
		} while (bool == false);
		
		//Loop used to allow user to buy paintings of books
		do{
			System.out.print("How many paintings of books would you like to buy? ");
			//If statement used for input validation
		if (scanner.hasNextInt()){
			//Determining number of paintings of books bought and price
			numPaintBooks = scanner.nextInt();
			totalPaintBookPrice = numPaintBooks * 100.00;
			System.out.printf("The total price of the books comes to $%.2f.\n", totalPaintBookPrice);
			//Question to allow user to change order
			System.out.print("Is this okay? Type 1 for yes or 2 for no: ");
			input = scanner.nextInt();
			switch (input){
				case 1:
					bool = true;
					//Tells user their order as they buy more
					System.out.print("You have ordered " + numBooks + " books, ");
					System.out.println(numBookMarks + " book marks and " + numPaintBooks + " paintings of books.");
					break;
				case 2:
					bool = false;
			}
		}
		else{
			scanner.nextLine();
			System.out.println("That is not a valid answer.");
			bool = false;
		}
		} while (bool == false);
		
		//If statement used to determine if customer gets the every third person discount
		if (customerNumber % 3 == 0){
			System.out.println("You are a third customer! You get a 10% discount!");
			//Determining total price, discount price, and price after taxes
			totalPrice = (totalBookPrice + totalBookMarkPrice + totalPaintBookPrice);
			discountTotalPrice = totalPrice - (totalPrice * .10);
			taxTotalPrice = discountTotalPrice * 1.07;
			//Formatting variable to appear with a dollar sign and to two decimals
			System.out.printf("The total price comes to $%.2f.\n", discountTotalPrice);
			System.out.printf("After tax your total comes to $%.2f\n", taxTotalPrice); 
		}
		else{
			//Determining total price and price after taxes
			totalPrice = totalBookPrice + totalBookMarkPrice + totalPaintBookPrice;
			taxTotalPrice = totalPrice * 1.07;
			//Formatting variable to appear with a dollar sign and to two decimal places
			System.out.printf("The total price of your order is $%.2f.\n", totalPrice);
			System.out.printf("After tax your total comes to $%.2f.\n", taxTotalPrice);
		}
		
		//Loop used for input validation
		do{
		//If statement used to allow user to pay for their order with a double value
		System.out.print("Please input your payment: ");
		input2 = scanner.nextDouble();
		if (input2 >= taxTotalPrice){
			//Determining change and formatting value to presented to user
			change = input2 - taxTotalPrice;
			System.out.printf("Your change is equal to $%.2f.\n", change);
			System.out.println("Thank you for shopping with us!");
			bool = true;
		}
		else{
			scanner.nextLine();
			System.out.println("That is not enough money.");
			bool = false;
		} 
		}while (bool == false);
		
		System.out.println("Here is your receipt.");
		
		//If statement used to present the user with their receipt
		//If user does not buy any of an item, the item will not appear on the receipt
		if (numBooks > 0){
			System.out.println(numBooks + " Books");
		}
		if (numBookMarks > 0){
			System.out.println(numBookMarks + " Book Marks");
		}
		if (numPaintBooks > 0){
			System.out.println(numPaintBooks + " Paintings of Books");
		}
		System.out.printf("Total = $%.2f.\n", taxTotalPrice);
		System.out.printf("Payment = $%.2f.\n", input2);
		System.out.printf("Change = $%.2f.\n", change);
		lineCheck();
		
	}
	
	//Method used to determine if there is another customer in line
	public static void lineCheck(){
		
		//New instance of scanner object and input
		Scanner scanner = new Scanner(System.in);
		int input;
		
		//Asking user if their is someone in line to use the program
		System.out.println("Is there a customer waiting in line?");
		System.out.print("Type 1 for yes or 2 for no: ");
		input = scanner.nextInt();
		//Switch case used to read user input
		switch (input){
			case 1:
				//Sends user to customer service method
				customerService();
				//Exits the program
			case 2:
				System.exit(0);
		}
		scanner.close();
	}
}
