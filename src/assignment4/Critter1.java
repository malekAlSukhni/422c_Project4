package assignment4;

public class Critter1 {
private int dir;
	
	@Override
	public String toString() { return “1”; }
	public Critter1(){
		dir = Critter.getRandomInt(8);
	}
	
	
	public boolean fight(String not_used) { 
		return true;}
	
	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if (getEnergy() > Params.min_reproduce_energy * 2) {
			Critter1 child = new Critter1();
			reproduce(child, Critter.getRandomInt(8));
			Critter1 child2 = new Critter1();
			reproduce(child2, Critter.getRandomInt(8));
		}
		
		
		
		dir = getRandomInt(8);
	}

}
