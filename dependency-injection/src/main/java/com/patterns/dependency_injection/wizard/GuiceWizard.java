package com.patterns.dependency_injection.wizard;

import com.patterns.dependency_injection.tobacco.Tobacco;

public class GuiceWizard implements Wizard {

    private Tobacco tobacco;

    public GuiceWizard(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}
