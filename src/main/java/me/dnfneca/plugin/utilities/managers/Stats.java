// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers;

import java.util.Random;
import java.util.UUID;

<<<<<<< Updated upstream
public class Stats
{
    public static String getRandomRarity(final UUID MobUUID) {
        final Random rand = new Random();
=======
public class Stats {

    public static String getRandomRarity(UUID MobUUID) {



        Random rand = new Random();
>>>>>>> Stashed changes
        String rarity = null;
        int rarityNumber = 0;
        rand.setSeed(MobUUID.hashCode());
        final double randomNum = rand.nextDouble();
        if (randomNum < 0.55) {
            rarityNumber = 1;
        }
        else if (randomNum < 0.78) {
            rarityNumber = 2;
        }
        else if (randomNum < 0.93) {
            rarityNumber = 3;
        }
        else if (randomNum < 0.98) {
            rarityNumber = 4;
        }
        else {
            rarityNumber = 5;
        }
        switch (rarityNumber) {
            case 2: {
                rarity = "Uncommon";
                break;
            }
            case 3: {
                rarity = "Rare";
                break;
            }
            case 4: {
                rarity = "Epic";
                break;
            }
            case 5: {
                rarity = "Legendary";
                break;
            }
            default: {
                rarity = "Common";
                break;
            }
        }
        return rarity;
    }
    
    public static int getRandomLevel(final int min, final int max) {
        final Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
    
    public static boolean getCritRoll(final double Percentage) {
        final double procent = Percentage * 0.01;
        final double r = Math.random();
        return r < procent;
    }
}
