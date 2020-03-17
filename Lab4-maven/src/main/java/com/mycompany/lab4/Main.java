/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        Collections.sort(residentList,
                Comparator.comparing(Resident::getName));

        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        Set<Hospital> hospitalList = new TreeSet<>();
        hospitalList.addAll(Arrays.asList(h));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));
        System.out.println("Residents preferences");
        resPrefMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        Map<Hospital, List<Resident>> hosPrefMap = new TreeMap<>();
        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        System.out.println("Hospitals preferences");
        hosPrefMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        List<Hospital> target = Arrays.asList(h[0], h[2]);

        System.out.println("Residents who find acceptable H0 and H2");
        residentList.stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .forEach(System.out::println);

        System.out.println("Hospitals that have R0 as their top preference");
        hospitalList.stream()
                .filter(hos -> hosPrefMap.get(hos).get(0) == r[0])
                .forEach(System.out::println);

        Problem.solve();
    }
}
