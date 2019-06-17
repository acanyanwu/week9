package prob8.util;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import prob7b.TriFunction;
import prob8.Trader;
import prob8.Transaction;

public class TransactionRepo
{
    public static BiFunction<List<Transaction>, Integer, List<Transaction>> getGreaterThanYear = (transactionList, year) 
        -> transactionList.stream()
        .filter(transaction->transaction.getYear() >= year)
        .sorted(Comparator.comparing(Transaction::getValue))
        .collect(Collectors.toList());
    
    public static Function<List<Transaction>, Set<String>> getUniqueCities = transactionList 
        -> transactionList.stream()
        .map(transaction->transaction.getTrader().getCity())
        .collect(Collectors.toSet());       // Deliberately did not use Stream.distinct() since a set contains unique elements by its definition
        
    public static BiFunction<List<Transaction>, String, Set<Trader>> getTradersInSpecifiedCity = (transactionList, cityName)
        -> transactionList.stream()
        .filter(transaction->transaction.getTrader().getCity().equalsIgnoreCase(cityName))
        .map(Transaction::getTrader)
        .collect(Collectors.toSet());                       // Deliberately did not use Stream.distinct() since a set contains unique elements by its definition    
        
   public static Function<List<Transaction>, List<Trader>> getSortedUniqueTraderNames = transactionList
       -> transactionList.stream()
       .map(Transaction::getTrader)
       .distinct()
       .sorted(Comparator.comparing(Trader::getName))
       .collect(Collectors.toList());
       
   public static TriFunction<List<Transaction>, String, String, List<Transaction>> getUpdatedTransactionCity = (transactionList, oldCity, newCity)
       -> { 
           transactionList.stream()
           .filter(transaction->transaction.getTrader().getCity().equals(oldCity))
           .forEach(transaction->transaction.getTrader().setCity(newCity));
           return transactionList;
       };
       
   public static Function<List<Transaction>, Integer>  getHighestTransactionValue = transactionList
       -> transactionList.stream()
       .collect(Collectors.summarizingInt(Transaction::getValue))
       .getMax();
    
}
