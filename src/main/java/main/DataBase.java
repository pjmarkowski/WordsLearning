package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataBase {
    private Map<String, String> dictionary = new HashMap<>();

    public void readDictionayFromFile() throws FileNotFoundException {
        File file = new File("dictionary.txt");
        Scanner in = new Scanner(file);

        while(in.hasNext()) {
            String lineInFile = in.nextLine();
            String[]partOfLine = lineInFile.split("--");
            dictionary.put(partOfLine[0], partOfLine[1]);
        }
    }

    public void saveDictionaryToFile() throws FileNotFoundException {
        PrintWriter file = new PrintWriter("dictionary.txt");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            file.println(entry.getKey()+"--"+entry.getValue());
        }
        file.close();
    }

    public void addWordIntoDictionary (String word, String translation) {
        dictionary.put(word,translation);
    }

    public void removeWordFromDictionaryByValue (String word) {
        String foundedKey="";
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getValue().equals(word)) {
                foundedKey = (entry.getKey());
            }
        }
        dictionary.remove(foundedKey);
    }

    public void printAllDictionary() {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
