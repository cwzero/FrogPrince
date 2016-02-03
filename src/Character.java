abstract class Character {
	String name;

	String getName() {
		return name;
	}
}

class Prince extends Character {
	Prince(String name) {
		this.name = name;
	}
}

class Princess extends Character {
	Princess(String name) {
		this.name = name;
	}
}

class Frog extends Character {
	Frog(String name) {
		this.name = name;
	}
}

class CharacterTest {
	public static void test(Character character) {
		System.out.println("Created a " + character.getClass().getName() + " named " + character.getName());
	}

	public static void main(String[] args) {
		Prince prince = new Prince("Zuko");
		Princess princess = new Princess("Zelda");
		Frog frog = new Frog("Kermit");

		test(prince);
		test(princess);
		test(frog);
	}
}

// --------------------------------------------------------------------------------------------
// //

class Witch extends Character {
	Witch(String name) {
		this.name = name;
	}
}

class WitchTest {
	public static void main(String[] args) {
		Witch witch = new Witch("Elphaba");
		CharacterTest.test(witch);
	}
}

// --------------------------------------------------------------------------------------------
// /

class KissablePrince extends Prince {
	KissablePrince(String name) {
		super(name);
	}

	Character kiss() {
		return this;
	}
}

class KissablePrincess extends Princess {
	KissablePrincess(String name) {
		super(name);
	}

	Character kiss() {
		return this;
	}
}

class KissableFrog extends Frog {
	KissableFrog(String name) {
		super(name);
	}

	Character kiss() {
		return new KissablePrince(name);
	}
}

class KissableWitch extends Witch {
	KissableWitch(String name) {
		super(name);
	}

	Character kiss() {
		return this;
	}
}

class KissTest extends CharacterTest {

	public static void main(String[] args) {
		KissablePrince prince = new KissablePrince("Zuko");
		KissablePrincess princess = new KissablePrincess("Zelda");
		KissableFrog frog = new KissableFrog("Kermit");
		KissableWitch witch = new KissableWitch("Elphaba");

		test(prince);
		test(princess);
		test(frog);
		test(witch);

		System.out.println("Kissing a " + prince.getClass().getName() + " named " + prince.getName()
				+ " and got back a " + prince.kiss().getClass().getName() + " named " + prince.kiss().getName());
		System.out.println("Kissing a " + princess.getClass().getName() + " named " + princess.getName()
				+ " and got back a " + princess.kiss().getClass().getName() + " named " + princess.kiss().getName());
		System.out.println("Kissing a " + frog.getClass().getName() + " named " + frog.getName() + " and got back a "
				+ frog.kiss().getClass().getName() + " named " + frog.kiss().getName());
		System.out.println("Kissing a " + frog.getClass().getName() + " named " + frog.getName() + " and got back a "
				+ frog.kiss().getClass().getName() + " named " + frog.kiss().getName());
	}
}

// --------------------------------------------------------------------------------------------
// //

class SpellPrince extends KissablePrince {
	SpellPrince(String name) {
		super(name);
	}

	Character spellCast() {
		return this;
	}
}

class SpellPrincess extends KissablePrincess {
	SpellPrincess(String name) {
		super(name);
	}

	Character spellCast() {
		return this;
	}
}

class SpellFrog extends KissableFrog {
	SpellFrog(String name) {
		super(name);
	}

	Character kiss() {
		return new SpellPrince(name);
	}

	Character spellCast() {
		return kiss();
	}
}

class SpellWitch extends KissableWitch {
	SpellWitch(String name) {
		super(name);
	}

	Character spellCast() {
		return this;
	}
}

class SpellTest extends KissTest {
	public static void testFrog() {
		SpellFrog frog = new SpellFrog("Kermit");
		Character prince = frog.kiss();
		// If spellfrog.kiss() returned a regular prince instead of spellprince
		// or you didn't cast the result, you would not be able to call the
		// spellcast method here. //
		
		// So, prince.spellCast() would cause the expected problem //
		Character prince2 = ((SpellPrince)prince).spellCast();

		test(frog);
		System.out.println("Kissing frog.");
		test(prince);
		System.out.println("Casting a spell.");
		test(prince2);
	}

	public static void main(String[] args) {
		SpellPrince prince = new SpellPrince("Zuko");
		SpellPrincess princess = new SpellPrincess("Zelda");
		SpellFrog frog = new SpellFrog("Kermit");
		SpellWitch witch = new SpellWitch("Elphaba");

		test(prince);
		test(princess);
		test(frog);
		test(witch);

		System.out.println("Kissing a " + prince.getClass().getName() + " named " + prince.getName()
				+ " and got back a " + prince.kiss().getClass().getName() + " named " + prince.kiss().getName());
		System.out.println("Kissing a " + princess.getClass().getName() + " named " + princess.getName()
				+ " and got back a " + princess.kiss().getClass().getName() + " named " + princess.kiss().getName());
		System.out.println("Kissing a " + frog.getClass().getName() + " named " + frog.getName() + " and got back a "
				+ frog.kiss().getClass().getName() + " named " + frog.kiss().getName());
		System.out.println("Kissing a " + frog.getClass().getName() + " named " + frog.getName() + " and got back a "
				+ frog.kiss().getClass().getName() + " named " + frog.kiss().getName());

		System.out.println("Casting a spell with a " + prince.getClass().getName() + " named " + prince.getName()
				+ " and got back a " + prince.spellCast().getClass().getName() + " named "
				+ prince.spellCast().getName());
		System.out.println("Casting a spell with a " + princess.getClass().getName() + " named " + princess.getName()
				+ " and got back a " + princess.spellCast().getClass().getName() + " named "
				+ princess.spellCast().getName());
		System.out.println("Casting a spell with a  " + frog.getClass().getName() + " named " + frog.getName()
				+ " and got back a " + frog.spellCast().getClass().getName() + " named " + frog.spellCast().getName());
		System.out.println("Casting a spell with a  " + frog.getClass().getName() + " named " + frog.getName()
				+ " and got back a " + frog.spellCast().getClass().getName() + " named " + frog.spellCast().getName());
		testFrog();
	}
}
