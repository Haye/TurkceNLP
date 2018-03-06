/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import zemberek.core.logging.Log;
import zemberek.morphology.ambiguity.Z3MarkovModelDisambiguator;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.morphology.analysis.tr.TurkishSentenceAnalyzer;

import java.io.IOException;

public class OgelereAyir {

    TurkishSentenceAnalyzer analyzer;

    public OgelereAyir(TurkishSentenceAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    private void test(String s) {
        System.out.println("Sentence  = " + s);
        SentenceAnalysis analysis = analyzer.analyze(s);
        analyzer.disambiguate(analysis);


        for (SentenceAnalysis.Entry entry : analysis) {
            WordAnalysis wa = entry.parses.get(0);
            Log.info("%s -> %s : %s ",
                    entry.input,
                    wa.dictionaryItem.primaryPos,
                    wa.dictionaryItem.secondaryPos);
        }
    }

    public static void main(String[] args) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        Z3MarkovModelDisambiguator disambiguator = new Z3MarkovModelDisambiguator();
        TurkishSentenceAnalyzer sentenceAnalyzer = new TurkishSentenceAnalyzer(
                morphology,
                disambiguator
        );
        new OgelereAyir(sentenceAnalyzer)
                .test("Keşke yarın hava güzel olsa.");

    }
}

