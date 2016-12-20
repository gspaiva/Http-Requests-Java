import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gson json = new Gson();
		json.toJson(1);
		System.out.println(HttpClient.doPostMethod("http://localhost:8765/users/add",json));
		
		
		
	}

}
