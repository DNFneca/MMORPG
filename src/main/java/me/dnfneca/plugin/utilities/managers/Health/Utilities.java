package me.dnfneca.plugin.utilities.managers.Health;

public class Utilities {
	public static boolean getCritRoll(double Percentage) {
		double procent = Percentage * 0.01;
		double r = Math.random();
		return r < procent;
	}
}
