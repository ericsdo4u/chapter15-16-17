package jsonserialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonSerializer {

    public static String serialize(Person person){

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(person);
            return json;
        }catch (JsonProcessingException exception){
            System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
    public  static Person deserialize(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(json, Person.class);
        return mapper.readValue(json, Person.class);
    }
}
