package prob3;

import java.util.Arrays;
import java.util.List;

public class CountWords
{

    /**
     * This function is case insensitive
     * @param words
     * @param c
     * @param d
     * @param len
     * @return
     */
    public static long countWords(List<String> words, char c, char d, int len) 
    {
        return words.stream()
            .filter(string->string.length()==len)
            .filter(string->string.toLowerCase().contains(String.valueOf(c).toLowerCase()))
            .filter(string->!string.toLowerCase().contains(String.valueOf(d).toLowerCase()))       
            .count();
              
    }
    
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("Wide", "Voice", "white", "noise", "Give", "It", "all", "to", "me", "hear", "you", "Calling");
        System.out.println("Number of 5 letter words containing 'e' and not containing 'o' is: " 
            + countWords(words,'e', 'o', 5));
    }

}
