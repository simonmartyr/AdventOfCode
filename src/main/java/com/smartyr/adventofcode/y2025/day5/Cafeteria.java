package com.smartyr.adventofcode.y2025.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Cafeteria extends Input {
    static List<IngredientRange> freshRanges() {
        return freshRanges(RANGES);
    }

    static List<IngredientRange> freshRanges(String[] ranges) {
        List<IngredientRange> sortedRanges = Arrays.stream(ranges)
                .map(IngredientRange::new)
                .sorted()
                .toList();
        List<IngredientRange> reduced = new ArrayList<>();
        IngredientRange combinedRange = null;
        for (IngredientRange range : sortedRanges) {
            if (combinedRange == null) {
                combinedRange = range;
                continue;
            }
            if (combinedRange.fallsInto(range)) {
                combinedRange = combinedRange.combine(range);
            } else {
                reduced.add(combinedRange);
                combinedRange = range;
            }
        }
        reduced.add(combinedRange);
        return reduced;
    }
}