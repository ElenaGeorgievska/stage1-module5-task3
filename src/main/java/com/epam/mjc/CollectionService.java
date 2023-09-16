package com.epam.mjc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionService {


    public List<Integer> filterEvenNumbers(List<Integer> list) {
        List<Integer> result;
        return result = list
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream()
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compare);
        //list.stream().max(Comparator.comparing(Integer::valueOf));
    }


    public Optional<Integer> findMin(List<List<Integer>> list) {
        return list.stream()
                .flatMap(List::stream)
                .min(Integer::compare);
    }

    public Integer sum(List<Integer> list) {
        return list.stream()
                .reduce(0, (a, b) -> a + b);

        //list.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        CollectionService cs = new CollectionService();

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 677, 0);
        List<Integer> list2 = Arrays.asList(11, 12, 23, 34, 25, 77);
        List<Integer> list3 = Arrays.asList(12, 21, 30, 14, 25, 67);
        List<String> list4 = List.of("Hello", "mjc", "school");

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        cs.filterEvenNumbers(list1);
        System.out.println(cs.filterEvenNumbers(list1));

        cs.toUpperCaseCollection(list4);
        System.out.println(cs.toUpperCaseCollection(list4));

        cs.findMax(list2);
        System.out.println(cs.findMax(list2));

        cs.findMin(list);
        System.out.println(cs.findMin(list));

        cs.sum(list3);
        System.out.println(cs.sum(list3));
    }
}
