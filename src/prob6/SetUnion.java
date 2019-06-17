package prob6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetUnion
{
    public static Set<String> union(List<Set<String>> sets) {
        return sets.stream()
            .reduce(new LinkedHashSet<String>(), (set1, set2)-> { 
                set1.addAll(set2);
                return set1;
            });
    }

    public static void main(String[] args)
    {
        Set<String> sets = new HashSet<String>();
        sets.add("A");
        sets.add("B");
        sets.add("C");
        sets.add("D");
        sets.add("E");
        sets.add("F");
        Set<String> sets2 = new HashSet<String>();
        sets2.add("A");
        sets2.add("B");
        sets2.add("1");
        sets2.add("2");
        sets2.add("3");
        System.out.println("set1: " + sets);
        System.out.println("set2: " + sets2);
        System.out.println("union: " + union(Arrays.asList(sets, sets2)));
    }

}
