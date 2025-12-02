package com.smartyr.adventofcode.y2025.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public interface Input {
    List<String> PUZZLE_INPUT = List.of(
            "9100-11052",
            "895949-1034027",
            "4408053-4520964",
            "530773-628469",
            "4677-6133",
            "2204535-2244247",
            "55-75",
            "77-96",
            "6855-8537",
            "55102372-55256189",
            "282-399",
            "228723-269241",
            "5874512-6044824",
            "288158-371813",
            "719-924",
            "1-13",
            "496-645",
            "8989806846-8989985017",
            "39376-48796",
            "1581-1964",
            "699387-735189",
            "85832568-85919290",
            "6758902779-6759025318",
            "198-254",
            "1357490-1400527",
            "93895907-94024162",
            "21-34",
            "81399-109054",
            "110780-153182",
            "1452135-1601808",
            "422024-470134",
            "374195-402045",
            "58702-79922",
            "1002-1437",
            "742477-817193",
            "879818128-879948512",
            "407-480",
            "168586-222531",
            "116-152",
            "35-54"
    );

    static LongStream parseRange(final String input) {
        final String[] split = input.split("-");
        final long min = Long.parseLong(split[0]);
        final long max = Long.parseLong(split[1]);
        return LongStream.rangeClosed(min, max);
    }

    static boolean isInvalid(final long input) {
        if (input <= 10) {
            return false;
        }
        final String hold = String.valueOf(input);
        if (hold.length() % 2 != 0) {
            return false;
        }
        final int pivotPoint = hold.length() / 2;
        return hold.substring(0, pivotPoint).equals(hold.substring(pivotPoint));
    }


    static boolean isInValidRepeating(final long input) {
        if (input <= 10) {
            return false;
        }
        final String hold = String.valueOf(input);
        final int length = hold.length();
        Map<Integer, String> factors = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            Map<Integer, String> store = new HashMap<>(factors);
            for (Map.Entry<Integer, String> factor : factors.entrySet()) {
                if (i % factor.getKey() != 0) {
                    continue;
                }
                var ex = hold.substring(i - factor.getKey(), i);
                if (!ex.equals(factor.getValue())) {
                    store.remove(factor.getKey());
                }
            }
            factors = store;
            if (i == length || length % i != 0) {
                continue;
            }
            factors.put(i, hold.substring(0, i));
        }
        return !factors.isEmpty();
    }
}