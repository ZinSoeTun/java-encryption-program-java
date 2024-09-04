import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JavaEencryption {
    //---------- These are private variables for needs to write the program -------------
	private Scanner scanner;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private char[] letters;
	
	JavaEencryption(){
		
		scanner = new Scanner(System.in);
		list = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();
		character = ' ';

		newKey();
		askQuestion();
	}
	
	//----------------- Ask question to user what to do in this program -----------------
	private void askQuestion(){
		while(true) {
			System.out.println("********************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			String response = scanner.nextLine().trim();
			
			if (response.isEmpty()) {
	            System.out.println("Please enter something ................");
	            continue;
	        }		
			switch(Character.toUpperCase(response.charAt(0))) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid answer :(");
			}
		}
	}
	
	//------------------- Generate the new key to process the rest part of program -----------------
     private void newKey(){
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList<Character>(list);
		Collections.shuffle(shuffledList);
		System.out.println("*A new key has been generated*");
		
	}
     
     //------------------- Get the key have generated to show -----------------
     private void getKey(){
 		System.out.println("Key: ");
 		for(Character x : list) {
 			System.out.print(x);
 		}
 		System.out.println();
 		for(Character x : shuffledList) {
 			System.out.print(x);
 		}
 		System.out.println();
 	}
     
     //------------------ Encryption process ------------------
 	private void encrypt(){
 		System.out.println("Enter a message to be encrypted: ");
 		String message = scanner.nextLine();
 		
 		letters = message.toCharArray();
 		
 		for(int i =0;i<letters.length;i++) {
 			
 			for(int j =0;j<list.size();j++) {
 				if(letters[i]==list.get(j)) {
 					letters[i]=shuffledList.get(j);
 					break;
 				}
 			}
 		}
 		System.out.println("Encrypted: ");
 		for(char x : letters) {
 			System.out.print(x);
 		}
 		System.out.println();
 	}
 	
 	//-------------- Decryption process
 	private void decrypt(){
		System.out.println("Enter a message to be decrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<shuffledList.size();j++) {
				if(letters[i]==shuffledList.get(j)) {
					letters[i]=list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}
 	
 	//------------- Quit the program -----------------
 	private void quit(){
		System.out.println("Thank you, have a nice day bro!");
		System.exit(0);
	}
}
