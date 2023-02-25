package org.example.streams;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsMethods {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("toListMethod: " + list);

        Set<Integer> set = Stream.of(1, 2, 4, 5, 6, 6, 1)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("toSetMethod: " + set);

        Map<String, Integer> map = Stream.of("apple", "mango", "banana")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("ToMapMethod: " + map);

        String str = String.join(", ", "apple", "mango", "pawpaw");
        System.out.println("Joined string: " + str);

        int sum = Stream.of(1, 299, 3, 56, 100).mapToInt(Integer::intValue).sum();
        System.out.println("Summed up value: " + sum);

        Map<Boolean, List<Integer>> hashmap = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("PartitioningBy: " + hashmap);

        Map<Integer, List<String>> hashmap2 = Stream.of("apple", "banana", "cherry")
                .collect(Collectors.groupingBy(String::length));
        System.out.println("GroupingBY: " + hashmap2);

        // DropWhile
        // It drops elements while the condition is true.
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .dropWhile(x -> x <= 5)
                .forEach(x -> System.out.print(x + " "));
    }
}
