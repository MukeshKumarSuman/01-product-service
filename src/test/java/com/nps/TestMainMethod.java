package com.nps;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TestMainMethod {
    @Test
    public static void main1(String[] args) {
        int[] a = {1, 3, 5, 8, 4, 12, 15, 11, 21, 18};
        List<Integer> intList = Arrays.asList(1, 3, 5, 8, 4, 12, 15, 11, 21, 18);
        List<String> animalList = Arrays.asList("Camel", "Horse", "Donkey");
        List<Emp> empList = Arrays.asList(
                new Emp("Mukesh", 10, "HR"),
                new Emp("Suman", 15, "AC"),
                new Emp("Rahul", 10, "HR"),
                new Emp("Raj", 20, "LAN"));

        HashSet<Integer> coll = intList.stream().collect(Collectors.toCollection(HashSet::new));

        int[] ints = Arrays.stream(a).filter(i -> String.valueOf(i).startsWith("1")).sorted().distinct().toArray();
        System.out.println(ints);


    }
}

@Data
@AllArgsConstructor
class Emp {
    private String name;
    private int age;
    private String dprt;
}
