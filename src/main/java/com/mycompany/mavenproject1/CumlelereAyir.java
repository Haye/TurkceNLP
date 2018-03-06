/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import zemberek.tokenization.TurkishSentenceExtractor;

import java.util.List;

public class CumlelereAyir {

    public static void simpleSentenceBoundaryDetector() {
        String input = "Prof. Dr. Veli Davul açıklama yaptı. Kimse %6.5 lik enflasyon oranını beğenmemiş!" +
                " Oysa maçta ikinci olmuştuk... Değil mi?";
        System.out.println("Paragraph = " + input);
        TurkishSentenceExtractor extractor = TurkishSentenceExtractor.DEFAULT;
        List<String> sentences = extractor.fromParagraph(input);
        System.out.println("Sentences:");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    public static void main(String[] args) {
        simpleSentenceBoundaryDetector();
    }
}