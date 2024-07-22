import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonNodeReadPrac {
    public static void main(String[] args) {
        String filePath = "person.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filePath));
            String name = rootNode.get("name").asText();
            int age = rootNode.get("age").asInt();
            String email = rootNode.get("email").asText();
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
