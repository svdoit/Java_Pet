/*
 Soovin Do 887440766
 09-19-2019
 Make Virtual Pet and change status of that pet using classes
 Lab06-Classes Cont.
 */

package lab05;

import java.util.Scanner;

public class Pet {

	
	String PetName;
	int hunger, cleanliness, happiness, health;

	
	public void setPetName()
	{
		Scanner input = new Scanner(System.in);
		PetName = input.nextLine();
		//Get pet name and save in <String PetName>
	}
		
	public void feed(String petname)
	{
		petname = this.PetName; 
		//put <PetName> which was saved from <setPetName> in <petname> the <feed method>'s instance 
		
		hunger++;
		//increase hunger status because you feed your pet
		
		//make two random actions for feed method
		int feed_type = (int)(Math.random() * 2) + 1;
		//get feed_type randomly
		
		if(feed_type == 1)
		{
			System.out.println(petname + " jumps with joy as you offer a banana.(Hunger +1)");
		}
		else
		{
			System.out.println(petname + " dances with joy and devours pasta.(Hunger +1)");
		}
	}
	
	public void wash(String petname)
	{
		petname = this.PetName;
		//put <PetName> which was saved from <setPetName> in <petname> the <wash method>'s instance 
		
		cleanliness++;
		//increase cleanliness status because you washed your pet
		
		//make two random actions for feed method
		int wash_type = (int)(Math.random() * 2) + 1;
		//get wash_type randomly
		
		if(wash_type == 1)
		{
			System.out.println(petname + " brushes his hair and becomes slightly upset do to excessive knots.(+1 Cleanliness)");
		}
		else
		{
			System.out.println(petname + " puts up a fight to resist, however he gives in and becomes squeaky clean.(+1 Cleanliness)");
		}
	}
	
	public void play(String petname)
	{
		petname = this.PetName;
		//put <PetName> which was saved from <setPetName> in <petname> the <play method>'s instance 
		
		happiness++;
		//increase happiness status because you played with your pet
		
		//make two random actions for feed method
		int play_type = (int)(Math.random() * 2) + 1;
		//get play_type randomly
		
		if(play_type == 1)
		{
			System.out.println("You pet " + petname + "\n" + petname + 
					" pets you back then suddenly eats a spider from out of your hair.(+1 Happiness)");
		}
		else
		{
			System.out.println(petname + " climbs the  nearest tree.(+1 Happiness)");
		}
	}
	
	public void health(String petname)
	{		 
		petname = this.PetName;
		//put <PetName> which was saved from <setPetName> in <petname> the <health method>'s instance
		
		health++;
		//increase health status because you chose health menu for your pet
		
		//make two random actions for feed method
		int health_type = (int)(Math.random() * 2) + 1;
		//get health_type randomly
		
		if(health_type == 1)
		{
			System.out.println(petname + " goes for a bike ride.(+1 Health)");
		}
		else
		{
			System.out.println(petname + " thrashes around the vet's offie, breaking a window trying to escape from a shot.(Health +1)");
		}
	}
}
