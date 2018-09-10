package com.orange.kebab.model.fish;

import com.orange.kebab.model.AKebabIngredient;

public abstract class AFish extends AKebabIngredient {

    public boolean isMeat() {
        return true;
    }

    public boolean isFish() {
        return true;
    }

    public boolean isVegetable() {
        return false;
    }
}
