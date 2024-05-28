package classworkonfiles;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTransactionTest {




    @Test
    public void testTransactionTakesDateAndReturnAllTransactionsForThatDay() throws IOException {
        List<Transaction> expected = CalculateTransaction.dailyTransaction(LocalDate.of(2024, 5, 1));
        assertEquals(4, expected.size());
    }

    @Test
    public void testTransactionTakesAStartDateEndDateAndReturnsAllTransactionsForThatDay() throws IOException {
        List<Transaction> expected = CalculateTransaction.dateTransaction(LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 7));
        assertEquals(2, expected.size());

    }
    @Test
    public void testToGetTheAverageTransactionAmountForSpecifiedPeriod() throws IOException {
        double expected = CalculateTransaction.averageTransaction(LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 7));
        assertEquals(5000.0, expected, 0.0);

    }

    @Test
    public void testToGetAccountNumberAndAccountSummery() throws IOException {
        AccountSummary accountSummery = CalculateTransaction.getAccountSummary("12345678", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 7));
        assertEquals("12345678", accountSummery.getAccountNumber());

        double expectedBalance = 10000.0;
        assertEquals(expectedBalance, accountSummery.getBalance(), 0.001);
        String expectedSummary = "Account Number: 12345678\nBalance: " + expectedBalance;
        assertEquals(expectedSummary, accountSummery.getAccountSummary());
    }



    @Test
    public void calculateTotalTransactions() throws IOException {
        String input = "C:\\Users\\DELL\\IdeaProjects\\OOP\\src\\jason\\Transaction.json";
        int transactionTotal = 11000;
        assertEquals(transactionTotal, CalculateTransaction.calculateTotalTransaction(input));

    }

    @Test
    public void testToCheckNumberOfDigit() throws IOException {
        String input = "C:\\Users\\DELL\\IdeaProjects\\OOP\\src\\sample2.txt";
        String fileContent = new String(Files.readAllBytes(Paths.get(input)));
        int numberOfDigit = 8;
        assertEquals(numberOfDigit, CalculateTransaction.toCheckNumberOfDigit(fileContent));
    }

    @Test
    public void testToCountNumberOfSentences() throws IOException {
        String filePath = "C:\\Users\\DELL\\IdeaProjects\\OOP\\src\\sample1.txt";
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        int numberOfSentences = 5;
        assertEquals(numberOfSentences, CalculateTransaction.toCountNumberOfSentences(fileContent));
    }
    @Test
    public void testToCountNumbersOfZeros() throws IOException {
        String filePath = "C:\\Users\\DELL\\IdeaProjects\\OOP\\src\\sample3.txt";
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        int numberOfZeros = 10;
        assertEquals(numberOfZeros, CalculateTransaction.toCountNumbersOfZeros(fileContent));
    }





//    @Test
//    public void ComputeTotalAmountFromJasonFiles() throws IOException {
//        String fileLocation = "C:\\Users\\DELL\\Documents\\GitHub\\javaIOExamples\\src\\JsonTask\\Transactions.json";
//        int expected = 9000;
//        assertEquals(expected, totalTransactionAmount(fileLocation));
//    }

//    @Test
//    public void testNumberOfDigitsInATestFile() throws IOException {
//        String fileLocation = "C:\\Users\\DELL\\Documents\\GitHub\\javaIOExamples\\src\\JsonTask\\NewTextFile.txt";
//        int expected = 3;
//        assertEquals(expected, getDigits(fileLocation));
//    }

//    @Test
//    public void test_deserialize() throws JsonProcessingException {
//        Transaction transactions = new Transaction(1, "Donald",  1000, DEBIT, LocalDateTime.now());
//        String json = CalculateTransaction.serialize(transactions);
//        Transaction[] result = CalculateTransaction.deserialize(json);
//
//        assertNotNull(result);
//        assertEquals("Donald", transactions.getName(), json);
//    }
//
//    @Test
//    public void calculate() throws IOException {
//        Transaction transactions = new Transaction();
//        transactions.setId(2);
//        transactions.setName("Donald");
//        transactions.setAmount(2000);
//        transactions.setType(DEBIT);
//        transactions.setDate(LocalDateTime.now());
//        //String json = CalculateTransaction.serialize(transactions);
//        // Transactions[] result = CalculateTransaction.deserialize(json);
//        int numberOfTransactions = CalculateTransaction.calculate("C:\\Users\\DELL\\IdeaProjects\\files-and-stream\\src\\classworkonfiles\\transaction.json");
//        assertEquals(1, numberOfTransactions);
//    }
//    @Test
//    public void countNumberOfSentencesInATextFile() {
//        String text = "This is a text file.";
//        String result = "1";
//        assertEquals(result, CalculateTransaction.countSentences(text));
//    }

}