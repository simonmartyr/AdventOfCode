package com.smartyr.adventofcode.y2025.day3;

public class Day3 {
    public long partOne() {
        return processBanksPartOne(BatteryBank.BATTERY_BANKS);
    }

    public long partTwo() {
        return processBanksPartTwo(BatteryBank.BATTERY_BANKS);
    }

    public long processBanksPartOne(String[] input) {
        long result = 0;
        for (String bank : input) {
            result += BatteryBank.calculateLargestJoltageFromTwoBatteries(bank);
        }
        return result;
    }

    public long processBanksPartTwo(String[] input) {
        long result = 0;
        for (String bank : input) {
            result += BatteryBank.calculateLargestJoltageFromTwelveBatteries(bank);
        }
        return result;
    }
}