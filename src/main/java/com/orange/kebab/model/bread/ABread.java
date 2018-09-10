package com.orange.kebab.model.bread;

import com.orange.kebab.model.AKebabIngredient;

public abstract class ABread extends AKebabIngredient {

    public boolean isMeat() {
        return false;
    }

    public boolean isFish() {
        return false;
    }

    public boolean isVegetable() {
        return true;
    }
}

