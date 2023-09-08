package org.example;

public class ArmoredWarriorDecorator extends WarriorDecorator {
    Warrior warrior;

    public ArmoredWarriorDecorator(CalculateWarrior warrior) {
        super(warrior);
        this.warrior = warrior;
        this.defense = warrior.getDefense() * 2;
        this.attack = warrior.getAttack();
        this.level = warrior.getLevel();
    }

    public int getLevel() {
        return this.level;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int calculateAttack() {
        return  warrior.calculateAttack();
    }

    public int calculateDefense() {
        return warrior.calculateDefense() + warrior.getDefense();
    }

    public double calculateBoost() {
        boolean isDefensiveWarrior = warrior.getDefense() + 1 != warrior.calculateDefense();

        if (isDefensiveWarrior) {
            return (double) this.defense / 2;
        } else {
            return (double) this.attack / 2;
        }
    }
}
