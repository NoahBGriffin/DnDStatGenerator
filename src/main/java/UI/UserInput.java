package UI;

import Stats.Character;

import java.sql.SQLOutput;
import java.util.*;

public class UserInput {

    private static Scanner input = new Scanner(System.in);

    public static String getGenericInput() {
        System.out.println("\nPress enter to continue...");
        String userInput = input.nextLine();
        return userInput;
    }

    public static String getStatSortOption() {
        boolean validInput = false;
        String choice = "";

        while (!validInput) {
            System.out.print("Begin with (L)owest or (H)ighest stat?: ");
            choice = input.nextLine().toLowerCase().trim();

            if (choice.equals("h")) {
                choice = "highest";
                validInput = true;
            } else if (choice.equals("l")) {
                choice = "lowest";
                validInput = true;
            } else {
                System.out.println("Error: input cannot be read");
            }
        }
        return choice;
    }

    public static String getStatChoice(Character stats, Integer stat) {

        String statChoice = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Where you would like to put [" + stat + "]");
            System.out.println("If a stat that is already filled is selected, you will be able to re-allocate the swapped out value");

            System.out.print("\nSTR");
            if (!stats.isStatEmpty("STR")) System.out.print(" (Currently: " + stats.get("STR") + ")");
            System.out.print("\nDEX");
            if (!stats.isStatEmpty("DEX")) System.out.print(" (Currently: " + stats.get("DEX") + ")");
            System.out.print("\nCON");
            if (!stats.isStatEmpty("CON")) System.out.print(" (Currently: " + stats.get("CON") + ")");
            System.out.print("\nINT");
            if (!stats.isStatEmpty("INT")) System.out.print(" (Currently: " + stats.get("INT") + ")");
            System.out.print("\nWIS");
            if (!stats.isStatEmpty("WIS")) System.out.print(" (Currently: " + stats.get("WIS") + ")");
            System.out.print("\nCHA");
            if (!stats.isStatEmpty("CHA")) System.out.print(" (Currently: " + stats.get("CHA") + ")");

            System.out.print("\nEnter choice: ");
            statChoice = input.nextLine().trim().toUpperCase();
            statChoice = statChoice.substring(0, 3);
            if (stats.isValidStatType(statChoice)) validInput = true;
            if (!validInput) System.out.println("Error: unrecognized stat type");
        }

        return statChoice;
    }

    public static String getName() {
        boolean validInput = false;
        String name = "unnamed";

        boolean giveAName = getYesNoChoice("Would you like to name your character (y/n)?: ");

        if (giveAName) {
            System.out.print("Please enter a name: ");
            name = input.nextLine();
            validInput = true;
        }

        return name;
    }

    public static boolean getYesNoChoice(String choicePrompt) {
        boolean validInput = false;
        boolean saveChoice = false;
        while (!validInput) {
            System.out.println(choicePrompt);
            String response = input.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                saveChoice = true;
                validInput = true;
            } else if (response.equals("n")) {
                validInput = true;
            }
        }
        return saveChoice;
    }

}
