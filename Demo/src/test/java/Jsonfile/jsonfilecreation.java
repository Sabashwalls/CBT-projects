package Jsonfile;

import java.io.FileWriter;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class jsonfilecreation {

	public static void main(String[] args) throws IOException {
		
		JsonObject jasonobj = new JsonObject();
		jasonobj.put("name", "walls");
		jasonobj.put("gender", "male");
		
		JsonArray json = new JsonArray();
		json.add("number1");
		json.add("number2");
		
		jasonobj.put("numbers", json);

		FileWriter fil = new FileWriter("example.json");
		
		fil.write(jasonobj.toJson());
		fil.close();
	}

}
