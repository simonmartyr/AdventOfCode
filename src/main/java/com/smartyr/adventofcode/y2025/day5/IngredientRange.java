package com.smartyr.adventofcode.y2025.day5;

public record IngredientRange(long start, long end) implements Comparable<IngredientRange> {
    public IngredientRange(String range) {
        this(range.split("-"));
    }

    public IngredientRange(String[] range) {
        this(Long.parseLong(range[0]), Long.parseLong(range[1]));
    }

    public boolean fallsInto(IngredientRange other) {
        return start <= other.start && end >= other.start;
    }

    public boolean withinRange(long other) {
        return start <= other && end >= other;
    }

    public IngredientRange combine(IngredientRange other) {
        return new IngredientRange(Math.min(start, other.start), Math.max(end, other.end));
    }

    @Override
    public int compareTo(IngredientRange o) {
        return Long.compare(start, o.start);
    }

    public long difference() {
        return end - start + 1;
    }
}