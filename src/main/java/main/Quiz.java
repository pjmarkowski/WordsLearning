package main;

import java.util.*;

/**
 * Created by Piotr on 01.03.2017.
 */
public class Quiz {
    private Map<String, String> dictionary = new HashMap<>();
    private List<String> listOfKey = new ArrayList<>();
    private String currentRandomWord;
    private int possiblePoints = 0;
    private int userPoints = 0;
    String correctAnswer;
    public Quiz() {
        this.dictionary = Main.dataBase.getDictionary();
    }

    public String takeRandomWordFromList() {
        Random rn = new Random();
        int randomNumber = rn.nextInt((listOfKey.size()-1)+1)+0;
        currentRandomWord = listOfKey.get(randomNumber);
        correctAnswer = dictionary.get(currentRandomWord);
        return currentRandomWord;
    }

    public void getAllElementsFromMapIntoList() {
        for (Map.Entry<String, String> entry : dictionary.entrySet())
        {
            listOfKey.add(entry.getKey());
        }
    }

    public int checkIfCorrectTranslation(String translation) {

        if(correctAnswer.equals(translation)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void printAllList() {
        for(int i = 0; i < listOfKey.size(); i++) {
            System.out.println(listOfKey.get(i));
        }
    }

    public int getPossiblePoints() {
        return possiblePoints;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void increasePossiblePoints() {
        possiblePoints ++;
    }

    public void increaseUserPoints() {
        userPoints ++;
    }
}
