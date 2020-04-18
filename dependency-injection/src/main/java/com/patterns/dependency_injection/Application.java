package com.patterns.dependency_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.patterns.dependency_injection.tobacco.SecondBreakfastTobacco;
import com.patterns.dependency_injection.wizard.*;

public class Application {

    public static void main(String[] args) {
        Wizard simpleWizard = new SimpleWizard();
        simpleWizard.smoke();

        Wizard advancedWizard = new AdvancedWizard(new SecondBreakfastTobacco());
        advancedWizard.smoke();

        AdvancedSorceressWizard advancedSorceressWizard = new AdvancedSorceressWizard();
        advancedSorceressWizard.setTobacco(new SecondBreakfastTobacco());
        advancedSorceressWizard.smoke();

        Injector injector = Guice.createInjector(new TobaccoModule());
        Wizard guiceWizard = injector.getInstance(GuiceWizard.class);
        guiceWizard.smoke();
    }
}
