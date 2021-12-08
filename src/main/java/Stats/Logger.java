package Stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Logger {

    public static void saveCharacterToFile(Character completeCharacter) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        String fileName = completeCharacter.getName() + "_stats_" + date + ".txt";
        File file = new File(fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("Character: " + completeCharacter.getName());
            pw.println("---------------------------");
            pw.println("         Stats");
            pw.println("---------------------------");
            pw.println(completeCharacter.toString());

            System.out.println("File successfully saved to " + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
