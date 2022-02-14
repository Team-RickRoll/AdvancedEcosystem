package me.chaoticwagon.advancedecosystem;

import org.bukkit.entity.EntityType;

public class EntityInfo {

    private int birthDay;
    private int currentDay;
    private String entityType;
    private String age;
    private int health;

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public EntityInfo(int birthDay, EntityType entityType) {
        this.birthDay = birthDay;
        this.entityType = entityType.toString();
    }


    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public String getEntityType() {
        return entityType.toString();
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public EntityType getAsEntityType() {
        return EntityType.valueOf(entityType);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "EntityInfo{" +
                "birthDate='" + birthDay + '\'' +
                ", currentDate='" + currentDay + '\'' +
                ", entityType=" + entityType.toString() +
                ", age='" + age + '\'' +
                ", health=" + health +
                '}';
    }

}
