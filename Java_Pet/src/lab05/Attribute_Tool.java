/*
 Soovin Do 887440766
 09-19-2019
 Make Virtual Pet and change status of that pet using classes
 Lab06-Classes Cont.
 */

package lab05;

public class Attribute_Tool {
	
	public static void cleanliness(Pet pet)
	{ //if user chooses wash menu, this method is working
		int stat_change1 = (int)(Math.random() * 2) + 1;
		//randomly print responses
	
		if(stat_change1 == 1)
		{
		System.out.println(pet.PetName + " gets tired. (-1 Health)");
		pet.health --;
		
		System.out.println(pet.PetName + " is hungry. (-1 Hunger)");
		pet.hunger --;
		
		System.out.println(pet.PetName + " is happy to be cleaned (+1 Happiness)");
		pet.happiness ++;
		}
		if(stat_change1 == 2)
		{
			System.out.println(pet.PetName + " is happy to be cleaned. (+1 Happiness)");
			pet.happiness ++;
			
			System.out.println(pet.PetName + " is hungry. (-1 Hunger)");
			pet.hunger --;
			
			System.out.println(pet.PetName + " is sad because he lost his banana during brushing his hair. (-1 Happiness)");
			pet.happiness --;
		}

	}
	
	public static void happiness(Pet pet)
	{
		int stat_change1 = (int)(Math.random() * 2) + 1;
		//randomly print responses
	
		if(stat_change1 == 1)
		{
		System.out.println(pet.PetName + " is starting to smell bad. (-1 Health)");
		pet.health --;
		
		System.out.println(pet.PetName + " has flu like symptoms. (-1 Health)");
		pet.health --;
		
		System.out.println(pet.PetName + " is looking a bit thin. (-1 Happiness)");
		pet.happiness --;
		}
		if(stat_change1 == 2)
		{
			System.out.println(pet.PetName + " is happy to be cleaned. (+1 Happiness)");
			pet.happiness ++;
			
			System.out.println(pet.PetName + " is about to vomit bananas. (-1 Hunger)");
			pet.hunger --;
			
			System.out.println(pet.PetName + " is sad because he lost his banana during brushing his hair. (-1 Happiness)");
			pet.happiness --;
		}

	}
	
	

	public static void health(Pet pet)
	{
		int stat_change1 = (int)(Math.random() * 2) + 1;
		//randomly print responses
	
		if(stat_change1 == 1)
		{
		System.out.println(pet.PetName + " is muddy from rolling around in the dirt. (+1 Happiness)");
		pet.happiness ++;
		
		System.out.println(pet.PetName + " is about to gnaw off his leg from hunger. (-1 Health)");
		pet.health --;
		}
		if(stat_change1 == 2)
		{
			System.out.println(pet.PetName + " is starting to smell bad. (-1 Health)");
			pet.health --;
			
			System.out.println(pet.PetName + " has flu like symptoms. (-1 Happiness)");
			pet.happiness --;
			
			System.out.println(pet.PetName + " is about to gnaw off his leg from hunger. (-1 Health)");
			pet.health --;
		}

	}
	
	public static void hunger(Pet pet)
	{
		int stat_change1 = (int)(Math.random() * 2) + 1;
		//randomly print responses
	
		if(stat_change1 == 1)
		{
		System.out.println(pet.PetName + " gets tired. (-1 Health)");
		pet.health --;
		
		System.out.println(pet.PetName + " gets dirty after eating something. (-1 Cleanliness)");
		pet.cleanliness --;
		
		System.out.println(pet.PetName + " is happy to eat something (+1 Happiness)");
		pet.happiness ++;
		}
		if(stat_change1 == 2)
		{
			System.out.println(pet.PetName + " is happy to eat something. (+1 Happiness)");
			pet.happiness ++;
			
			System.out.println(pet.PetName + " is hungry. (-1 Hunger)");
			pet.hunger --;
			
			System.out.println(pet.PetName + " gets healthy after eating dissert. (+1 Health)");
			pet.health++;
		}

	}
	
	//return boolean stat. if cleanliness, happiness, health, hunger is same or lower than 0,
	//boolean changes into false and kill virtual pet in main method
	public static boolean checkCleanliness(Pet pet)
	{
		boolean stat = true;
		
		if (pet.cleanliness<=0)
		{
			stat = false;
		}
		
		return stat;	
	}
	
	public static boolean checkHappiness(Pet pet)
	{
		boolean stat = true;
		
		if (pet.happiness<=0)
		{
			stat = false;
		}
		
		return stat;	
	}
	
	public static boolean checkHealth(Pet pet)
	{
		boolean stat = true;
		
		if (pet.health<=0)
		{
			stat = false;
		}
		
		return stat;	
	}
	
	public static boolean checkHunger(Pet pet)
	{
		boolean stat = true;
		
		if (pet.hunger<=0)
		{
			stat = false;
		}
		
		return stat;	
	}
}
