import Stats.Character;
import Stats.Logger;
import Stats.StatGenerator;
import UI.UserInput;
import UI.UserOutput;

import java.util.*;

public class CharacterStatGeneratorCLI {


    public static void main(String[] args) {

        CharacterStatGeneratorCLI application = new CharacterStatGeneratorCLI();
        application.run();

    }

    public void run() {
        UserOutput.printWelcome();

        List<Integer> stats = StatGenerator.rollStats();
        UserOutput.printResults(stats);

        //we have sorted list, now allow user to put stats into Character
        Character character = statAllocator(stats);
        System.out.println();
        UserOutput.printCharacterStats(character);

        //get name
        String name = UserInput.getName();
        character.setName(name);

        boolean saveToFile = UserInput.getYesNoChoice("Would you like to save this character to a .txt file (y/n)?: ");
        if (saveToFile) {
            Logger.saveCharacterToFile(character);

        }

        boolean goAgain = UserInput.getYesNoChoice("Would you like to make another character (y/n)?: ");
        if (goAgain) run();
    }

    private Character statAllocator(List<Integer> stats) {
        boolean sortDescending = false;
        String sortChoice = UserInput.getStatSortOption();
        if (sortChoice.equals("highest")) sortDescending = true;

        Character finalStats = new Character();
        //TODO: prompt user for whether they are happy w/ choice, if not reset the whole dang thing
        //while(true) {
            finalStats.resetStats();
            while(stats.size() > 0) {

                Collections.sort(stats);
                if (sortDescending) Collections.reverse(stats);

                UserOutput.printUnallocatedStatList(stats);

                int statToPut = stats.get(0);
                stats.remove(0);

                String statChoice = UserInput.getStatChoice(finalStats, statToPut);

                //if they are replacing a stat, get the other one back to put somewhere else
                if (!finalStats.isStatEmpty(statChoice)) stats.add(finalStats.get(statChoice));

                finalStats.changeStat(statChoice, statToPut);

            }

        //}
        return finalStats;
    }

}

