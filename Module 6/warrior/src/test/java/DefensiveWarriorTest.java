import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.DefensiveWarrior;
import org.example.Warrior;
import org.junit.jupiter.api.Test;

class DefensiveWarriorTest {

	@Test
	void correct_instance() {
		Warrior warrior = new DefensiveWarrior.Builder(1).build();
		assertTrue(warrior instanceof DefensiveWarrior);
	}

	@Test
	void default_values() {
		Warrior warrior = new DefensiveWarrior.Builder(1).build();
		assertSame(1, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void custom_level() {
		Warrior warrior = new DefensiveWarrior.Builder(10).build();
		assertSame(10, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void only_attack() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(10, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void only_defense() {
		Warrior warrior = new DefensiveWarrior.Builder(1).defense(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(10, warrior.getDefense());
	}

	@Test
	void both_attack_and_defense() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(5).defense(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(5, warrior.getAttack());
		assertSame(10, warrior.getDefense());
	}

	@Test
	void illegal_state_exception_level() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(-1).build();
		});

		assertEquals("Level must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_attack() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(1).attack(-1).build();
		});

		assertEquals("Attack must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_defense() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(1).defense(-1).build();
		});

		assertEquals("Defense must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_defense() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(-1).defense(-1).build();
		});

		assertEquals("Level must be greater than 0. Defense must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_attack() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(-1).attack(-1).build();
		});

		assertEquals("Level must be greater than 0. Attack must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_attack_and_defense() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> {
			new DefensiveWarrior.Builder(-1).attack(-1).defense(-1).build();
		});

		assertEquals("Level must be greater than 0. Attack must be greater than 0. Defense must be greater than 0. ",
				exception.getMessage());
	}
}
