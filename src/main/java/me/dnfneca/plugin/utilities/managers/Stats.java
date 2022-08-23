package me.dnfneca.plugin.utilities.managers;

import me.dnfneca.plugin.utilities.inventory.ItemStats;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.Objective;

import java.util.*;

public class Stats {
    private static final List<String> stats = new ArrayList<>();
    public static String[] reset(Player p, Objective obj) {
        final double Health = 0;
        final double Defence = 0;
        final double Strength = 0;
        final double CritChance = 0;
        final double CritDamage = 0;

        setStats(0, String.valueOf(Health), obj);
        setStats(1, String.valueOf(Defence), obj);
        setStats(2, String.valueOf(Strength), obj);
        setStats(3, String.valueOf(CritChance), obj);
        setStats(4, String.valueOf(CritDamage), obj);

        return stats.toArray(new String[0]);
    }
    public static List<String> getStats() {
        return stats;
    }
    public static List<String> addStats(int index, String newEntry) {
        stats.add(index, newEntry);
        return stats;
    }
    public static List<String> setStats(int index, String newEntry, Objective obj) {
        stats.set(index, newEntry);
        switch (index) {
            case 0:
                obj.getScore("Health").setScore(Integer.parseInt(newEntry));
                break;
            case 1:
                obj.getScore("Defence").setScore(Integer.parseInt(newEntry));
                break;
            case 2:
                obj.getScore("Strength").setScore(Integer.parseInt(newEntry));
                break;
            case 3:
                obj.getScore("CritChance").setScore(Integer.parseInt(newEntry));
                break;
            case 4:
                obj.getScore("CritDamage").setScore(Integer.parseInt(newEntry));
                break;
            case 5:
                obj.getScore("EffectiveHealth").setScore(Integer.parseInt(newEntry));
                break;
            case 6:
                obj.getScore("EffectiveDefence").setScore(Integer.parseInt(newEntry));
                break;
            case 7:
                obj.getScore("EffectiveStrength").setScore(Integer.parseInt(newEntry));
                break;
            case 8:
                obj.getScore("EffectiveCritChance").setScore(Integer.parseInt(newEntry));
                break;
            case 9:
                obj.getScore("EffectiveCritDamage").setScore(Integer.parseInt(newEntry));
                break;
            case 10:
                obj.getScore("CurrentHealth").setScore(Integer.parseInt(newEntry));
                break;
        }

        return stats;
    }
    public static double getDefence(EntityDamageByEntityEvent e, Player player, ArrayList<String> tags, double defence, boolean isPlayer) {
        double Def = 1;
        if(isPlayer == false) {
//            System.out.println(ItemStats.Weapon(player)[1]);
            int getPlayerStrength = Integer.parseInt(Objects.requireNonNull(player.getScoreboard().getObjective("Stats")).getScore("Strength").getScore() + ItemStats.Weapon(player)[1]);
            int getAttackedStrength = Integer.parseInt(tags.get(1));
//            int getPlayerStrength = Objects.requireNonNull(player.getScoreboard().getObjective("Stats")).getScore("Strength").getScore();
            Def = defence / (getPlayerStrength/25);
        } else
            Def = Objects.requireNonNull(player.getScoreboard().getObjective("Stats")).getScore("Defence").getScore();




        return Def;
    }

    public static double getStrength(EntityDamageByEntityEvent e, Player player, ArrayList<String> tags) {
        int getPlayerStrength = Objects.requireNonNull(player.getScoreboard().getObjective("Stats")).getScore("Defence").getScore();
        int getAttackedDefence = Integer.parseInt(tags.get(1));

        double Strength = 0;

        return Strength;
    }

    public static String getRandomRarity(UUID MobUUID) {
        Random rand = new Random();
        String rarity = null;
        int rarityNumber = 0;
// nextInt as provided by Random is exclusive of the top value so you need to add 1
        rand.setSeed(MobUUID.hashCode());


        double randomNum = rand.nextDouble();
        if(randomNum < .55) {               // 55%
            rarityNumber=1;
        } else if(randomNum < .78) {        // 23%
            rarityNumber=2;
        } else if(randomNum < .93) {        // 15%
            rarityNumber=3;
        } else if(randomNum < .98) {        // 5%
            rarityNumber=4;
        } else {                            // 2%
            rarityNumber=5;
        }



        switch (rarityNumber){
            case 2:
                rarity="Rare";
                break;
            case 3:
                rarity="Epic";
                break;
            case 4:
                rarity="Legendary";
                break;
            case 5:
                rarity="Mythic";
                break;
            default:
                rarity="Common";
                break;
        }


        return rarity;
    }
    public static int getRandomLevel(int min, int max) {
        Random rand = new Random();
// nextInt as provided by Random is exclusive of the top value so you need to add 1

        return rand.nextInt((max - min) + 1) + min;
    }
}
