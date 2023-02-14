import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {
        // lets the user pick a text file (JFileChooser) which uses the filter to display the short words from the file.
        JFileChooser chooser = new JFileChooser();
        String fileName = "";
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No file selected");
            System.exit(0);
        }
        List<String> words = extractWordsFromFile(fileName);
        Object[] wordsArray = words.toArray();
        List<String> shortWords = Utils.collectAll(wordsArray, new ShortWordFilter());
        System.out.println("Found " + shortWords.size() + " short words:");
        for (int i = 0; i < shortWords.size(); i++) {
            System.out.println((i + 1) + ". " + shortWords.get(i));
        }
    }

    private static List<String> extractWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}

