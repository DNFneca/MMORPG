package me.dnfneca.plugin.utilities.classes;

import me.dnfneca.plugin.Plugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.scoreboard.Score;

import static me.dnfneca.plugin.utilities.GUI.GUI.MenuChoice;
import static me.dnfneca.plugin.utilities.GUI.GUI.areYouSureClassMenu;

public class AssignClass {

    public static void set(Player p, int ApplyClass) {
        NamespacedKey key = new NamespacedKey(Plugin.getInstance() , "Class");
//        int Class = p.getScoreboard().getObjective("Stats").getScore("Class").getScore();
        Score obj = p.getScoreboard().getObjective("Stats").getScore("Class");
        obj.setScore(ApplyClass);

        PersistentDataContainer playerdata = p.getPersistentDataContainer();
//        playerdata.set(key, PersistentDataType.INTEGER, ApplyClass);


        MenuChoice(p);

        areYouSureClassMenu(p);

    }
}
