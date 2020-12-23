package final_keyword;

  //1. BMW ne Car ko extend karne ke bad MBW mai woh incomplete function bhi aagya(getCompany).
  //2. BMW ke pas do options hai, ki khudko abstract declare krle ya fir BMW us function ko implement karle
public class BMW extends Car {
	
	//3.getCompany(), jo function incomplete tha usko implement karre
	@Override
	public String getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//4. BMW mai woh incomplete function implement karne ke bad BMW ko abstract karne ki jarurat nhi hai.

}
