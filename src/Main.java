import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//example of how to use the class to do post 
		Gson json = new Gson();

		User user = new User("gabrieaaal",22);
		String jsonParams = json.toJson(user);
		
		
		Gson userJson = new Gson();
		User user2 = userJson.fromJson(HttpClient.doPostMethod("http://localhost:8765/users/add",jsonParams),User.class);
		
		System.out.println(user2.getNome());
		System.out.println(user2.getIdade());
	}

}
