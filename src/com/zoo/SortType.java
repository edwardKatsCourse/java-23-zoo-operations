package com.zoo;

import java.util.Comparator;

public enum SortType {

    //                              animal -> { animal.getName() .... return}
    //                              Animal::getName()
                //() -> SAME AS new Comparator() { compare(Animal a, Animal b) {} }
    NAME_SORT(1, (a, b) -> a.getName().compareTo(b.getName())),
    HEALTH_SORT(2, Comparator.comparing(Animal::getHealth).reversed()),
    AGE_SORT(3, Comparator.comparing(Animal::getAge)),
    REVERSE_AGE_SORT(4, Comparator.comparing(Animal::getAge).reversed())

    ;

    private Integer sortId;
    private Comparator<Animal> comparator;


    SortType(Integer sortId, Comparator<Animal> comparator) {
        this.comparator = comparator;
        this.sortId = sortId;
    }

    public Comparator<Animal> getComparator() {
        return comparator;
    }

    public Integer getSortId() {
        return sortId;
    }


    public static SortType getById(Integer id) {
        for (SortType sortType : values()) {
            if (sortType.getSortId().equals(id)) {
                return sortType;
            }
        }

        return SortType.NAME_SORT;
    }
}
