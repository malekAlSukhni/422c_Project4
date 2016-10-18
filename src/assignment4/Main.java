/* CRITTERS Main.java
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
package assignment4; // cannot be in default package

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Method;

/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

	static Scanner kb; // scanner connected to keyboard input, or input file
	private static String inputFile; // input file, used instead of keyboard
										// input if specified
	static ByteArrayOutputStream testOutputString; // if test specified, holds
													// all console output
	private static String myPackage; // package of Critter file. Critter cannot
										// be in default pkg.
	private static boolean DEBUG = false; // Use it or not, as you wish!
	static PrintStream old = System.out; // if you want to restore output to
											// console

	// Gets the package name. The usage assumes that Critter and its subclasses
	// are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            args can be empty. If not empty, provide two parameters -- the
	 *            first is a file name, and the second is test (for test output,
	 *            where all output to be directed to a String), or nothing.
	 * @throws InvalidCritterException
	 */
	public static void main(String[] args) throws InvalidCritterException {
		if (args.length != 0) {
			try {
				inputFile = args[0];
				kb = new Scanner(new File(inputFile));
			} catch (FileNotFoundException e) {
				System.out.println("USAGE: java Main OR java Main <input file> <test output>");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
			}
			if (args.length >= 2) {
				if (args[1].equals("test")) { // if the word "test" is the
												// second argument to java
					// Create a stream to hold the output
					testOutputString = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(testOutputString);
					// Save the old System.out.
					old = System.out;
					// Tell Java to use the special stream; all console output
					// will be redirected here from now
					System.setOut(ps);
				}
			}
		} else { // if no arguments to main
			kb = new Scanner(System.in); // use keyboard and console
		}

		/* Do not alter the code above for your submission. */
		/* Write your code below. */
		boolean flag = true;
		while (flag) {
			System.out.print("critter>");
			String input = kb.nextLine();
			String[] fullInput = input.split(" ");
			if (fullInput.length == 1 && fullInput[0].equals("quit")) {
				flag = false;
			} else if (fullInput.length == 1 && fullInput[0].equals("show")) {
				Critter.displayWorld();
			} else if ((fullInput.length == 1 || fullInput.length == 2) && fullInput[0].equals("step")) {
				if (fullInput.length == 2) {
					try {
						int k = Integer.parseInt(fullInput[1]);
						for (int i = 0; i < k; i++) {
							Critter.worldTimeStep();
						}
					} catch (Exception e) {
						System.out.println("error processing: " + input);
					}
				} else {
					Critter.worldTimeStep();
				}
			} else if (fullInput.length == 2 && fullInput[0].equals("seed")) {
				try {
					int k = Integer.parseInt(fullInput[1]);
					Critter.setSeed(k);
				} catch (Exception e) {
					System.out.println("error processing: " + input);
				}
			} else if ((fullInput.length == 2 || fullInput.length == 3) && fullInput[0].equals("make")) {
				String critter = fullInput[1];
				try {
					if (fullInput.length == 3) {
						int k = Integer.parseInt(fullInput[2]);
						for (int i = 0; i < k; i++) {
							Critter.makeCritter(critter);
						}
					} else {
						Critter.makeCritter(critter);
					}
				} catch (Exception e) {
					System.out.println("error processing: " + input);
				}
			} else if (fullInput.length == 2 && fullInput[0].equals("stats")) {
				try {
					Class<?> statter = Class.forName(myPackage + "." + fullInput[1]);
					Method method = statter.getMethod("runStats", List.class);
					method.invoke(null, Critter.getInstances(fullInput[1]));
				} catch (Exception e) {
					System.out.println("error processing: " + input);
				}
			} else {
				System.out.println("invalid command: " + input);
			}
		}
		/* Write your code above */
		System.out.flush();
	}
}
