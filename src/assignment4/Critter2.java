package assignment4;

public class Critter2 extends Critter {
	private int dir;

	@Override
	public String toString() {
		return "2";
	}

	public Critter2() {
		dir = Critter.getRandomInt(7);
	}

	public boolean fight(String not_used) {
		if (not_used.equals("@")) {
			return true;
		}
		run(dir);
		return false;
	}

	@Override
	public void doTimeStep() {

		if (getEnergy() > Params.min_reproduce_energy + 40) {
			reproduce(new Critter2(), Critter.getRandomInt(7));
		}

		dir = getRandomInt(8);
	}

}
