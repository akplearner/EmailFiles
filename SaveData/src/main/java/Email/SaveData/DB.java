package Email.SaveData;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DB 
{
//Instant Variables
	private String userName;

//constructor
	DB(){
		userName = "Null";
	}
	DB( String userNameTemp){
		userName = userNameTemp;
		this.setUserName(userNameTemp);
		
	}
//setters and getters
	public void setUserName(String userNameTemp) {
		String fileName = "Users.txt";
		
        PrintWriter outputStream = null; 
        try {
        	outputStream = new PrintWriter(fileName);
        }catch(FileNotFoundException e) {
        	System.out.println("Error opening the file" + fileName);
        	System.exit(0);
        }
        outputStream.println(userNameTemp);
        outputStream.close();
        System.out.println("Those lines were written to " + fileName);
	}

//Methods
	public boolean findUser(String usrName) {
		String fileName = "Users.txt"; 
		Scanner inputStream = null;
		System.out.println("The file " + fileName + " contains the following lines:\n");
		try {
			inputStream = new Scanner(new File(fileName)); 
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0); 
		}
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
			if(line == usrName) {
				System.out.println("True");
				return true;
			}
		} 
		inputStream.close();
		System.out.println("False");
		return false;
	}   
}
