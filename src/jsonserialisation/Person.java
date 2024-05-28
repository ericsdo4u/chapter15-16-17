package jsonserialisation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonProperty("dob")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirth = LocalDate.now();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String phoneNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Gender gender;


    public Person(){

    }

    public Person(String name, LocalDate date, String number, Gender gender) {
        this.name = name;
        this.dateOfBirth = date;
        this.phoneNumber = number;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}


