package prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfStrings
{

    public static void main(String[] args)
    {
        String joinedStrings = Stream.of("Bill", "Thomas", "Mary")
            .collect(Collectors.joining(","));
        System.out.println(joinedStrings);
    }

}
