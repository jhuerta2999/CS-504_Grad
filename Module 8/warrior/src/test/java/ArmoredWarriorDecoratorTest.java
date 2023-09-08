import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.AggressiveWarrior;
import org.example.ArmoredWarriorDecorator;
import org.example.DefensiveWarrior;
import org.example.Warrior;
import org.junit.jupiter.api.Test;

class ArmoredWarriorDecoratorTest {

    @Test
    void correct_instance() {
        Warrior warrior = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(1).build());
        assertTrue(warrior instanceof ArmoredWarriorDecorator);
    }

    @Test
    void double_defense_aggressive() {
        Warrior warrior = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(1).defense(10).build());
        assertSame(20, warrior.getDefense());
    }

    @Test
    void double_defense_calculate_defense_aggressive() {
        Warrior warrior = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(1).defense(10).build());
        assertSame(21, warrior.calculateDefense());
    }

    @Test
    void double_defense_get_power_aggressive() {
        Warrior warrior = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(1).defense(10).build());
        assertEquals(27.5, warrior.calculatePower());
    }

    @Test
    void double_defense_defensive() {
        Warrior warrior = new ArmoredWarriorDecorator(new DefensiveWarrior.Builder(1).defense(10).build());
        assertSame(20, warrior.getDefense());
    }

    @Test
    void double_defense_calculate_defense_defensive() {
        Warrior warrior = new ArmoredWarriorDecorator(new DefensiveWarrior.Builder(1).defense(10).build());
        assertSame(22, warrior.calculateDefense());
    }

    @Test
    void double_defense_calculate_boost_defensive() {
        Warrior warrior = new ArmoredWarriorDecorator(new DefensiveWarrior.Builder(1).defense(10).build());
        assertEquals(10, warrior.calculateBoost());
    }

    @Test
    void double_defense_get_power_defensive() {
        Warrior warrior = new ArmoredWarriorDecorator(new DefensiveWarrior.Builder(1).defense(10).build());
        assertEquals(35, warrior.calculatePower());
    }
}