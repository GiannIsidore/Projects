
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.util.Scanner;
import java.util.Date;
public class CASHERINGSYSTEM {
	//for scanners and inputs--------------------------------------------------------------------------------------------------------------
	public static Scanner scanner = new Scanner(System.in);
	//for adding all the sub total--------------------------------------------------------------------------------------------------------
	public static double totlPrc= 0;
	public static String moneyAmnt= "";
	public static double moneyAmntP= 0;
	//for invalid input and catches--------------------------------------------------------------------------------------------------------
	public static boolean loop= false;
	//for receipt and for ordering again--------------------------------------------------------------------------------------------------
	
	public static String list="", answer="";
    public static String CashierName="";
	public static String username="";
	
	//products and prices------------------------------------------------------------------------------------------------------------------
	public static Object[][] product = 
		{ 
            {"Matcha \t", 75.0},{"Strawberry \t", 65.0},
            {"Machiatto \t", 55.0},{"Spanish Latte", 60.0},
            {"Americano \t", 65.0},{"Hazelnut \t", 65.0},
            {"Seasalt Caramel", 65.0},{"Viet coffee \t", 65.0},
            {"Chocolate \t", 65.0},{"Ciannamon Cof.",65.0},
        };
	
	//login and register-------------------------------------------------------------------------------------------------------------------
	public static String regAndLogin() {
		System.out.println("Register Cashier: \n" + 
                ">>>");
		CashierName = scanner.nextLine();

		System.out.println("Password: \n" + 
                ">>>");
		String cashierpass = scanner.nextLine();

		boolean login = true;
		while (login) {
			System.out.println("Username: \n " + 
					">>>  ");
			String username = scanner.nextLine();

			System.out.println("Password: \n " + 
                ">>> ");
			String password = scanner.nextLine();

			if((!username.equals (CashierName)) && (!password.equals (cashierpass))){
				System.out.println("The username and password are incorrect, Try again \n");

			}
			else if((username.equals (CashierName)) && (password.equals (cashierpass)))
			{
				System.out.println("Welcome");
				login = false;
			}
			else if ((!username.equals (CashierName))){
				System.out.println("The username is incorrect \n");
			}
			else if ((!password.equals(cashierpass))){
				System.out.print("The password was incorrect, Try again \n");
			} 
		
		

		}
		product();
		return "";
	}
	
	//menu ----------------------------------------------------------------------------------------------------------------------------------------
	public static int product() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("_________________________________________");
		System.out.println("|    WELCOME TO OUR ALWAYS COFFEE !     |");
		System.out.println("|_______________________________________|");
		System.out.println("");
		System.out.println("MENU: \t\t\t\tPRICES");
		for(int i = 0; i< product.length; i++) {
			System.out.printf("[%d]%s\t\t%.1f\t%n",i+1,product[i][0],product[i][1]);
		}
		boolean another_product=true;
		
		while (another_product) {
			String prod_num ="";
			int prod_numP= 0;
			
			do {
				try {   
				System.out.print("\n\nSelect Your desired coffee:  ");
				prod_num= scanner.next();
				prod_numP = Integer.parseInt(prod_num);
				
					if(prod_numP<=0 | prod_numP>=11){
						System.out.println("\n\nInvalid input, Please try again");
						loop=true;
						}else {
							loop = false;
						}
					
				} catch (Exception e) {
					System.out.println("\n\nInvalid input, Please try again");
					loop=true;
					
				}
				
				}while(loop);
			
			int item_quanP = 0;
			String quan ="";
			do {
				try {
					System.out.print("Enter quantity:    ");
					quan=scanner.next();
					item_quanP=Integer.parseInt(quan);
					if(item_quanP<=0){
						System.out.println("");
						System.out.println("Invalid input, Please try again");
						loop=true;
						}else {
							loop = false;
						}
					
				}catch (NumberFormatException e) {
					System.out.println("");
					System.out.println("Invalid input, Please try again");
					loop=true;
					
				}
			} while (loop);
			
			double price=(double)product[prod_numP -1][1];//access array list for price
			double subtotal= price*item_quanP;
			String nameKape =(String)product[prod_numP -1][0];//access array list for item name
			list += String.format("%n  %s %.1f \t    %d\t\t  %.1f", nameKape, price, item_quanP, subtotal);
			totlPrc+=subtotal;
			System.out.print("");
					System.out.println("_________________________________________________");
					
			System.out.printf("%n  Item name \t Price \t Quantity \t Subtotal%n");
					System.out.println("_________________________________________________");
			System.out.println(list);
			
			do {
				loop=true;
				System.out.println("");
				System.out.println("");
				System.out.println("Would you like to add another product? y or n? ");
				answer = scanner.next();
				
				if(answer.equalsIgnoreCase("y")) {
					//for showing menu again-----------------------------------------------------------------------------------------------
					System.out.println("MENU: \t\t\t\tPRICES");
					for(int i = 0; i< product.length; i++) {
						System.out.printf("[%d]%s\t\t%.1f\t%n",i+1,product[i][0],product[i][1]);
					}
					
					loop=false;
				}
				else if(answer.equalsIgnoreCase("n")) {
					loop=false;
					another_product=false;
					payment();
					
				}
				else { System.out.println("Invalid input");
					loop = true;}
				
			}while(loop);
			
		
			
		}
		return(0);
	}
	
       public static int payment() {
    	   do {
    		   
    		   try {
    			   System.out.println("");
    			   System.out.printf("%n  Item  \t Price \t Quantity \t Subtotal%n");
    	    	   System.out.println(list);
    	    	   System.out.println("");
    	    	   System.out.printf("Total ....................................%.1f", totlPrc);
    	    	   System.out.print("\nMoney Tendered ............................");
    	    	   moneyAmnt=scanner.next();
    	    	   moneyAmntP=Double.parseDouble(moneyAmnt);
    	    	   
    	    	   if(moneyAmntP<totlPrc) {
    	    		   
    	    		   System.out.println("Insufficient Money Tendered! ");
    	    		   loop=true;
    	    	   }else {
    	    		   loop=false;
    	    		   resibo();
    	    		   }
    		   }catch(Exception e) {
    			   System.out.println("invalid input!! ");
    			 loop=true;
    			   
    		   }
    	   
    	
    	      }while(loop);
    	   
	return(0);
    }
       public static int resibo() {
    	   
    	   
    	   System.out.println("");
    	   System.out.println("");
    	   System.out.println("");
    	   System.out.println("-----------------ALWAYS-COOFFEE-------------------");
    	   System.out.println("       FJMQ+QF5 Always Coffee, Vamenta Blvd,\r\n"
    	   		+ "         Cagayan de Oro, Misamis Oriental");
    	   System.out.println("");
    	   System.out.printf("%n  Item  \t Price \t quantity \t Subtotal%n");
    	   System.out.println(list);
    	   System.out.println("");
    	   System.out.println("***********************************************");
    	   System.out.printf("Change:           "+ (moneyAmntP-totlPrc));
    	   System.out.println("");
    	   System.out.printf("Cashier:          "+        CashierName);
    	   
    	   
    	   return(0);
       }
	
	

	public static void main(String[] args) {
		regAndLogin();

		               
	}
}