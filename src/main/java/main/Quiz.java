package main;

import java.util.*;

/**
 * Created by Piotr on 01.03.2017.
 */
public class Quiz {
    private Map<String, String> dictionary = new HashMap<>();
    private List<String> listOfKey = new ArrayList<>();
    public Quiz() {
        this.dictionary = Main.dataBase.getDictionary();
    }

    public String takeRandomWordFromList() {
        Random rn = new Random();
        int randomNumber = rn.nextInt((listOfKey.size()-0)+1)+0;
        return listOfKey.get(randomNumber);
    }

    public void getAllElementsFromMapIntoList() {
        for (Map.Entry<String, String> entry : dictionary.entrySet())
        {
            listOfKey.add(entry.getKey());
        }
    }

    public void printAllList() {
        for(int i = 0; i < listOfKey.size(); i++) {
            System.out.println(listOfKey.get(i));
        }
    }

}
