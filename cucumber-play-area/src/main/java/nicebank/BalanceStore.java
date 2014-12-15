package nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BalanceStore {
    private static String BALANCE_FILE_PATH = "./balance"; 

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();

        setBalance(new MonetaryAmount(0,0));
    }

    public static MonetaryAmount getBalance() { 
        File balanceFile = new File(BALANCE_FILE_PATH); 
        Scanner scanner = null;
        try {
            scanner = new Scanner(balanceFile); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Probably need regex here
        MonetaryAmount balance = new MonetaryAmount(scanner.nextLine()); 
        scanner.close();
        
        return balance;
    }
    
    public static void setBalance(MonetaryAmount newBalance){ 

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(newBalance.toString()); 
        writer.close();
    }
}