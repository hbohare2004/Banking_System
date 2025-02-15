import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private static final String FILE_PATH = "accounts.txt";

    // saving the file
    public static void saveAccount(Account account) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(account.getAccountNumber() + "," + account.getAccountHolderName() + "," + account.getBalance() + "\n");
            System.out.println("Account saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    // load account details from file
    public static Account loadAccount(String accountNumber) {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(accountNumber)) {
                    return new Account(parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading account: " + e.getMessage());
        }
        return null;
    }
}