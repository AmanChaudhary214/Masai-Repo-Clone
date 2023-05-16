package Salesforce;

public class MsSQL implements Demo {

	private String url;
	private String username;
	private String password;
	
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public void getConnection() {
		System.out.println("Hi I am MsSQL and my credentials are:-  url:" + url + " username:" + username + " password:" + password);
	}
	
	@Override
	public void calledMethod() {
		// TODO Auto-generated method stub
		getConnection();
	}
	
	
}
