package org.example;

public class DefensiveWarrior implements Warrior {
    private int level;
    private int attack;
    private int defense;

    private DefensiveWarrior warrior;

    public DefensiveWarrior(int level) {
        this.level = level;
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
    public static class Builder {
        private DefensiveWarrior warrior;

        public Builder(int level) {
            warrior = new DefensiveWarrior(level);
            warrior.level = level;
            warrior.attack = 2;
            warrior.defense = 3;
        }

        public Builder attack(int attackLevel) {
            warrior.attack = attackLevel;
            return this;
        }

        public Builder defense(int defenseLevel) {
            warrior.defense = defenseLevel;
            return this;
        }

        public DefensiveWarrior build() {
            validate(warrior);

            return warrior;
        }

        private void validate (DefensiveWarrior warrior) {
            String invalidInput = invalidLevel(warrior);

            if (invalidInput != "") {
                throw new IllegalStateException(invalidInput);
            }
        }

        private String invalidLevel(DefensiveWarrior warrior) {
            String invalidMessage = "";

            if (warrior.level < 0) {
                invalidMessage = "Level must be greater than 0. ";
            }
            if (warrior.attack < 0) {
                invalidMessage += "Attack must be greater than 0. ";
            }
            if (warrior.defense < 0) {
                invalidMessage += "Defense must be greater than 0. ";
            }

            return invalidMessage;
        }
    }
}
