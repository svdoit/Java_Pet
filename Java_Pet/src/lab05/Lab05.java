/*
 Soovin Do 887440766
 09-19-2019
 Make Virtual Pet and change status of that pet using classes
 Lab06-Classes Cont.
 */

package lab05;

import java.util.Scanner;

public class Lab05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("-Virtual Orangutan-" + "\n"
						+ "-----m------m------" + "\n"
						+ "     @(o.o)@    " + "\n"
						+ "       (0)~~" + "\n"
						+ "       o o");
		
		System.out.println("Please Enter a name for your pet\nOrangutan: ");
		
		Pet Virtual_Pet = new Pet(); //declare to use Pet class
		Virtual_Pet.setPetName(); 
		//get virtual orangutan's name. It will be saved in <String PetName> in <Pet class>
		
		Virtual_Pet.hunger = (int)(Math.random()*10) + 1;
		Virtual_Pet.cleanliness = (int)(Math.random()*10) + 1;
		Virtual_Pet.happiness = (int)(Math.random()*10) + 1;
		Virtual_Pet.health = (int)(Math.random()*10) + 1;
		//Set Orangutan's status in random.
		//Those will be saved in <int hunger, cleanliness, happiness, health> in <Pet class> and used to show status of virtual pet.
		
		System.out.println("Initializing Stats...");
		printStatus(Virtual_Pet);
		
		System.out.println("\n" + Virtual_Pet.PetName + " was born!\n");		
		
		int i=1;
		
		while(i<10)
			{
			//printStatus(Virtual_Pet);
			Main_Menu(Virtual_Pet, Virtual_Pet.hunger, Virtual_Pet.cleanliness, Virtual_Pet.happiness, Virtual_Pet.health);
			printStatus(Virtual_Pet);
			checkAttributes(Virtual_Pet);
			
			if (!Attribute_Tool.checkCleanliness(Virtual_Pet)||!Attribute_Tool.checkHappiness(Virtual_Pet)||!Attribute_Tool.checkHealth(Virtual_Pet)||!Attribute_Tool.checkHunger(Virtual_Pet))
			{
				//if there is <false stat> in boolean
				System.out.println("Insufficient stat: " + Virtual_Pet.PetName + " has died");
				System.exit(-1);
			}
			i++;
			}
		//Loop to repeat making a choice in Main Menu. It repeats 10 times.  
		
		
		printStatus(Virtual_Pet); //Print Virtual_Pet's status
		System.out.println(Virtual_Pet.PetName + " Died of old age"+"\n"+"Quitting Program...");
		//After choice making repeats 10 times, virtual pet dies.  
		
		
		
	}
	
	public static void printStatus(Pet pet)
	{		
		System.out.println("\n-" + pet.PetName + "'s Stats-");
		System.out.println("Hunger: " + pet.hunger);
		System.out.println("Cleanliness: " + pet.cleanliness);
		System.out.println("Happiness: " + pet.happiness);
		System.out.println("Health: " + pet.health);
		//Print present status of virtual pet
	}
	
	public static void Main_Menu(Pet pet, int stat1, int stat2, int stat3, int stat4)
	{
		System.out.println("\nMain Menu:\n1.Feed\n2.Wash\n3.Play\n4.Health\n5.-Quit-\nEnter a number(1-5)");
		//Print Main Menu on Console
		
		Scanner input = new Scanner(System.in); //Use scanner
		int menu;	
		menu = input.nextInt();
		//Get user's choice in <menu>
		
		//pet.m=menu; //get <menu> in <int m> of <pet of Pet class>
		
		if(menu==1)
		{
			pet.feed(pet.PetName);  
			Attribute_Tool.hunger(pet);
		} //If user choose 1, <feed method> will be used. 
		if(menu==2)
		{
			pet.wash(pet.PetName);
			Attribute_Tool.cleanliness(pet);
		} //If user choose 2, <wash method> will be used.
		if(menu==3)
		{
			pet.play(pet.PetName);
			Attribute_Tool.happiness(pet);
		} //If user choose 3, <play method> will be used.
		if(menu==4)
		{
			pet.health(pet.PetName);
			Attribute_Tool.health(pet);
		} //If user choose 4, <health method> will be used.
		if(menu==5)
		{
			System.out.println("Stop take caring " + pet.PetName);
			System.exit(0); //If user choose 5, you can stop choosing menu on Main Menu
		}
		
		//pet.setMenu(); 
		//use <setMenu() method> of <Pet class> to show results of each choice depending on the choice that user made
		
		//return menu;
		//<menu> returned in here will be used in <setMenu() method> in <Pet class>
		
	}
	
	public static void checkAttributes(Pet orangutan)
	{
		//check status of cleanliness, happiness, health, hunger
		//this method is used to kill virtual pet if any status is same or lower than 0
		Attribute_Tool.checkCleanliness(orangutan);
		Attribute_Tool.checkHappiness(orangutan);
		Attribute_Tool.checkHealth(orangutan);
		Attribute_Tool.checkHunger(orangutan);
	}

}
