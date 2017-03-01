package main;

import java.util.*;

/**
 * Created by Piotr on 01.03.2017.
 */
public class Quiz {
    private Map<String, String> dictionary = new HashMap<>();
    private List<String> listOfKey = new ArrayList<>();
    private String currentRandomWord;
    public Quiz() {
        this.dictionary = Main.dataBase.getDictionary();
    }

    public String takeRandomWordFromList() {
        Random rn = new Random();
        int randomNumber = rn.nextInt((listOfKey.size()-1)+1)+0;
        currentRandomWord = listOfKey.get(randomNumber);
        return currentRandomWord;
    }

    public void getAllElementsFromMapIntoList() {
        for (Map.Entry<String, String> entry : dictionary.entrySet())
        {
            listOfKey.add(entry.getKey());
        }
    }

    public String checkIfCorrectTranslation(String translation) {
        String correctAnswer = dictionary.get(currentRandomWord);
        if(correctAnswer.equals(translation)) {
            return "Poprawna odpowiedź!";
        }
        else {
            return "Niepoprawna odpowiedz, powinno byc: " + correctAnswer;
        }
    }

    public void printAllList() {
        for(int i = 0; i < listOfKey.size(); i++) {
            System.out.println(listOfKey.get(i));
        }
    }

}
