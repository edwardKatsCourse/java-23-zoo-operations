package com.zoo;


public enum AnimalType {

    ELEPHANT(1),
    MONKEY(20),
    TIGER(15)
    ;

    private Integer sicknessFactor;

    AnimalType(Integer sicknessFactor) {
        this.sicknessFactor = sicknessFactor;
    }

    public Integer getSicknessFactor() {
        return sicknessFactor;
    }
}
