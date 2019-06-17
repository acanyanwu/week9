package prob8;

import java.util.Arrays;
import java.util.List;
import prob8.util.TransactionRepo;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2010, 500), 
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high)");
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		TransactionRepo.getGreaterThanYear.apply(transactions, 2011)
		.forEach(System.out::println);
		System.out.println();
        
		System.out.println("Query 2: What are all the unique cities where the traders work?");
        // Query 2: What are all the unique cities where the traders work?
        TransactionRepo.getUniqueCities.apply(transactions)
        .forEach(System.out::println);
        System.out.println();

        System.out.println("Query 3: Find all traders from Cambridge and sort them by name.");
        // Query 3: Find all traders from Cambridge and sort them by name.
        TransactionRepo.getTradersInSpecifiedCity.apply(transactions, "Cambridge")
        .forEach(System.out::println);
        System.out.println();
   
        
        System.out.println("Query 4: Return a string of all traders names sorted alphabetically.");
        // Query 4: Return a string of all traders names sorted alphabetically.
        TransactionRepo.getSortedUniqueTraderNames.apply(transactions)
        .forEach(System.out::println);
        System.out.println();
        
        System.out.println("Query 5: Are there any trader based in Milan?");
        // Query 5: Are there any trader based in Milan?
        TransactionRepo.getTradersInSpecifiedCity.apply(transactions, "Milan")
        .forEach(System.out::println);
        System.out.println();
   
        System.out.println("Query 6: Update all transactions so that the traders from Milan are set to Cambridge.");
     // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        TransactionRepo.getUpdatedTransactionCity.apply(transactions, "Milan", "Cambridge")
        .forEach(System.out::println);
        System.out.println();
   
        System.out.println("Query 7: What's the highest value in all the transactions?");
        // Query 7: What's the highest value in all the transactions?
        System.out.println(TransactionRepo.getHighestTransactionValue.apply(transactions));
    }
}
