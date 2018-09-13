package Email.SaveData;

public class EmailDemo {
	public static void main(String[] args) {
		System.out.println( "Welcome to Email Client" );
		System.out.println("We adding = "+"tony "+"pena "+"tony@qc.com "+"123psw"+"\n");
		
		User usr1 = new User("tony","pena","tony@qc.com","123psw");
		usr1.checkUserName("tony@qc.com");
		//DB test = new DB("Constructor.com");
		//String s="Setter";
		//test.setUserName(s);
		//test.findUser(s);
		//other comment for github test
		//creating more comments to identify if git can push to that one branch of code modify
		
	}
}
