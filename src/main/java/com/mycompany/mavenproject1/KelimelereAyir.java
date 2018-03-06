/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import com.google.common.base.Joiner;
import org.antlr.v4.runtime.Token;
import zemberek.tokenization.TurkishTokenizer;

import java.util.Iterator;

public class KelimelereAyir {

    static TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;

    public static void tokenIterator() {
        System.out.println("Low level tokenization iterator using Ant-lr Lexer.");
        String input = "İstanbul'a, merhaba!";
        System.out.println("Input = " + input);
        Iterator<Token> tokenIterator = tokenizer.getTokenIterator(input);
        while (tokenIterator.hasNext()) {
            Token token = tokenIterator.next();
            System.out.println("Token= " + token.getText() + " Type=" + token.getType());
        }
    }

    public static void simpleTokenization() {
        System.out.println("Simple tokenization returns a list of token strings.");
        TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
        String input = "İstanbul'a, merhaba!";
        System.out.println("Input = " + input);
        System.out.println("Tokenization list = " +
                Joiner.on("|").join(tokenizer.tokenizeToStrings("İstanbul'a, merhaba!")));
    }

    public static void main(String[] args) {
        tokenIterator();
        System.out.println();
        simpleTokenization();
    }
}