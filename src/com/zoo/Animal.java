package com.zoo;

public class Animal {

    private Integer animalId;
    private String name;
    private AnimalType type; //elefant, elephant, eelphant
    private Integer health;
    private boolean isFed;
    private Integer age;

    //#1, #2
    @Override
    public String toString() {
        return String.format("#%s - Name: %s | Type: %s | Age: %s | Fed : %s | Health: %s",
                this.animalId,
                this.name,
                this.type.name(),
                this.age,
                this.isFed ? "Full" : "Starving",
                this.health
        );
    }

    public Animal(String name, AnimalType type, Integer age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
