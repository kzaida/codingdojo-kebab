package com.orange.kebab.model.meat;

import com.orange.kebab.model.Ingredient;

public abstract class AMeat implements Ingredient {

    public boolean isMeat() {
        return true;
    }

    public boolean isFish() {
        return false;
    }

    public boolean isVegetable() {
        return false;
    }
}
