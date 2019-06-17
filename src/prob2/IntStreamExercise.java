package prob2;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntStreamExercise
{
    private static Stream<Integer> makeIntegerStream() {
        return Stream
            .generate(()->new Double(Math.random() * 200).intValue())
            .limit(20);
    }

    public static void main(String[] args)
    {
        Stream<Integer> myIntStream = makeIntegerStream();
        List<Integer> randInts = myIntStream.collect(Collectors.toList());
        System.out.println("numbers: " + randInts);         // show the numbers
        //now get max and min values
        IntSummaryStatistics summary = randInts.stream()
            .collect(Collectors.summarizingInt(x->x));
        System.out.println(String.format("min value is: %s, max value is: %s", summary.getMin(), summary.getMax()));
    }

}
