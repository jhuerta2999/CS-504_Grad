package org.example;

public abstract class WarriorDecorator extends CalculateWarrior {
    Warrior warrior;

    public WarriorDecorator(Warrior warrior) {
        this.warrior = warrior;
    }
}
