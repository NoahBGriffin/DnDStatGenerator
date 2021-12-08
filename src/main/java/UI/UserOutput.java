package UI;

import Stats.Character;

import java.util.List;

public class UserOutput {

    public static void printWelcome() {
        System.out.println("Welcome to D&D stat roller!");
        System.out.println("This program will roll 4d6 a total of 6 times, throwing out the lowest d6 and adding the rest");
        System.out.println("Once all d6 have been rolled, you can allocate them into different stats accordingly!");
        System.out.println("+--------------------------------------------------------------------------------------+\n");
        System.out.println("Hit enter to begin rolling\n");
        UserInput.getGenericInput();
    }

    public static void printUnallocatedStatList(List<Integer> stats) {
        System.out.println("\n--------------------------------");
        System.out.print("        UNALLOCATED STATS\n ");
        for (int i = stats.size(); i < Character.NUM_STATS; i++) {
            System.out.print("   ");
        }
        printStatNumsAndGetSum(stats);
        System.out.println("--------------------------------");
    }

    public static void printResults(List<Integer> stats) {
        System.out.println("Here are the numbers rolled: ");

        int sum = printStatNumsAndGetSum(stats);

        if (sum < 55) System.out.println("Not the best...");
        else if (sum > 75) System.out.println("Really good!");

        UserInput.getGenericInput();
    }

    public static int printStatNumsAndGetSum(List<Integer> stats) {
        int sum = 0;
        for (int i = 0; i < stats.size(); i++) {
            sum += stats.get(i);
            System.out.print("[" + stats.get(i) + "]");
            if (i != stats.size() - 1) System.out.print(" ");
        }
        System.out.println();
        return sum;
    }

    public static void printCharacterStats(Character character) {
        System.out.println("---------------------------");
        System.out.println("      CHARACTER STATS");
        System.out.println("---------------------------");
        System.out.println(character);
    }

}
