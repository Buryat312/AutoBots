package com.autobots.java.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E")
        );
        System.out.println(nestedList);

        List<String> nonNestedList = new ArrayList<>();
        for (List<String> list : nestedList){
            nonNestedList.addAll(list);
        }
        System.out.println(nonNestedList);

        System.out.println("---------------");
        List<String> nonNestedList2 = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(nonNestedList2);

        System.out.println("---------------");

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andre");



    }
}
