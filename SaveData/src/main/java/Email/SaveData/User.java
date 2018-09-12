package Email.SaveData;

public class User {
//instant variables
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String createdDate;
//constructor
	User(){
		firstName = "Null";
		lastName = "Null";
		userName = "Null";
		password = "Null";
		createdDate = "Null";
	}
	User(String fN,String lN,String uN,String pW){
		firstName = fN;
		lastName = lN;
		userName = uN;
			this.setUserName(userName);
		password = pW;
		createdDate = "Need to configure function";
	}
//getters and setters
	public void setUserName(String usrName) {
		userName = usrName;
		DB Connect = new DB(userName);
	}
	public void setPassword(String pWord) {
		password = pWord;
	}
	//set rest of setters

//methods
	public void getDomain() {
		
	}
	public void checkUserName(String userFind) {
		DB Connect = new DB(); 
		if(Connect.findUser(userFind) ) {
			System.out.println("UserName Alrready used");
		}else {System.out.println("User Name Available");}
	}

}

