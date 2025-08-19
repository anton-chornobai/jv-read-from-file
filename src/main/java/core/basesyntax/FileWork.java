package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        String lower = word.toLowerCase(Locale.ROOT);
                        if (lower.charAt(0) == 'w') {
                            lines.add(lower);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        Collections.sort(lines);
        return lines.toArray(new String[0]);
    }
}
