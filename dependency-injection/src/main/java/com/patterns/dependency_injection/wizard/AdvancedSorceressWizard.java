package com.patterns.dependency_injection.wizard;

import com.patterns.dependency_injection.tobacco.Tobacco;

public class AdvancedSorceressWizard implements Wizard {

    private Tobacco tobacco;

    public void setTobacco(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}