package com.zoo;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ZooOperations zooOperations = new ZooOperationsImpl();

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            Animal animal = generateAnimal();
            boolean hasAcceptedByTheZoo = zooOperations.addAnimal(animal);
            if (!hasAcceptedByTheZoo) {
                zooOperations.extendZoo();
                zooOperations.addAnimal(animal);
            }
        }

        printAnimals();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        int daysCount = 20;

        for (int i = 0; i < daysCount; i++) {
            System.out.printf("Day %s of %s. ", i+1, daysCount);

            boolean animalsWereFed = animalsWereFed();
            if (animalsWereFed) {
                zooOperations.feedAll();
            }

            System.out.printf("Animals were%s fed\n", animalsWereFed ? "" : " NOT");

            zooOperations.nextDay();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        printAnimals();

    }


    private static boolean animalsWereFed() {

        int result = new Random().nextInt(10);//0..9    90% - 0..8,  10% - 0..1, 100% - 0..9
        if (result <= 8) { //result <= 8 - 90%
            return true;            //great !
        }

        return false;       //terrible, CALL GREEN PEACE!!!!!
    }

    private static void printAnimals() {
        System.out.println("Sort by:");
        System.out.println("1. Name");
        System.out.println("2. Health");
        System.out.println("3. Age");
        System.out.println("4. Age reversed");

        Integer menuOption = new Scanner(System.in).nextInt();

        SortType sortType = SortType.getById(menuOption);

        for (Animal animal : zooOperations.getAnimals(sortType)) {
            System.out.println(animal.toString());
        }

    }

    private static Animal generateAnimal() {
        String [] names = {"Calvin", "Foxy", "Guinness", "Jasmine", "Ozzie"};
        int randomNameIndex = new Random().nextInt(names.length);
        String name = names[randomNameIndex];


        int randomAnimalTypeIndex = new Random().nextInt(AnimalType.values().length);
        AnimalType animalType = AnimalType.values()[randomAnimalTypeIndex];

        Integer randomAge = new Random().nextInt(11);


        return new Animal(name, animalType, randomAge);
    }
}