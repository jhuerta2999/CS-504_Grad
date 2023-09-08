package org.example;

public abstract class CalculateWarrior implements Warrior {
    protected int level;
    protected int attack;
    protected int defense;
    public abstract int calculateAttack();

    public abstract int calculateDefense();

    public abstract double calculateBoost();

    public double calculatePower() {
        int attack = calculateAttack();
        int defense = calculateDefense();
        double boost = calculateBoost();

        return attack + defense + boost;
    }
}