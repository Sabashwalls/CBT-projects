package Jsonfile;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONReader {

    public static void main(String[] args) {
        // Path to your JSON file
        String filePath = "example.json";

        try {
            // Create a FileReader object to read the JSON file
            FileReader reader = new FileReader(filePath);

            // Parse the JSON file
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);

            // Close the reader
            reader.close();

            // Convert the JSON element to a JSON object
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Access data from the JSON object
            String name = jsonObject.get("name").getAsString();
            int age = jsonObject.get("age").getAsInt();

            // Print the data
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
