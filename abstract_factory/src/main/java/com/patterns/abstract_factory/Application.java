package com.patterns.abstract_factory;

import com.patterns.abstract_factory.factory.FurnitureFactory;
import com.patterns.abstract_factory.factory.ModernFurniture;
import com.patterns.abstract_factory.factory.VictorianFurniture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nChoose transport for delivering:.\n" +
                "1 - Victorian\n" +
                "2 - Modern");
        int choice = Integer.parseInt(reader.readLine());

        FurnitureFactory factory = choice == 1 ? new VictorianFurniture() : new ModernFurniture();
        factory.createChair().getChairInfo();
        factory.createSofa().getSofaInfo();
        factory.createTable().getTableInfo();
    }
}
