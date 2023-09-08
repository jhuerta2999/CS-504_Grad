import static org.junit.Assert.assertSame;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerCombatTest {

	CombatState combatState;

	@BeforeEach
	void setUp() {
		combatState = new PowerCombatState();
	}

	@Test
	void tie_goes_to_defender() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new AggressiveWarrior.Builder(1).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void aggressive_warriors_by_level() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new AggressiveWarrior.Builder(2).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void aggressive_warriors_with_defense_mod() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new AggressiveWarrior.Builder(1).defense(4).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void aggressive_warrior_vs_defensive_warrior() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new DefensiveWarrior.Builder(1).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void strong_aggressive_vs_armored_defensive() {
		Warrior warriorOne = new StrongWarriorDecorator(new AggressiveWarrior.Builder(1).build());
		Warrior warriorTwo = new ArmoredWarriorDecorator(new DefensiveWarrior.Builder(1).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void armored_aggressive_vs_strong_defensive() {
		Warrior warriorOne = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(1).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(1).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void super_complicated_one() {
		Warrior warriorOne = new ArmoredWarriorDecorator(
				new AggressiveWarrior.Builder(5).attack(12).defense(5).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(7).attack(10).defense(2).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void super_complicated_two() {
		Warrior warriorOne = new ArmoredWarriorDecorator(
				new DefensiveWarrior.Builder(12).attack(15).defense(22).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(15).attack(7).defense(39).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}
}
