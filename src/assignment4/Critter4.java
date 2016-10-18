package assignment4;

public class Critter4 extends Critter{

	@Override
	public void doTimeStep() {
		//nothing
	}

	@Override
	public boolean fight(String oponent) {
		while(this.getEnergy() >= Params.min_reproduce_energy){
			this.reproduce(new Critter4(), Critter.getRandomInt(7));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "4";
	}
}
