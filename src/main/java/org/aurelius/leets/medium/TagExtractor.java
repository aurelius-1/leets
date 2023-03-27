package org.aurelius.leets.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TagExtractor {

    static final Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        Stream.generate(in::nextLine).limit(testCases)
                .map(pattern::matcher)
                .flatMap(m -> {
                    List<String> l = new ArrayList<>();
                    while (m.find()) l.add(m.group(2));

                    return l.isEmpty() ? Stream.of("None") : l.stream();
                }).forEach(System.out::println);


    }
}
