package com.smartyr.adventofcode.y2025.day3;

public class Day3 {
    public long partOne() {
        return processBanks(BatteryBank.BATTERY_BANKS);
    }

    public long processBanks(String[] input) {
        long result = 0;
        for (String bank : input) {
            result += BatteryBank.calculateLargestJoltage(bank);
        }
        return result;
    }
}