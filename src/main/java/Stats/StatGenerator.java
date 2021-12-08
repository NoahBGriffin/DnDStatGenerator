package Stats;

import Dice.D6;

import java.util.ArrayList;
import java.util.List;

public class StatGenerator {

    public static List<Integer> rollStats() {
        System.out.print("Rolling dice");
        wait(500);
        System.out.print(".");
        wait(500);
        System.out.print(".");
        wait(500);
        System.out.println(".\n");
        wait(500);

        List<Integer> results = new ArrayList<>();

        //get all stats
        for (int i = 0; i < Character.NUM_STATS; i++) {
            results.add(rollOneStat());
        }
        return results;
    }

    private static Integer rollOneStat() {
        D6 dice = new D6();
        List<Integer> result = new ArrayList<>();
        //roll dice
        for (int i = 0; i < 4; i++) {
            result.add(dice.roll());
        }

        //sum together all values, find lowest and subtract that one
        int min = dice.getSides();
        Integer stat = 0;
        for (Integer num : result) {
            if (min > num) min = num;
            stat += num;
        }
        stat -= min;

        return stat;
    }

    private static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
