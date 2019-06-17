package prob5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section
{
    public static Stream<String> streamSection(Stream<String> stream, int m, int n)
    {
        // Implement the code
        return stream.skip(m).limit(n-m+1);       //skip m since index starts from 0, n-m+1 since index n is inclusive
    }


    public static void main(String[] args)
    {
        // Make three calls for the streamSection() method with different inputs // use nextStream() method to supply the Stream input as a first argument in streamSection() method
        
        System.out.println("print from index 0 to index 4 (5 elements)");
        streamSection(nextStream(), 0, 4)
        .forEach(System.out::println);
        
        System.out.println("print from index 2 to index 5 (4 elements)");
        streamSection(nextStream(), 2, 5)
        .forEach(System.out::println);
        
        System.out.println("print from index 7 to index 7 (1 element)");
        streamSection(nextStream(), 7, 7)
        .forEach(System.out::println);
    }


    //support method for the main method -- for testing
    private static Stream<String> nextStream()
    {
        return Arrays
            .asList(
                "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh",
                "iii")
            .stream();
    }
}
