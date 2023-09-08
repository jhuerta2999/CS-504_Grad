package org.example;

public interface Warrior {

    int getLevel();
    int getAttack();
    int getDefense();

    public interface Builder{
        Builder attack ( int attackLevel);

        Builder defense ( int defenseLevel);

        Warrior build ();

        void validate (AggressiveWarrior warrior);

        String invalidLevel (AggressiveWarrior warrior);
    }
}
