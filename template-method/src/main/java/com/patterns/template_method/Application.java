package com.patterns.template_method;

import com.patterns.template_method.game.GameUI;
import com.patterns.template_method.game.MonstersAI;
import com.patterns.template_method.game.OrcsAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nChoose strategy of game:.\n" +
                "1 - OrcsAI\n" +
                "2 - MonstersAI");
        int choice = Integer.parseInt(reader.readLine());

        GameUI game = choice == 1 ? new OrcsAI() : new MonstersAI();
        game.turn();
    }
}
