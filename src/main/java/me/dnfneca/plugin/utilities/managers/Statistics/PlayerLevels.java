// 
// Decompiled by Procyon v0.5.36
// 

package me.dnfneca.plugin.utilities.managers.Statistics;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Reader;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.entity.Player;

<<<<<<< Updated upstream
public class PlayerLevels
{
    public static void add(final Player p, final int amountOfXP) {
        try {
            final JSONParser parser = new JSONParser();
            final JSONObject data = (JSONObject)parser.parse((Reader)new FileReader("./plugins/MMORPGData/Level.json"));
            final int newAmountOfXP = getXP(p) + amountOfXP;
            final Object xe = data.get((Object)p.getUniqueId().toString());
            if (xe == null) {
                final JSONObject jsonObject = data;
                jsonObject.put((Object)p.getUniqueId(), (Object)amountOfXP);
                final FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json");
                file.write(jsonObject.toString());
                file.close();
            }
            else {
                final Object Value = data.get((Object)p.getUniqueId().toString());
                final JSONObject jsonObject2 = data;
                final JSONObject newJSONObject = data;
                newJSONObject.put((Object)p.getUniqueId().toString(), (Object)newAmountOfXP);
                final FileWriter file2 = new FileWriter("./plugins/MMORPGData/Level.json");
                jsonObject2.replace((Object)p.getUniqueId(), (Object)jsonObject2, (Object)newJSONObject);
                file2.write(jsonObject2.toString());
                file2.close();
            }
        }
        catch (IOException | ParseException ex2) {
            final Exception ex;
            final Exception exception = ex;
            exception.printStackTrace();
        }
    }
    
    public static int getXP(final Player p) {
        try {
            final JSONParser parser = new JSONParser();
            final JSONObject data = (JSONObject)parser.parse((Reader)new FileReader("./plugins/MMORPGData/Level.json"));
            int xpAmount = 1;
            if (data.get((Object)p.getUniqueId().toString()) != null) {
                xpAmount = Integer.parseInt(String.valueOf(data.get((Object)p.getUniqueId().toString())));
            }
            if (xpAmount > 985037) {
                xpAmount = 985037;
            }
=======
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerLevels {
    public static void add(Player p, int amountOfXP) {
            try {
                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(
                        new FileReader("./plugins/MMORPGData/Level.json"));//path to the JSON file.
                int newAmountOfXP = getXP(p) + amountOfXP;
                Object xe = data.get(p.getUniqueId().toString());
                if (xe == null) {
                    JSONObject jsonObject = data;
                    jsonObject.put(p.getUniqueId(), amountOfXP);
                    FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json");
                    file.write(jsonObject.toString());
                    file.close();
                } else {
                    Object Value = data.get(p.getUniqueId().toString());
                    JSONObject jsonObject = data;
                    JSONObject newJSONObject = data;
                    newJSONObject.put(p.getUniqueId().toString(), newAmountOfXP);
                    FileWriter file = new FileWriter("./plugins/MMORPGData/Level.json");
                    jsonObject.replace(p.getUniqueId(), jsonObject, newJSONObject);
                    file.write(jsonObject.toString());
                    file.close();
                }
            } catch (IOException | ParseException exception) {
                exception.printStackTrace();
            }
    }
    public static int getXP(Player p) {
        try {

            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("./plugins/MMORPGData/Level.json"));//path to the JSON file.
            int xpAmount = 1;


            if(data.get(p.getUniqueId().toString()) != null) {
                xpAmount = Integer.parseInt(String.valueOf(data.get(p.getUniqueId().toString())));
            }

            if(xpAmount > 985037) {
                xpAmount = 985037;
            }

>>>>>>> Stashed changes
            return xpAmount;
        }
        catch (IOException | ParseException ex2) {
            final Exception ex;
            final Exception e = ex;
            throw new RuntimeException(e);
        }
    }
    
    public static int getLevel(final Player p) {
        final int xpAmount = getXP(p) + 1;
        int PlayerLevel = 0;
<<<<<<< Updated upstream
        for (int i = 0; i < 101; ++i) {
            final int Level = (int)Math.round(Math.pow(Math.sqrt(10 * (i * 10)), 3.0));
            if (Level > xpAmount) {
                PlayerLevel = i;
=======

        for (int i = 0; i < 101; i++) {
            int Level = (int) Math.round(Math.pow(Math.sqrt((10*(i*10))), 3));
            if(Level > xpAmount) {
                PlayerLevel=i;
>>>>>>> Stashed changes
                break;
            }
        }
        return PlayerLevel;
    }
<<<<<<< Updated upstream
    
    public static void setLevel(final Player p, final int level) {
        for (int i = 0; i < level; ++i) {
            add(p, getLeftXp(p));
        }
    }
    
    public static int getLeftXp(final Player p) {
        final int xpAmount = getXP(p);
        int xpLeft = 0;
        final int i = getLevel(p);
        final int Level = (int)Math.round(Math.pow(Math.sqrt(10 * (i * 10)), 3.0));
        xpLeft = Level - xpAmount;
        return xpLeft;
    }
    
    public static int getLevelXp(final Player p) {
        final int i = getLevel(p);
        final int Level = (int)Math.round(Math.pow(Math.sqrt(10 * (i * 10)), 3.0));
        final int levelXp = Level - (int)Math.round(Math.pow(Math.sqrt(10 * ((i - 1) * 10)), 3.0));
=======

    public  static void setLevel(Player p, int level) {

        for (int i = 0; i < level; i++) {
            PlayerLevels.add(p ,getLeftXp(p));
        }
    }
    public static int getLeftXp(Player p) {

        int xpAmount = getXP(p);
        int xpLeft = 0;

        int i = getLevel(p);
        int Level = (int) Math.round(Math.pow(Math.sqrt((10*(i*10))), 3));
        xpLeft=Level - xpAmount;
        return xpLeft;
    }

    public static int getLevelXp(Player p) {

        int levelXp;

        int i = getLevel(p);
        int Level = (int) Math.round(Math.pow(Math.sqrt((10*(i*10))), 3));
        levelXp=Level-(int) Math.round(Math.pow(Math.sqrt((10*((i-1)*10))), 3));

>>>>>>> Stashed changes
        return levelXp;
    }
}
