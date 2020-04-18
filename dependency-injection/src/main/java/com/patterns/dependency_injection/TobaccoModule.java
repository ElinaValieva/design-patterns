package com.patterns.dependency_injection;

import com.google.inject.AbstractModule;
import com.patterns.dependency_injection.tobacco.RivendellTobacco;
import com.patterns.dependency_injection.tobacco.Tobacco;

public class TobaccoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Tobacco.class).to(RivendellTobacco.class);
    }
}
