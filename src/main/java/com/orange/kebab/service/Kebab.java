package com.orange.kebab.service;

import com.orange.kebab.model.AKebabIngredient;
import com.orange.kebab.model.Ingredient;
import com.orange.kebab.model.bread.ABread;
import com.orange.kebab.model.cheese.AFromage;
import com.orange.kebab.model.fish.AFish;
import com.orange.kebab.model.meat.AMeat;
import com.orange.kebab.model.sauce.ASauce;
import com.orange.kebab.model.vegetable.AVegetable;

import java.util.ArrayList;
import java.util.List;


public class Kebab {

    List<AKebabIngredient> ingredients = new ArrayList<>();

    public Kebab() {
    }

    public void addIngredients(List<AKebabIngredient> kebabIngredients) {
        ingredients.addAll(kebabIngredients);
    }

    public void addIngredient(AKebabIngredient kebabIngredient) {
        ingredients.add(kebabIngredient);
    }

    public boolean isVegetarian() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isMeat()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPesceterian() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isFish()) {
                return true;
            }
        }
        return false;
    }

    public void printIngredients() {

        System.out.println("-----------------------------------------");
        System.out.println("Ingredients du kebab:");
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof ABread) {
                System.out.println("    Pain:" + ingredient.getName());
                break;
            }
        }

        printSauce();
        printMeat();
        printFish();
        printFromage();
        printVegetables();

        System.out.println("-----------------------------------------");
    }

    private void printSauce() {

        System.out.print("    Sauces du kebab:");
        List<ASauce> sauces = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof ASauce) {
                sauces.add((ASauce) ingredient);
            }
        }
        if (!sauces.isEmpty()) {
            System.out.print("[");
            for (Ingredient sauce : sauces) {
                System.out.print(sauce.getName() + " ");
            }
            System.out.println("] ");
        } else {
            System.out.println("sans sauce]");
        }
    }

    private void printMeat() {

        List<AMeat> meats = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof AMeat) {
                meats.add((AMeat) ingredient);
            }
        }
        if (!meats.isEmpty()) {
            System.out.println("    Viande du kebab:[");
            for (Ingredient meat : meats) {
                System.out.print(meat.getName() + " ");
            }
            System.out.println("]");
        }
    }

    private void printFish() {

        List<AFish> fishList = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof AFish) {
                fishList.add((AFish) ingredient);
            }
        }
        if (!fishList.isEmpty()) {
            System.out.println("    Poisson du kebab:[");
            for (Ingredient fish : fishList) {
                System.out.print(fish.getName() + " ");
            }
            System.out.println("]");
        }
    }

    private void printFromage() {
        List<AFromage> fromages = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof AFromage) {
                fromages.add((AFromage) ingredient);
            }
        }
        if (!fromages.isEmpty()) {

            System.out.print("    Fromage du kebab:[");
            for (Ingredient fromage : fromages) {
                System.out.print(fromage.getName() + " ");
            }
            System.out.println("]");
        }
    }

    private void printVegetables() {
        List<AVegetable> vegetables = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {

            if (ingredient instanceof AVegetable) {
                vegetables.add((AVegetable) ingredient);
            }
        }
        if (!vegetables.isEmpty()) {
            System.out.print("    Legumes du kebab:[");
            for (Ingredient vegetable : vegetables) {
                System.out.print(vegetable.getName() + " ");
            }
            System.out.println("]");
        }
    }

    public void removeIngredient(String name) {
        for (Ingredient ingredient : new ArrayList<Ingredient>(ingredients)) {
            if (ingredient.getName().equals(name)) {
                ingredients.remove(ingredient);
                System.out.println("On supprime l'ingrédient:[" + name + "] le client n'en veut pas!!!!!");
            }
        }
    }
}

