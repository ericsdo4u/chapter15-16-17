package jsonserialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static jsonserialisation.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {

        @Test
        public void testSerialize() {
            Person person = new Person();
            person.setName("Precious");
            //LocalDate dateOfBirth = LocalDate.parse("2024-03-03");
            person.setDateOfBirth(LocalDate.now());
            person.setGender(Gender.FEMALE);
            person.setPhoneNumber("09034746724");
            String json = JsonSerializer.serialize(person);
            String expected = "{\"name\":\"Precious\",\"phoneNumber\":\"09034746724\",\"gender\":\"FEMALE\",\"dob\":[2024,5,6]}";
            assertEquals(expected, json);

    }
    @Test
    public void  testDeserialize() throws JsonProcessingException {
        Person person = new Person("John", LocalDate.now(), "08164556912", MALE);
        String  json = JsonSerializer.serialize(person);
        Person personFromJson = JsonSerializer.deserialize(json);

        assertNotNull(personFromJson);
        assertEquals(person.getDateOfBirth(), personFromJson.getDateOfBirth());
        assertEquals(MALE, personFromJson.getGender());
        assertEquals("John", personFromJson.getName());
        assertEquals("08164556912", personFromJson.getPhoneNumber());

    }

}