package classworkonfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static classworkonfiles.Type.CREDIT;
import static classworkonfiles.Type.DEBIT;
import static jsonserialisation.JsonSerializer.deserialize;


public class CalculateTransaction {



    public static int calculateTotalTransaction(String jsonFilePath) throws IOException {
        Path path = Paths.get(jsonFilePath);
        String fileContent = Files.readString(path);
        Transaction[] transactions = deserializes(fileContent);
        int total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;

    }

    public static Transaction[] deserializes(String jason) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jason, Transaction[].class);
    }

    public static int toCheckNumberOfDigit(String input) {
        int count = 0;
        for (int index = 0; index < input.length(); index++) {
            if (Character.isDigit(input.charAt(index))) {
                index++;
            }
        }
        return count;
    }
    public static int toCountNumberOfSentences(String input) {
        int count = 0;
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '.') {
                count++;
            }
        }
        return count;
    }
    public static int toCountNumbersOfZeros(String fileContent) {
        int count = 0;
        for (int index = 0; index < fileContent.length(); index++) {
            if (fileContent.charAt(index) == '0') {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> dailyTransaction(LocalDate date) throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\files-and-stream\\src\\classworkonfiles\\transaction.json");
        String fileContent = Files.readString(path);
        Transaction[] transactions = deserializes(fileContent);
        return Arrays.stream(transactions).filter((transaction) -> transaction.getDate().isEqual(date)).toList();
    }
    public static List<Transaction> dateTransaction(LocalDate startDate, LocalDate endDate) throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\files-and-stream\\src\\classworkonfiles\\transaction.json");
        String fileContent = Files.readString(path);
        Transaction[] transactions = deserializes(fileContent);
        return Arrays.stream(transactions)
                .filter(transaction -> transaction.getDate().compareTo(startDate) >= 0
                        && transaction.getDate().compareTo(endDate) <= 0)
                .toList();}

    public static double averageTransaction(LocalDate startDate, LocalDate endDate) throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\files-and-stream\\src\\classworkonfiles\\transaction.json");
        String fileContent = Files.readString(path);
        Transaction[] transactions = deserializes(fileContent);
        return Arrays.stream(transactions)
                     .filter(transaction -> !transaction.getDate().isBefore(startDate)
                        && !transaction.getDate().isAfter(endDate))
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0.0);
    }
    public static AccountSummary getAccountSummary(String accountNumber, LocalDate startDate, LocalDate endDate) throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\files-and-stream\\src\\classworkonfiles\\transaction.json");
        String fileContent = Files.readString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction[] transactions = objectMapper.readValue(fileContent, Transaction[].class);
        double balance = Arrays.stream(transactions)
                .filter(transaction -> !transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate))
                .mapToDouble(Transaction::getAmount)
                .sum();

        return new AccountSummary(accountNumber, balance);
    }


    public static int totalTransactionAmount(String fileLocation) throws IOException {
        Path path = Paths.get(fileLocation);
        String filesContent = Files.readString(path);
        Transaction[] transactions = deserializes(filesContent);
        int total = 0;
        for (Transaction eachTransaction : transactions) {
            if(eachTransaction.getType() == CREDIT){
                total += eachTransaction.getAmount();
            }
            if(eachTransaction.getType() == DEBIT){
                total -= eachTransaction.getAmount();
            }
        }
        return total;
    }


//    public static Transaction[] deserialize(String json) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(json, Transaction[].class);
//        } catch (JsonProcessingException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
    public static int getDigits(String fileLocation) throws IOException {
        Path path = Paths.get(fileLocation);
        String filesContent = Files.readString(path);
        int digitsCount = 0;
        for (int i = 0; i < filesContent.length(); i++) {
            if (Character.isDigit(filesContent.charAt(i))) {
                digitsCount++;
            }

        }
        return digitsCount;
    }
    public static String countSentences(String text){
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                counter++;
            }
        }
        return String.valueOf(counter);
    }
}
