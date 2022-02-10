package me.chaoticwagon.advancedecosystem;

import org.bukkit.entity.EntityType;

public class EntityInfo {

    private int birthDay;
    private int currentDay;
    private EntityType entityType;
    private String age;
    private int health;

    public EntityInfo(int birthDay, EntityType entityType) {
        this.birthDay = birthDay;
        this.entityType = entityType;
    }


    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
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
                "birthDate='" + birthDate + '\'' +
                ", currentDate='" + currentDate + '\'' +
                ", entityType=" + entityType.toString() +
                ", age='" + age + '\'' +
                ", health=" + health +
                '}';
    }

}
