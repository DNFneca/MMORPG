package me.dnfneca.plugin.utilities.managers.Statistics;

import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
//            Object obj = new FileReader("./plugins/MMORPGData/MainData.json");
//            JSONObject object = (JSONObject) obj;
//
//            String name = (String) jsonObject.get(e.getPlayer());
//            System.out.println(name);
//

    }
    public static int getXP(Player p) {
        try {

            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("./plugins/MMORPGData/Level.json"));//path to the JSON file.
            int xpAmount = -1;


            if(data.get(p.getUniqueId().toString()) != null) {
                xpAmount = Integer.parseInt(String.valueOf(data.get(p.getUniqueId().toString())));
            }

            System.out.println(xpAmount);

            return xpAmount;

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }


    }
    public static int getLevel(Player p) {

        int xpAmount = getXP(p)+1;
        int PlayerLevel = 0;

        for (int i = 0; i < 100; i++) {
            int Level = (int) Math.round(Math.pow(Math.sqrt((50*(i*20))), 2));
            if(Level > xpAmount) {
                PlayerLevel=i;
                break;
            }

        }

        return PlayerLevel;
    }
    public static int getLeftXp(Player p) {

        int xpAmount = getXP(p);
        int xpLeft = 0;

        for (int i = 0; i < 100; i++) {
            int Level = (int) Math.round(Math.pow(Math.sqrt((50*(i*20))), 2));
            if(Level > xpAmount) {
                xpLeft=Level - xpAmount;
                break;
            }

        }

        return xpLeft;
    }

    public static int getLevelXp(Player p) {

        int xpAmount = getXP(p);
        int levelXp = 0;

        for (int i = 0; i < 100; i++) {
            int Level = (int) Math.round(Math.pow(Math.sqrt((50*(i*20))), 2));
            if(Level > xpAmount) {
                levelXp=Level-(int) Math.round(Math.pow(Math.sqrt((50*((i-1)*20))), 2));
                break;
            }

        }

        System.out.println(levelXp);

        return levelXp;
    }
}
