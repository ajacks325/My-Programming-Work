import java.util.Scanner; // Needed for scanner
 
//This program is a budget calculator.
//It allows the user to store their rent and monthly expenses as variables.
//It will then use that information to find their gross pay, net pay,
//and percentage of gross pay spent on utilities.

public class BudgetCalculator
{
	public static void main(String[] args)
	{
		// Asking user to input name
        String name;
        Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name here: ");
		name = keyboard.nextLine();
		
		// Personalized welcome message for the user of the program
		System.out.println("Hello " + name + "! My name is Aaron Jackson.");
		System.out.println("This program is a budget calculator.");
		System.out.println("You can use it to calculate " + "your budget for things like:");
		System.out.println("Gross pay" + "\nRent" + "\nMonthly expenses");
		
		//Variables declared for users input
		double hourlyRate, overtimeRate, hoursWorked, overtimeHoursWorked, rent, 
		electricBill, waterBill, sewageBill, gasBill, food, entertainment, car;
					
		System.out.println("Enter your hourly rate here: "); // Prompt user to enter hourly rate
		hourlyRate = keyboard.nextDouble();
		
		System.out.println("Enter your overtime rate here: "); // Prompt user to enter overtime rate
		overtimeRate = keyboard.nextDouble();
		
		System.out.println("Enter your monthly hours worked here: "); // Prompt user to enter hours worked per month
		hoursWorked = keyboard.nextDouble();
		
		System.out.println("Enter your monthly overtime hours worked here: "); // Prompt user to enter overtime hours
		overtimeHoursWorked = keyboard.nextDouble();                           // worked per month
		
		System.out.println("Enter your monthly rent here: "); // Prompt user to enter monthly rent
		rent = keyboard.nextDouble();
		
		System.out.println("Enter the percentage of pay for electric bill here: "); // Prompt user to enter percent 
		electricBill = keyboard.nextDouble();                                       // pay for electric bill
		
		System.out.println("Enter the percentage of pay for water bill here: "); // Prompt user to enter percent
		waterBill = keyboard.nextDouble();                                       // pay for water bill
		
		System.out.println("Enter the percentage of pay for sewage bill here: "); //Prompt user to enter percent
		sewageBill = keyboard.nextDouble();                                       // pay for sewage bill
		
		System.out.println("Enter the percentage of pay for gas bill here: "); // Prompt user to enter percent
		gasBill = keyboard.nextDouble();                                       // pay for gas bill
		
		System.out.println("Enter monthly food expenses here: "); // Prompt user to enter money spent on food
		food = keyboard.nextDouble();                             // per month
		
		System.out.println("Enter monthly entertainment expenses here: "); // Prompt user to enter money spent on
		entertainment = keyboard.nextDouble();                             // entertainment per month
				
		System.out.println("Enter monthly car expenses here: "); // Prompt user to enter money spent on
		car = keyboard.nextDouble();                             // car per month
		
		// Method used to print out values input by user
		System.out.printf("Your hourly rate is $%.2f.\n", hourlyRate);
		System.out.printf("Your overtime rate is $%.2f.\n", overtimeRate);
	    System.out.printf("Your monthly hours worked is %.2f.\n", hoursWorked); 
		System.out.printf("Your monthly overtime hours worked is %.2f.\n", overtimeHoursWorked);
		System.out.printf("Your monthly rent is $%.2f.\n", rent);
		System.out.printf("Percentage of pay for electric bill is %.2f%%.\n", electricBill);
		System.out.printf("Percentage of pay for water bill is %.2f%%.\n", waterBill);
	    System.out.printf("Percentage of pay for sewage bill is %.2f%%.\n", sewageBill);
		System.out.printf("Money spent on food per month is $%.2f.\n", food);
		System.out.printf("Money spent on entertainment per month is $%.2f.\n", entertainment);
	    System.out.printf("Money spent on car per month is $%.2f.\n", car);
		
	    // Variable declaration for final pay and deductions
		double grossPay, netPay, deductions, electricPay, waterPay, sewagePay,
		gasPay; 
		
		grossPay = (hourlyRate * hoursWorked) + (overtimeRate * overtimeHoursWorked);
		electricPay = grossPay * (electricBill/100);
		waterPay = grossPay * (waterBill/100);
		sewagePay = grossPay * (sewageBill/100);
		gasPay = grossPay * (gasBill/100);
		deductions = electricPay + waterPay + sewagePay + gasPay + rent + food + entertainment + car;
		netPay = grossPay - deductions;
		
		System.out.printf("Your gross pay is $%.2f.\n", grossPay);
		System.out.printf("Your deductions are $%.2f.\n", deductions);
		System.out.printf("Your net pay is $%.2f.\n", netPay);
		
	}
	

}
