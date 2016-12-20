import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//example of how to use the class to do post 
		Gson json = new Gson();

		User user = new User("gabriel",21);
		String jsonParams = json.toJson(user);
		
		
		System.out.println(HttpClient.doPostMethod("http://localhost:8765/users/add",jsonParams));
		System.out.println("//////////////////////////////////////////////////////////////////////");
		System.out.println(HttpClient.doGetMethod("http://terceiroseti.compjunior.com.br/api/palestrante"));
		
		
	}

}
