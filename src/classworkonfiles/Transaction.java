package classworkonfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {



    private String name;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    private String id;
    private int  amount;
    private Type type;
    private String accountNumber;

    public Transaction(){}

    public Transaction(String amount, String accountNumber) {
        this.amount = Integer.parseInt(amount);
        this.accountNumber = accountNumber;
    }


    public String toString(){
        return "transaction->{name: " + name + ", id: " + id + ", amount: " + amount + ", type: " + type + ", transactionDate: " + date + "}";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }










//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//
//    private int id;
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private String name;
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private BigDecimal amount;
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private Type type;
//     //@JsonProperty("date")// it changes the name of the instance variable dateOfBirth to dob because it was annotated under it.
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    private LocalDateTime date;
//
//
//    // private List<Transactions> transactions = new ArrayList<>();
//
//    public Transaction(int id, String name, int amount, Type type, LocalDateTime date) {
//        this.id = id;
//        this.name = name;
//        this.amount = BigDecimal.valueOf(amount);
//        this.type = type;
//        this.date = date;
//    }
//    public Transaction(){
//
//    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = BigDecimal.valueOf(amount);
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Transactions{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", amount='" + amount + '\'' +
//                ", type=" + type +
//                ", date=" + date +
//                '}';
//    }

}
