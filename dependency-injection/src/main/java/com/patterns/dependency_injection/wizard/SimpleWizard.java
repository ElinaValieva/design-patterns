package com.patterns.dependency_injection.wizard;

import com.patterns.dependency_injection.tobacco.OldTobyTobacco;
import com.patterns.dependency_injection.tobacco.Tobacco;

public class SimpleWizard implements Wizard {

    private Tobacco tobacco = new OldTobyTobacco();

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}
