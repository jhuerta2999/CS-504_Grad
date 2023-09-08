package org.example;

public class StrongWarriorDecorator extends WarriorDecorator {
    Warrior warrior;

    public StrongWarriorDecorator (CalculateWarrior warrior) {
        super(warrior);
        this.warrior = warrior;
        this.defense = warrior.getDefense();
        this.attack = warrior.getAttack() * 2;
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
        return warrior.calculateAttack() + warrior.getAttack();
    }

    public int calculateDefense() {
        return warrior.calculateDefense();
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
