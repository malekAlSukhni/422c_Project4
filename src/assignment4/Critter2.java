package assignment4;

public class Critter2 extends Critter{
private int dir;
	
	@Override
	public String toString() { return "2"; }
	public Critter2(){
		dir = Critter.getRandomInt(8);
	}
	
	
	public boolean fight(String not_used) { 
		if(not_used.equals("2")){
			return true;
		}
		return false; }
	
	@Override
	public void doTimeStep() {
		/* take one step forward */
		walk(dir);
		
		if (getEnergy() > Params.min_reproduce_energy + 40) {
			Critter1 child = new Critter1();
			reproduce(child, Critter.getRandomInt(8));
		}
		
		
		
		dir = getRandomInt(8);
	}

}
