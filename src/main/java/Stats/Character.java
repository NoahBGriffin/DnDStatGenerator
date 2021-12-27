package Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Character {

    private Map<String, Integer> stats;
    private String name;

    public static final int NUM_STATS = 6;

    public Character() {
        stats = new HashMap<>();
        stats.put("STR", 0);
        stats.put("DEX", 0);
        stats.put("CON", 0);
        stats.put("INT", 0);
        stats.put("WIS", 0);
        stats.put("CHA", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getStatMap() {
        //make copy so original can't be modified
        Map<String, Integer> copyMap = new HashMap<>();

        for(Map.Entry<String, Integer> current : stats.entrySet()) {
            copyMap.put(current.getKey(), current.getValue());
        }

        return copyMap;
    }

    public List<String> getStatTypes() {
        return new ArrayList<>(stats.keySet());
    }

    @Override
    public String toString() {
        // STR = [18], Modifier: [+3]
        String statString = "";
        for (Map.Entry<String, Integer> stat : stats.entrySet()) {
            String modifier = getModifier(stat.getValue());

            statString += String.format("%1$-13s", stat.getKey() + " = [" + stat.getValue() + "], " ) +
                    "Modifier: " + modifier + "\n";

        }
        return statString;
    }

    private String getModifier(Integer rawNum) {
        String modifier = "[";
        rawNum = (rawNum - 10) / 2;

        modifier += String.format("%+d", rawNum);
        modifier += "]";

        return modifier;
    }

    public void resetStats() {
        for (Map.Entry<String, Integer> stat : stats.entrySet()) {
            stats.put(stat.getKey(), 0);
        }
    }

    public boolean isStatEmpty(String key) {
        return stats.get(key) == 0;
    }

    public int get(String key) {
        return stats.get(key);
    }

    public boolean isValidStatType(String checkMe) {
        return stats.containsKey(checkMe);
    }

    public void changeStat(String stat, int value) {
        stats.put(stat, value);
    }


}
