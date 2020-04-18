package com.patterns.dependency_injection.tobacco;

import com.patterns.dependency_injection.wizard.Wizard;

public abstract class Tobacco {

    public void smoke(Wizard wizard) {
        System.out.println(String.format("Base tobacco: {%s} wizard: {%s}",
                this.getClass().getSimpleName(),
                wizard.getClass().getSimpleName()));
    }
}
