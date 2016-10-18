/* CRITTERS <MyClass.java>
 * EE422C Project 4 submission by
 * Robert Bolt
 * rob329
 * 16465
 * Malek Al Sukhni
 * mha664
 * 16470
 * github link: https://github.com/malekAlSukhni/422c_Project4.git
 * Slip days used: 0
 * Fall 2016
 */
package assignment4;

import java.util.Collections;
import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */

public abstract class Critter {
	private static String myPackage;
	private static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();
	private static List<Critter> runawayList = new java.util.ArrayList<Critter>();

	// Gets the package name. This assumes that Critter and its subclasses are
	// all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}

	private static java.util.Random rand = new java.util.Random();

	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}

	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}

	/*
	 * a one-character long string that visually depicts your critter in the
	 * ASCII interface
	 */
	public String toString() {
		return "";
	}

	private int energy = 0;

	protected int getEnergy() {
		return energy;
	}

	private int x_coord;
	private int y_coord;

	protected final void walk(int direction) {
		int xcoordTemp = this.x_coord;
		int ycoordTemp = this.y_coord;
		if (!runawayList.contains(this)) {
			switch (direction) {
			// case 0 moving to the right
			case 0:
				x_coord += 1;
				x_coord = x_coord % Params.world_width;
				break;
			// case 1 moving up and to the right
			case 1:
				x_coord += 1;
				x_coord = x_coord % Params.world_width;
				if (y_coord == 0) {
					y_coord = Params.world_height - 1;
				} else {
					y_coord -= 1;
				}
				break;
			// case 2 moving up
			case 2:
				if (y_coord == 0) {
					y_coord = Params.world_height - 1;
				} else {
					y_coord -= 1;
				}
				break;
			// case 3 moving up and to the left
			case 3:
				if (x_coord == 0) {
					x_coord = Params.world_width - 1;
				} else {
					x_coord -= 1;
				}
				if (y_coord == 0) {
					y_coord = Params.world_height - 1;
				} else {
					y_coord -= 1;
				}
				break;
			// case 4 moving left
			case 4:
				if (x_coord == 0) {
					x_coord = Params.world_width - 1;
				} else {
					x_coord -= 1;
				}
				break;
			// case 5 moving down and to the left
			case 5:
				if (x_coord == 0) {
					x_coord = Params.world_width - 1;
				} else {
					x_coord -= 1;
				}
				y_coord += 1;
				y_coord = y_coord % Params.world_height;
				break;
			// case 6 moving down
			case 6:
				y_coord += 1;
				y_coord = y_coord % Params.world_height;
				break;
			// case 7 moving down and to the right
			case 7:
				x_coord += 1;
				x_coord = x_coord % Params.world_width;
				y_coord += 1;
				y_coord = y_coord % Params.world_height;
				break;
			}
			for (Critter x : population) {
				if (x.x_coord == xcoordTemp && x.y_coord == ycoordTemp) {
					this.x_coord = xcoordTemp;
					this.y_coord = ycoordTemp;
					break;
				}
			}
			runawayList.add(this);
		}
		energy -= Params.walk_energy_cost;
	}

	protected final void run(int direction) {
		int xcoordTemp = this.x_coord;
		int ycoordTemp = this.y_coord;
		if (!runawayList.contains(this)) {
			switch (direction) {
			// case 0 moving to the right
			case 0:
				x_coord += 2;
				x_coord = x_coord % Params.world_width;
				break;
			// case 1 moving up and to the right
			case 1:
				x_coord += 2;
				x_coord = x_coord % Params.world_width;
				if (y_coord == 0) {
					y_coord = Params.world_height - 2;
				} else {
					if (y_coord == 1) {
						y_coord = Params.world_height - 1;
					} else {
						y_coord -= 2;
					}
				}
				break;
			// case 2 moving up
			case 2:
				if (y_coord == 0) {
					y_coord = Params.world_height - 2;
				} else {
					if (y_coord == 1) {
						y_coord = Params.world_height - 1;
					} else {
						y_coord -= 2;
					}
				}
				break;
			// case 3 moving up and to the left
			case 3:
				if (x_coord == 0) {
					x_coord = Params.world_width - 2;
				} else {
					if (x_coord == 1) {
						x_coord = Params.world_width - 1;
					} else {
						x_coord -= 2;
					}
				}
				if (y_coord == 0) {
					y_coord = Params.world_height - 2;
				} else {
					if (y_coord == 1) {
						y_coord = Params.world_height - 1;
					} else {
						y_coord -= 2;
					}
				}
				break;
			// case 4 moving left
			case 4:
				if (x_coord == 0) {
					x_coord = Params.world_width - 2;
				} else {
					if (x_coord == 1) {
						x_coord = Params.world_width - 1;
					} else {
						x_coord -= 2;
					}
				}
				break;
			// case 5 moving down and to the left
			case 5:
				if (x_coord == 0) {
					x_coord = Params.world_width - 2;
				} else {
					if (x_coord == 1) {
						x_coord = Params.world_width - 1;
					} else {
						x_coord -= 2;
					}
				}
				y_coord += 2;
				y_coord = y_coord % Params.world_height;
				break;
			// case 6 moving down
			case 6:
				y_coord += 2;
				y_coord = y_coord % Params.world_height;
				break;
			// case 7 moving down and to the right
			case 7:
				x_coord += 2;
				x_coord = x_coord % Params.world_width;
				y_coord += 2;
				y_coord = y_coord % Params.world_height;
				break;
			}
			for (Critter x : population) {
				if (x.x_coord == xcoordTemp && x.y_coord == ycoordTemp) {
					this.x_coord = xcoordTemp;
					this.y_coord = ycoordTemp;
					break;
				}
			}
			runawayList.add(this);
		}
		energy -= Params.run_energy_cost;
	}

	protected final void reproduce(Critter offspring, int direction) {
		if (this.energy >= Params.min_reproduce_energy) {
			offspring.energy = this.energy / 2;
			if (this.energy % 2 == 0) {
				this.energy = this.energy / 2;
			} else {
				this.energy = offspring.energy + 1;
			}
			offspring.x_coord = this.x_coord;
			offspring.y_coord = this.y_coord;
			offspring.walk(direction);
			offspring.energy += Params.walk_energy_cost;
			babies.add(offspring);
		}

	}

	public abstract void doTimeStep();

	public abstract boolean fight(String oponent);

	/**
	 * create and initialize a Critter subclass. critter_class_name must be the
	 * unqualified name of a concrete subclass of Critter, if not, an
	 * InvalidCritterException must be thrown. (Java weirdness: Exception
	 * throwing does not work properly if the parameter has lower-case instead
	 * of upper. For example, if craig is supplied instead of Craig, an error is
	 * thrown instead of an Exception.)
	 * 
	 * @param critter_class_name
	 * @throws InvalidCritterException
	 */
	public static void makeCritter(String critter_class_name) throws InvalidCritterException {
		try {
			Critter test;
			Class c = Class.forName(Critter.myPackage + "." + critter_class_name);
			test = (Critter) c.newInstance();
			test.energy = Params.start_energy;
			if (Params.world_width > 1) {
				test.x_coord = getRandomInt(Params.world_width - 1);
			} else {
				test.x_coord = 0;
			}
			if (Params.world_height > 1) {
				test.y_coord = getRandomInt(Params.world_height - 1);
			} else {
				test.y_coord = 0;
			}
			population.add(test);
		} catch (Exception e) {
			throw new InvalidCritterException(critter_class_name);
		}

	}

	/**
	 * Gets a list of critters of a specific type.
	 * 
	 * @param critter_class_name
	 *            What kind of Critter is to be listed. Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		for (Critter x : population) {
			try {
				if (x.getClass().equals(Class.forName(Critter.myPackage + "." + critter_class_name))) {
					result.add(x);
				}
			} catch (ClassNotFoundException e) {
				throw new InvalidCritterException(critter_class_name);
			}
		}
		return result;
	}

	/**
	 * Prints out how many Critters of each type there are on the board.
	 * 
	 * @param critters
	 *            List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string, 1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();
	}

	/*
	 * the TestCritter class allows some critters to "cheat". If you want to
	 * create tests of your Critter model, you can create subclasses of this
	 * class and then use the setter functions contained here.
	 * 
	 * NOTE: you must make sure that the setter functions work with your
	 * implementation of Critter. That means, if you're recording the positions
	 * of your critters using some sort of external grid or some other data
	 * structure in addition to the x_coord and y_coord functions, then you MUST
	 * update these setter functions so that they correctly update your
	 * grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}

		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}

		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}

		protected int getX_coord() {
			return super.x_coord;
		}

		protected int getY_coord() {
			return super.y_coord;
		}

		/*
		 * This method getPopulation has to be modified by you if you are not
		 * using the population ArrayList that has been provided in the starter
		 * code. In any case, it has to be implemented for grading tests to
		 * work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}

		/*
		 * This method getBabies has to be modified by you if you are not using
		 * the babies ArrayList that has been provided in the starter code. In
		 * any case, it has to be implemented for grading tests to work. Babies
		 * should be added to the general population at either the beginning OR
		 * the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		population.clear();
	}

	public static void worldTimeStep() throws InvalidCritterException {
		// executing all time steps for critters
		for (Critter x : population) {
			x.doTimeStep();
			x.energy -= Params.rest_energy_cost;
		}
		for (int i = 0; i < population.size(); i++){
			if(population.get(i).energy <= 0){
				population.remove(i);
				i = 0;
			}
		}
		resolveConflicts();
		for (Critter x : babies) {
			population.add(x);
		}
		babies.clear();
		runawayList.clear();
		for (int i = 0; i < Params.refresh_algae_count; i++) {
			Critter.makeCritter("Algae");
		}
	}

	public static void displayWorld() {
		String[][] grid = new String[Params.world_height][Params.world_width];
		for (Critter x : population) {
			grid[x.y_coord][x.x_coord] = x.toString();
		}
		// printing top border
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
		// printing critters
		for (int i = 0; i < Params.world_height; i++) {
			System.out.print("|");
			for (int j = 0; j < Params.world_width; j++) {
				if (grid[i][j] == null) {
					System.out.print(" ");
				} else
					System.out.print(grid[i][j]);
			}
			System.out.println("|");
		}
		// printing bottom border
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

	private static void resolveConflicts() {

		for (int index = 0; index < population.size(); index++) {
			if (population.get(index).energy <= 0) {
				// if this critter is dead then check the next
				population.remove(index);
				index--; // this minus 1 is because when you remove the critter
							// the size will get smaller so you have to go back
							// an index
			} else {
				for (int index2 = index + 1; index2 < population.size(); index2++) {
					if (population.get(index2).energy <= 0) {
						// if this critter is dead then check the previous
						// critter again
						population.remove(index2);
						index--; // look at comment for minus 1 above
						break;
					}
					if (population.get(index).x_coord == population.get(index2).x_coord
							&& population.get(index).y_coord == population.get(index2).y_coord) {
						// resolving fight
						Critter critter1 = population.get(index);
						Critter critter2 = population.get(index2);
						Boolean fight1 = critter1.fight(critter2.toString());
						Boolean fight2 = critter2.fight(critter1.toString());
						int fightRoll1 = 0;
						int fightRoll2 = 0;
						// neither want to fight
						if (!fight1 && !fight2) {
							if (critter1.x_coord == critter2.x_coord && critter1.y_coord == critter2.y_coord) {
								fight1 = true;
							}
						} else {
							// both want to fight
							if (fight1 && fight2) {
								fightRoll1 = getRandomInt(critter1.energy);
								fightRoll2 = getRandomInt(critter2.energy);
							}
							// only one wants to fight
							if (!fight1 && fight2) {
								fightRoll1 = 0;
								fightRoll2 = getRandomInt(critter2.energy);
							}
							if (fight1 && !fight2) {
								fightRoll1 = getRandomInt(critter1.energy);
								fightRoll2 = 0;
							}
						}
						// winner reaps rewards
						if ((fightRoll1 >= fightRoll2) && (fight1 || fight2)) {
							if (critter2.energy > 0) {
								critter1.energy += critter2.energy / 2;
							}
							population.remove(index2);
						} else {
							if (fight1 || fight2) {
								if (critter1.energy > 0) {
									critter2.energy += critter1.energy / 2;
								}
								population.remove(index);
							}
						}
						// setting index to zero because you have to re-check
						// the critters to make sure none are at zero now and to
						// resolve new conflicts
						index = 0;
						break;
					}
				}
			}
		}
	}
}
