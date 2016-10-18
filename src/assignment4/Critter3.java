package assignment4;

public class Critter3 extends Critter{
	
	//always runs
	@Override
	public void doTimeStep() {
		this.run(Critter.getRandomInt(7));
		this.reproduce(new Critter3(), 0);
	}
	
	//only will fight critters that are of the same species
	@Override
	public boolean fight(String oponent) {
		if(this.getClass().toString().equals(oponent)){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "3";
	}
}
