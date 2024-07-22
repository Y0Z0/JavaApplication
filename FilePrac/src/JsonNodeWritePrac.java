import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonNodeWritePrac {
    public static void main (String[] args) {
        Person people = new Person("Bob", 25, "bob@example.com");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode personNode = mapper.valueToTree(people);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(
            new File("person.json"), personNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
