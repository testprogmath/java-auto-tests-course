package ru.stqa.pft.sandbox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String[] args) {
        String[] langs={"Java", "C#", "C++", "Python", "Groovy"};

        List<String> languages = new ArrayList<String>();
        languages.add("Java"); //размер списка стал равен единице
        List<String> lang1 = Arrays.asList("Java", "C#", "C++", "Python", "Groovy");
        for (String l: lang1) {
            System.out.println("Я хочу выучить "+l);
        }
    }
}
