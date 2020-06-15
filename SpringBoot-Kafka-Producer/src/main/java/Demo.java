
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo {

	// 542740400
	// 387128200
	
	public static void main(String[] args) throws JsonProcessingException {
		
		long st = System.nanoTime();
		
		Data data = new Data();
		data.setFirstName("pratya");
		data.setLastName("yeekhaday");
		ObjectMapper mapper = new ObjectMapper();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 200; i++) {
		
			String json  = mapper.writeValueAsString(data);
			list.add(json);
		}
		
		System.out.println(System.nanoTime() - st);
		
	}
	
	static class Data {
		
		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}

}
