//Sinead Coughlan
//R00128834
//Nov 5th 2015
//Santa day out CIT project

import java.util.Scanner;  // Needed for the Scanner class
public class SantaDayOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String anotherFamily;
		String familyName;
		String childsName; 
		String gender;
		int childsAge;
		int numChildren = 0;
		String tickets = "";
		final String AGE_BRACKET1 = "Under 1";
		final String AGE_BRACKET2 = "Between 2 and 4";
		final String AGE_BRACKET3 = "Between 5 and 12";
		final double AGE_COST1 = 0;
		final double AGE_COST2 = 5.00;
		final double AGE_COST3 = 7.50;
		double numAdults;
		final double ADULTS_COST = 2.50;
		double totalCost = 0;
		String picture;
		final double PICTURE_COST1 = 0;
		final double PICTURE_COST2 = 10.0;

		int numBookings=0;
		int totalNumChildren =0;
		int totalNumPhotosReq =0;
		double totalBookingValue =0;

		int girl =0;
		int girlAge2 =0;
		int girlAge3 =3;
		int boy =0;
		int boyAge2 =0;
		int boyAge3 =0;

		// Create a Scanner object to read input.
		Scanner keyboard = new Scanner(System.in);
		do
		{
			String familyDetails = "";
			do 
			{	//family name
				System.out.println("Enter the family Name:");
				familyName = keyboard.nextLine();
				if(familyName.length()==0)
				{ //input val
					System.out.println("Error - You must enter at least 1 Character!");
				}
			}while (familyName.length()==0);
			familyDetails+="Family Name: "+familyName;

			do{ //number of children
				System.out.println("How many children between the ages of 1 and 12:");
				while (!keyboard.hasNextInt())
				{//input val
					System.out.println("Error - You must enter at least one Number!!");
					keyboard.nextLine();

					System.out.println("How many children between the ages of 1 and 12:");
				}
				numChildren = keyboard.nextInt();
				if (numChildren <0)
				{
					System.out.println("Error - You must enter a positive Number!!");
				}
			}while  (numChildren <0);
			keyboard.nextLine();

			totalNumChildren +=numChildren;
			familyDetails +="\nNumber of children: "+numChildren;

			for (int child=1; child <= numChildren; child++)
			{			
				familyDetails +="\nChild " + child + ": ";
				do
				{	//first childs name ++
					System.out.println("Enter child "+ child +"s Name:");
					childsName = keyboard.nextLine();
					if(childsName.length()==0)
					{ //input val
						System.out.println("Error- You must enter at least 1 Character!");
					}
				}
				while (childsName.length()==0);

				familyDetails+=childsName +",";

				do
				{ //childs gender
					System.out.println("Is "+ childsName +" a girl or boy (g/b):");
					gender= keyboard.nextLine();
					if (gender.equalsIgnoreCase("g"))
					{

						girl =girlAge2;		//its displaying 1 as 2 and I don't know how to fix it.
						girl =girlAge3;		//its displaying 1 as 2 and I don't know how to fix it.
						familyDetails+= " girl, ";
					}
					else if (gender.equalsIgnoreCase("b"))
					{

						boy =boyAge2;		//its displaying 1 as 2 and I don't know how to fix it.
						boy =boyAge3;		//its displaying 1 as 2 and I don't know how to fix it.
						familyDetails+= " boy, "; 
					}
					else
					{ 	//input val
						System.out.println("Error - Must enter g or b:");
						System.out.println("Is "+ childsName +" a girl or boy (g/b):");
						gender= keyboard.nextLine();
					}
				} while (!gender.equalsIgnoreCase("g") && !gender.equalsIgnoreCase("b"));


				do{ //childs age
					System.out.println("How old is "+ childsName+":");
					while (!keyboard.hasNextInt())
					{	//input val
						System.out.println("Error- You must enter at least one Number!!");
						keyboard.nextLine();

						System.out.println("How old is "+ childsName+":");
					} 

					childsAge = keyboard.nextInt();
					if (childsAge<0)
					{
						System.out.println("Error - You must enter a positive Number!!");
					}
				}while  (childsAge <0);
				keyboard.nextLine(); //Clearing the buffer


				familyDetails += childsAge+" Years old,";
				String ticketType = "";
				if (childsAge <=1) 
				{
					ticketType = AGE_BRACKET1;
					totalCost += AGE_COST1;
					familyDetails+=" No present required, The cost is "+AGE_COST1;

				}
				else if (childsAge >1 && childsAge <=5)
				{
					girlAge2+=1;
					boyAge2+=1;
					ticketType = AGE_BRACKET2;
					totalCost += AGE_COST2;
					familyDetails+=" present required, The cost is "+AGE_COST2;	

				}
				else if (childsAge >5 && childsAge <=12)
				{
					girlAge3+=1;
					boyAge3+=1;
					ticketType = AGE_BRACKET3;
					totalCost += AGE_COST3;
					familyDetails+=" present required, The cost is "+AGE_COST3;	

				}
			}

			do{ 	//number of adults
				System.out.println("How many adults are attending:");
				while (!keyboard.hasNextDouble())
				{	//input val
					System.out.println("Error- You must enter at least one Number!!");
					keyboard.nextLine();

					System.out.println("How many Adults are attending:");
				}
				numAdults = keyboard.nextDouble();
				if (numAdults<0)
				{	//input val
					System.out.println("Error - You must enter a positive Number!!");
				}

			}while  (numAdults <0);
			keyboard.nextLine(); //Clearing the buffer

			if (numAdults >2)
			{			
				totalCost += ADULTS_COST*(numAdults-2);
				familyDetails+="\n2 adults free, "+(numAdults-2)+" at "+ADULTS_COST+" each.";
			}
			else
			{
				familyDetails+="\n"+numAdults+" Adults selected, No Cost.";
			}
			keyboard.nextLine(); //clearing the buffer when moving from reading a primitive data type to a string

			do 
			{ 	//picture??
				System.out.println("Do you want a picture (y/n):"); 
				picture = keyboard.nextLine();


				if (!picture.equalsIgnoreCase("y") && !picture.equalsIgnoreCase("n"))
				{	//input val
					System.out.println("Error");
				}
			}while (!picture.equalsIgnoreCase("y")&& !picture.equalsIgnoreCase("n"));
			totalNumPhotosReq++;

			if (picture.equalsIgnoreCase("n"))  // this could catch me be careful when comparing strings .equals(), 
			{									//.equalsIgnoreCase(), .compareTo(), .compareToIgnoreCase()
				totalCost +=PICTURE_COST1;
				familyDetails+="\nPicture Required: No, No extra cost.";
			}
			if (picture.equalsIgnoreCase("y"))
			{
				totalCost += PICTURE_COST2;
				familyDetails+="\nPicture Required: Yes, Cost: "+PICTURE_COST2;
			}	

			//displaying 
			totalBookingValue += totalCost;
			System.out.println("----------");
			System.out.println("\n Ticket");
			System.out.println("----------");
			System.out.println(familyDetails);
			System.out.println("Total Cost: "+totalCost);

			numBookings++;
			do
			{
				//Display “Enter the details for another customer (y/n)?”
				System.out.print("\nEnter the details for another customer (y/n)?");
				// Input Another Go
				anotherFamily = keyboard.nextLine();
				if (!(anotherFamily.equalsIgnoreCase("Y") || anotherFamily.equalsIgnoreCase("N")))
				{	//input val
					System.out.println("Error - you must enter Y or N!");
				}
			} while (!(anotherFamily.equalsIgnoreCase("Y") || anotherFamily.equalsIgnoreCase("N")));
		}while (anotherFamily.equalsIgnoreCase("Y"));

		System.out.println(" Summary ");
		System.out.println("---------");
		System.out.println("Total Number of bookings: "+numBookings);
		System.out.println("Total Number of children: " +totalNumChildren);
		System.out.println("Presents Required:");
		System.out.println("Age Range			Girls:				Boys:");
		System.out.println("----------			-------				------");	
		System.out.println(AGE_BRACKET1+":			   0				  0");
		System.out.println(AGE_BRACKET2+":           	   "+girlAge2+" 				  "+boyAge2); //its displaying 1 as 2 and I don't know how to fix it.
		System.out.println(AGE_BRACKET3+":		   "+girlAge3+" 				  "+boyAge3); //its displaying 1 as 2 and I don't know how to fix it.
		System.out.println("Photos Required: "+totalNumPhotosReq);
		System.out.println("Total Booking Cost: "+totalBookingValue);
	}
}