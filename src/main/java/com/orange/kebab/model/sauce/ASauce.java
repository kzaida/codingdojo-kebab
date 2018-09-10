package com.orange.kebab.model.sauce;

import com.orange.kebab.model.AKebabIngredient;

public abstract class ASauce extends AKebabIngredient {

    @Override
    public boolean isMeat() {
        return false;
    }

    @Override
    public boolean isFish() {
        return false;
    }

    @Override
    public boolean isVegetable() {
        return true;
    }
}

