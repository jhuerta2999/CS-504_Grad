import static org.junit.Assert.assertSame;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraditionalCombatTest {

	CombatState combatState;

	@BeforeEach
	void setUp() {
		combatState = new TraditionalCombatState();
	}

	@Test
	void tie_goes_to_defender() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new DefensiveWarrior.Builder(1).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void aggressive_warriors_by_level() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).build();
		Warrior warriorTwo = new AggressiveWarrior.Builder(2).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorOne, winner);
	}

	@Test
	void aggressive_warriors_with_attack_defense_mods() {
		Warrior warriorOne = new AggressiveWarrior.Builder(1).attack(5).build();
		Warrior warriorTwo = new AggressiveWarrior.Builder(1).defense(4).build();
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorOne, winner);
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
		Warrior warriorOne = new ArmoredWarriorDecorator(new AggressiveWarrior.Builder(5).attack(10).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(7).defense(7).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorTwo, winner);
	}

	@Test
	void super_complicated_two() {
		Warrior warriorOne = new StrongWarriorDecorator(new AggressiveWarrior.Builder(12).attack(16).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(15).defense(25).build());
		Warrior winner = combatState.fight(warriorOne, warriorTwo);
		assertSame(warriorOne, winner);
	}
}
