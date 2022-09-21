package me.dnfneca.plugin.utilities.classes;

import me.dnfneca.plugin.Plugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class PlayerJoinClassAssignation {
    public static void Class (Objective obj, Player player, PersistentDataContainer playerdata) {
        NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");

        Score Health = obj.getScore("Health");
        Score Defence = obj.getScore("Defence");
        Score Strength = obj.getScore("Strength");
        Score CritChance = obj.getScore("CritChance");
        Score CritDamage = obj.getScore("CritDamage");
        Score Mana = obj.getScore("Mana");
        Score Damage = obj.getScore("Damage");
        Score Speed = obj.getScore("Speed");
        Score Stealth = obj.getScore("Stealth");


        switch (playerdata.get(key, PersistentDataType.INTEGER)) {
            case 1 -> {
                Damage.setScore((int) (25 + 25 * 0.05));
                Health.setScore((int) (100 - 100 * 0.15));
                Defence.setScore((int) (5 + 5 * 0.1));
                Strength.setScore(25);
                CritChance.setScore((int) (0));
                CritDamage.setScore((int) (10 + 20));
                Mana.setScore((int) (100 + 100 * 0.25));
                player.setWalkSpeed((float) (0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
                Stealth.setScore(0);
            }
            case 2 -> {
                Health.setScore((int) (100 + 100 * 0.05));
                Mana.setScore((int) (100 + 100 * 0.5));
                Damage.setScore((int) (25));
                Defence.setScore((int) (5));
                Strength.setScore(25);
                CritChance.setScore(0);
                CritDamage.setScore((int) (10));
                player.setWalkSpeed((float) (0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
                Stealth.setScore(0);
            }
            case 3 -> {
                Damage.setScore((int) (25 - 25 * 0.15));
                Health.setScore((int) (100 + 100 * 0.1));
                Defence.setScore((int) (5));
                Strength.setScore(25);
                CritChance.setScore(0 - 30);
                CritDamage.setScore((int) (10 - 10));
                Mana.setScore((int) (100 + 100 * 0.5));
                Stealth.setScore(0);
                player.setWalkSpeed((float) (0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 4 -> {
                Damage.setScore((int) (25));
                Health.setScore((int) (100 + 100 * 0.1));
                Defence.setScore((int) (5 + 5 * 0.15));
                Strength.setScore(25);
                CritChance.setScore(0 + 10);
                CritDamage.setScore((int) (10 + 5));
                Mana.setScore((int) (100 + 100 * 0.6));
                Stealth.setScore(0);
                player.setWalkSpeed((float) (0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 5 -> {
                Damage.setScore((int) (25 + 25 * 0.2));
                Health.setScore((int) (100 + 100 * 0.15));
                Defence.setScore((int) (5 + 5 * 0.15));
                Strength.setScore((int) (25 + 25 * 0.2));
                CritChance.setScore(0 + 10);
                CritDamage.setScore((int) (10 + 25));
                Mana.setScore((int) (100));
                Stealth.setScore(0);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.1));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 6 -> {
                Damage.setScore((int) (25 + 25 * 0.05));
                Health.setScore((int) (100 + 100 * 0.1));
                Defence.setScore((int) (5 + 5 * 0.15));
                Strength.setScore(25);
                CritChance.setScore(0 + 15);
                CritDamage.setScore((int) (10 + 15));
                Mana.setScore((int) (100));
                Stealth.setScore(0);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.15));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 7 -> {
                Damage.setScore((int) (25 + 25 * 0.1));
                Health.setScore((int) (100 + 100 * 0.15));
                Defence.setScore((int) (5 + 5 * 0.2));
                Strength.setScore(25);
                CritChance.setScore(0 + 10);
                CritDamage.setScore((int) (10 + 15));
                Mana.setScore((int) (100));
                player.setWalkSpeed((float) (0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
                Stealth.setScore(0);
            }
            case 8 -> {
                Damage.setScore((int) (25 + 25 * 0.15));
                Health.setScore((int) (100 + 100 * 0.1));
                Defence.setScore((int) (5 + 5 * 0.05));
                Strength.setScore((int) (25 + 25 * 0.2));
                CritChance.setScore(0 + 20);
                CritDamage.setScore((int) (10 + 5));
                Mana.setScore((int) (100));
                Stealth.setScore(0);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.2));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 9 -> {
                Damage.setScore((int) (25 + 25 * 0.2));
                Health.setScore((int) (100 - 100 * 0.1));
                Defence.setScore((int) (5 - 5 * 0.05));
                Strength.setScore(25);
                CritChance.setScore(0 + 25);
                CritDamage.setScore((int) (10 + 5));
                Mana.setScore((int) (100));
                Stealth.setScore(10);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.15));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 10 -> {
                Damage.setScore((int) (25 + 25 * 0.15));
                Health.setScore((int) (100 + 100 * 0.15));
                Defence.setScore((int) (5 - 5 * 0.1));
                Strength.setScore(25);
                CritChance.setScore(0 + 20);
                CritDamage.setScore((int) (10 + 10));
                Mana.setScore((int) (100));
                Stealth.setScore(15);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.15));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 11 -> {
                Damage.setScore((int) (25 + 25 * 0.05));
                Health.setScore((int) (100 + 100 * 0.05));
                Defence.setScore((int) (5 - 5 * 0.15));
                Strength.setScore(25);
                CritChance.setScore(0 + 10);
                CritDamage.setScore((int) (10 + 5));
                Mana.setScore((int) (100));
                Stealth.setScore(5);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.3));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
            case 12 -> {
                Damage.setScore((int) (25 + 25 * 0.2));
                Health.setScore((int) (100 + 100 * 0.1));
                Defence.setScore((int) (5 - 5 * 0.15));
                Strength.setScore((int) (25 + 25 * 0.05));
                CritChance.setScore(0 + 15);
                CritDamage.setScore((int) (10 + 30));
                Mana.setScore((int) (100));
                Stealth.setScore(25);
                player.setWalkSpeed((float) (0.2 + 0.2 * 0.4));
                Speed.setScore((int) (player.getWalkSpeed() * 500));
            }
        }

    }
}
