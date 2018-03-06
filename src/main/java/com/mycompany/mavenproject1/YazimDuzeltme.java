/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;

public class YazimDuzeltme {

    public static void main(String[] args) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);

        System.out.println("Check if written correctly.");
        String[] words = {"Ankara'ya", "Ankar'aya", "yapbileceksen", "yapabileceğinizden"};
        for (String word : words) {
            System.out.println(word + " -> " + spellChecker.check(word));
        }
        System.out.println();
        System.out.println("Give suggestions.");
        String[] toSuggest = {"Kraamanda", "okumuştk", "yapbileceksen", "oukyamıyorum"};
        for (String s : toSuggest) {
            System.out.println(s + " -> " + spellChecker.suggestForWord(s));
        }
    }
}