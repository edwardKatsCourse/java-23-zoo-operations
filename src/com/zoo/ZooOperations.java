package com.zoo;

import java.util.List;

/**
 * Operations
 * 1. add animal
 * 2. feed all animals
 * 3. get animals
 * 4. clean up cages??
 * 5. get overall zoo status (how many animals, sick animals, males, females and so on)
 * 6. extend zoo (add new cage, remove cage)
 *
 * Comparators:
 * name comparator
 * sickness level comparator (100% - healthy, 0% - dead)
 * age comparator
 *
 * classes:
 * ZooOperations
 * ZooOperationsImpl
 * Animal
 * AnimalType
 * NameComparator
 * SicknessLevelComparator
 * AgeComparator
 *
 */
/*
add animal
        * 2. feed all animals
        * 3. get animals
        * 4. clean up cages??
        * 5. get overall zoo status (how many animals, sick animals, males, females and so on)
        * 6. extend zoo (add new cage, remove cage)
        */
public interface ZooOperations {
    //Adding animal is possible, if there is enough space in the zoo
    boolean addAnimal(Animal animal);

//    void addAllAnimals(List<Animal> animals);

    //extend space in the zoo
    void extendZoo();
    void shortenUpZoo();

    List<Animal> getAnimals(SortType sortType);
    void feedAll();
    void nextDay();

    /**
     *     private void setAllStarving
     *     private void decrease health by 10% if an animal is hungry
     *
     *
     *
     *     void feedAll
     *     void nextDay
     *          decrease health
     *          setAllHungry
     *
     */


}
