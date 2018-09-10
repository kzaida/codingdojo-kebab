package com.orange.kebab;

import com.orange.kebab.model.AKebabIngredient;
import com.orange.kebab.model.bread.ABread;
import com.orange.kebab.model.bread.Galette;
import com.orange.kebab.model.bread.PainKebab;
import com.orange.kebab.model.cheese.AFromage;
import com.orange.kebab.model.cheese.Cheese;
import com.orange.kebab.model.cheese.DoubleCheese;
import com.orange.kebab.model.fish.AFish;
import com.orange.kebab.model.fish.Anchoix;
import com.orange.kebab.model.fish.Crevette;
import com.orange.kebab.model.meat.AMeat;
import com.orange.kebab.model.meat.Escalope;
import com.orange.kebab.model.meat.ViandeHachee;
import com.orange.kebab.model.sauce.*;
import com.orange.kebab.model.vegetable.Cornichon;
import com.orange.kebab.model.vegetable.Onion;
import com.orange.kebab.model.vegetable.Salade;
import com.orange.kebab.model.vegetable.Tomate;
import com.orange.kebab.service.Kebab;

import java.util.*;

public class Main {

    // liste de pains
    private static final Map<String, ABread> breadMap = getBreadMap();
    // liste des legumes
    private static final List<AKebabIngredient> vegetables = getVegetables();
    //liste de viande
    private static final Map<String, AMeat> meatMap = getMeatMap();
    //liste de poisson
    private static final Map<String, AFish> fishMap = getFishMap();
    //liste de fromage
    private static final Map<String, AFromage> cheeseMap = getCheeseMap();
    //liste des sauces
    private static final Map<String, ASauce> saucesMap = getSauceMap();

    private static final Kebab kebab = new Kebab();

    public static void main(String[] args) {

        // declare a variable that will store the user input
        String userInput;

        //declate a scanner object to read the command line input by user
        Scanner sn = new Scanner(System.in);

        //loop the utility in loop until the user makes the choice to exit
        while (true) {
            //Print the options for the user to choose from
            System.out.println("*****Constituer votre Kebab à la carte*****");

            //choix du pain
            chooseBread(sn);

            //choix du fromage
            chooseCheese(sn);

            //choix des sauces
            chooseSauce(sn);

            //choix du type de sandwich
            onionFree(sn);

            System.out.println("*****Bravo vous avez constitué votre Kebab à la carte*****");

            kebab.printIngredients();
            return;
        }
    }

    private static void chooseBread(Scanner sn) {

        System.out.println("*Veuillez choisir votre pain:");
        breadMap.keySet().stream().forEach(System.out::println);
        // Prompt the use to make a choice
        System.out.println("Enter your choice:");

        //Capture the user input in scanner object and store it in a pre decalred variable
        String userInput = sn.next();
        ABread choosenIngr = breadMap.get(userInput);

        if (choosenIngr == null) {
            //inform user in case of invalid choice.
            System.out.println("Invalid choice.[" + userInput + "] Read the options carefully...");
            chooseBread(sn);
        } else {
            System.out.println("Vous avez choisi le pain [" + choosenIngr.getName() + "]");
            kebab.addIngredient(choosenIngr);
        }
        return;
    }

    private static void chooseCheese(Scanner sn) {

        System.out.println("*Veuillez choisir votre fromage:");
        cheeseMap.keySet().stream().forEach(System.out::println);
        // Prompt the use to make a choice
        System.out.println("Enter your choice:");

        //Capture the user input in scanner object and store it in a pre decalred variable
        String userInput = sn.next();
        AFromage choosenIngr = cheeseMap.get(userInput);

        if (choosenIngr == null) {
            //inform user in case of invalid choice.
            System.out.println("Invalid choice.[" + userInput + "] Read the options carefully...");
            chooseCheese(sn);
        } else {
            System.out.println("Vous avez choisi le fromage [" + choosenIngr.getName() + "]");
            kebab.addIngredient(choosenIngr);
        }
        return;
    }

    private static void chooseSauce(Scanner sn) {

        System.out.println("*Veuillez choisir votre sauce:");
        saucesMap.keySet().stream().forEach(System.out::println);
        // Prompt the use to make a choice
        System.out.println("Enter your choice:");

        //Capture the user input in scanner object and store it in a pre decalred variable
        String userInput = sn.next();
        ASauce choosenIngr = saucesMap.get(userInput);

        if (choosenIngr == null) {
            //inform user in case of invalid choice.
            System.out.println("Invalid choice.[" + userInput + "] Read the options carefully...");
            chooseSauce(sn);
        } else {
            System.out.println("Vous avez choisi la sauce [" + choosenIngr.getName() + "]");
            kebab.addIngredient(choosenIngr);
        }
        return;
    }


    private static void onionFree(Scanner sn) {

        System.out.println("*Avec ou sans onion?");
        // Prompt the use to make a choice
        System.out.println("Enter your choice: o/n");

        //Capture the user input in scanner object and store it in a pre decalred variable
        String userInput = sn.next();

        if (!"o".equals(userInput) && !"n".equals(userInput)) {
            //inform user in case of invalid choice.
            System.out.println("Invalid choice.[" + userInput + "] Read the options carefully...");
            onionFree(sn);
        } else {

            if ("o".equals(userInput)) {

                System.out.println("Vous avez choisi un kebab avec des onions");
                kebab.addIngredients(vegetables);

            } else {

                kebab.addIngredients(vegetables);
                kebab.removeIngredient(Onion.NAME);
                System.out.println("Vous avez choisi un kebab sans onion");
            }

        }
        return;
    }

    private static Map<String, ASauce> getSauceMap() {
        Map<String, ASauce> saucesMap = new HashMap<>();
        saucesMap.put(Algerienne.NAME, new Algerienne());
        saucesMap.put(Biggy.NAME, new Biggy());
        saucesMap.put(Mayonnaise.NAME, new Mayonnaise());
        saucesMap.put(Samourai.NAME, new Samourai());
        return saucesMap;
    }

    private static Map<String, AFromage> getCheeseMap() {
        Map<String, AFromage> cheeseMap = new HashMap();
        cheeseMap.put(DoubleCheese.NAME, new DoubleCheese());
        cheeseMap.put(Cheese.NAME, new Cheese());
        return cheeseMap;
    }

    private static Map<String, AFish> getFishMap() {
        Map<String, AFish> fishMap = new HashMap();
        fishMap.put(Crevette.NAME, new Crevette());
        fishMap.put(Anchoix.NAME, new Anchoix());
        return fishMap;
    }

    private static Map<String, AMeat> getMeatMap() {
        Map<String, AMeat> meatMap = new HashMap();
        meatMap.put(ViandeHachee.NAME, new ViandeHachee());
        meatMap.put(Escalope.NAME, new Escalope());
        return meatMap;
    }

    private static List<AKebabIngredient> getVegetables() {
        return Arrays.asList(new Tomate(), new Salade(), new Cornichon(), new Onion());
    }

    private static Map<String, ABread> getBreadMap() {
        Map<String, ABread> breadMap = new HashMap();
        breadMap.put(Galette.NAME, new Galette());
        breadMap.put(PainKebab.NAME, new PainKebab());
        return breadMap;
    }
}
