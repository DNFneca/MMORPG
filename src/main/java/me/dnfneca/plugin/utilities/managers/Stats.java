package me.dnfneca.plugin.utilities.managers;

import java.util.Random;
import java.util.UUID;

public enum Stats {
	;

	public static String getRandomRarity(UUID MobUUID) {


		Random rand = new Random();
		String rarity = null;
		int rarityNumber = 0;
// nextInt as provided by Random is exclusive of the top value, so you need to add 1
		rand.setSeed(MobUUID.hashCode());


		double randomNum = rand.nextDouble();
		if (0.55 > randomNum) {               // 55%
			rarityNumber = 1;
		} else if (0.78 > randomNum) {        // 23%
			rarityNumber = 2;
		} else if (0.93 > randomNum) {        // 15%
			rarityNumber = 3;
		} else if (0.98 > randomNum) {        // 5%
			rarityNumber = 4;
		} else {                            // 2%
			rarityNumber = 5;
		}


		switch (rarityNumber) {
			case 2:
				rarity = "Uncommon";
				break;
			case 3:
				rarity = "Rare";
				break;
			case 4:
				rarity = "Epic";
				break;
			case 5:
				rarity = "Legendary";
				break;
			default:
				rarity = "Common";
				break;
		}


		return rarity;
	}

	public static int getRandomLevel(int min, int max) {
		Random rand = new Random();
// nextInt as provided by Random is exclusive of the top value, so you need to add 1

		return rand.nextInt((max - min) + 1) + min;
	}

	public static boolean getCritRoll(double Percentage) {
		double procent = Percentage * 0.01;
		double r = Math.random();
		return r < procent;
	}
}
