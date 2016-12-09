import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class VMwareTest {

	public static char firstNonRepeatedCharacter(String word)
	{ 
		HashMap<Character,Integer> scoreboard = new HashMap<>(); 
	for (int i = 0; i < word.length(); i++) 
	{ 
		char c = word.charAt(i); 
		if (scoreboard.containsKey(c)) 
		{ 
			scoreboard.put(c, scoreboard.get(c) + 1); 
			} 
		else 
		{ scoreboard.put(c, 1); 
		} 
		} 
	for (int i = 0; i < word.length(); i++)
	{ 
		char c = word.charAt(i); 
		if (scoreboard.get(c) == 1)
		{ 
			return c;
			}
		}
	throw new RuntimeException("Undefined behaviour");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String s= new String("aaba");
	char c=firstNonRepeatedCharacter(s);
	System.out.println(c);
	    
		
	}	
}
