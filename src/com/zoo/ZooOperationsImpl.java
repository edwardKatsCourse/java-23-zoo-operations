package com.zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ZooOperationsImpl implements ZooOperations {

    private static Integer ZOO_SPACE = 10;

    private List<Animal> animals = new ArrayList<>();

    @Override
    public boolean addAnimal(Animal animal) {

//        if (animals.size() >= ZOO_SPACE) {
//        throw new OutOfSpaceException

        if (animals.size() >= ZOO_SPACE) {
            return false;
        }


        animal.setAnimalId(animals.size() + 1);
        animal.setHealth(100);
        animal.setFed(true);

        boolean add = animals.add(animal);
        if (add) {
            System.out.printf("Animal: %s, Type: %s was successfully added to the zoo\n",
                    animal.getName(),
                    animal.getType().name());
        }

        return add;

//        String errorMessage = String.format("Not enough space for the new animal [%s]. " +
//                "Zoo space: [%s]",
//                animal.getName(),
//                animals.size());
//
//        throw new RuntimeException(errorMessage);
    }

    @Override
    public void extendZoo() {
        System.out.printf("Zoo was extended from [%s] to [%s]\n",
                ZOO_SPACE,
                ++ZOO_SPACE);
    }

    @Override
    public void shortenUpZoo() {
        ZOO_SPACE--;
    }

    @Override
    public List<Animal> getAnimals(SortType sortType) {
//        Comparator<Animal> nameComparator = new Comparator<Animal>() {
//            @Override
//            public int compare(Animal o1, Animal o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };


        Collections.sort(animals, sortType.getComparator());
        return animals;
    }

    @Override
    public void feedAll() {
        for (Animal animal : animals) {
            animal.setFed(true);
        }
    }

    @Override
    public void nextDay() {
        for (Animal animal : animals) {
            decreaseHealthIfHungry(animal);
            setHungry(animal);
        }
    }

    private void setHungry(Animal animal) {
        animal.setFed(false);
    }

    private void decreaseHealthIfHungry(Animal animal) {
        if (!animal.isFed()) {

            Integer currentHealth = animal.getHealth();
            animal.setHealth(currentHealth - animal.getType().getSicknessFactor());
        }
    }

    /*
    private void setAllHungry() {
        for (Animal animal : animals) {
            animal.setFed(false);
        }
    }

    private void decreaseHealthIfHungry() {
        for (Animal animal : animals) {
            if (!animal.isFed()) {

                Integer currentHealth = animal.getHealth();
                animal.setHealth(currentHealth - animal.getType().getSicknessFactor());
            }
        }
    }

    */
}
