package com.patterns.factory.method;

import com.patterns.factory.method.creator.ShipCreator;
import com.patterns.factory.method.creator.TruckCreator;

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
                "1 - Truck\n" +
                "2 - Ship");
        int choice = Integer.parseInt(reader.readLine());

        if (choice == 1) {
            new TruckCreator().deliverByTransport();
            return;
        }

        if (choice == 2) {
            new ShipCreator().createTransport();
            return;
        }

        throw new UnsupportedOperationException("Error! Unknown operating system.");
    }
}
