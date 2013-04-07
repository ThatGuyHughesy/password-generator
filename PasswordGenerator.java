import java.io.*;
import java.util.*;
import java.util.Random;

class PasswordGenerator
{
	public static void main (String [] args)
	{
		Length l = new Length();
		Generate g = new Generate();
		
		int random;
		
		l.get();
		
		for(int k = 0; k < l.length; k++)
		{
			random = new Random().nextInt(4);
			
			if(random == 0)
			{
				g.digit(l);
			}
			
			if(random == 1)
			{
				g.lowercase(l);
			}
			
			if(random == 2)
			{
				g.uppercase(l);
			}
			
			if(random == 3)
			{
				g.character(l);
			}
		}
		
		System.out.println("Your Randomly Generated Password Is: ");
		
		for(int j = 0; j < l.length; j++)
		{
			System.out.print(l.password[j]);
		}
	}
}

class Length
{
	int length = 0;
	String [] password = new String [1000];
	
	void get()
	{
		System.out.println("Enter Desired Password Length: ");
		Scanner in = new Scanner(System.in);
		while(length < 6)
		{
			try 
			{
				length = in.nextInt();
			} catch(Exception e) 			
			{
				System.out.println("Input Error");
				e.printStackTrace();
			}
			if(length < 6)
			{
				System.out.println("Your Password Must Be Greater Than 6 To Be Secure, Please Re-Enter!");
			}
		}
	}
}

class Generate
{
	int i = 0;
	String [] digits = {"1","2","3","4","5","6","7","8","9"};
	String[] lowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	String [] uppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	String [] characters = {"~","!","@","#","$","%","^","&","*","(",")","_","-","+","=","{","}","[","]","|",":",";","<",">",".","?"};
	
	void digit(Length l)
	{
		l.password[i] = digits[new Random().nextInt(8)];
		i++;
	}
	
	void lowercase(Length l)
	{
		l.password[i] = lowercase[new Random().nextInt(25)];
		i++;
	}
	
	void uppercase(Length l)
	{
		l.password[i] = uppercase[new Random().nextInt(25)];
		i++;
	}


	void character(Length l)
	{
		l.password[i] = characters[new Random().nextInt(25)];
		i++;
	}
}