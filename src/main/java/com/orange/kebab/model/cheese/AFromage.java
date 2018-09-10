package com.orange.kebab.model.cheese;

import com.orange.kebab.model.AKebabIngredient;

public abstract class AFromage extends AKebabIngredient {

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
