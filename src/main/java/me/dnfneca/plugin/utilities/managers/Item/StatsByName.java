package me.dnfneca.plugin.utilities.managers.Item;

import java.util.Arrays;

import static me.dnfneca.plugin.utilities.managers.Item.RegisterItem.RegisteredItems;

public class StatsByName {
    static int i = 0;
    public static final String[] RegisteredItemsStats = new String[700];
    public static void SetStats(String ItemName, String[] ItemStats) {
        i = 0;
        for (String s : RegisteredItems) {
            i++;
            if(s.equals(ItemName)) {
                break;
            }
        }
        int laststat = i * 7, firststat, statI = 0, currentstat;
        if(i == 1) {
            laststat --;
            firststat = laststat - 6;
        } else {
            firststat = laststat - 7;
        }
        currentstat = firststat;
        while ( currentstat <= laststat ) {
            RegisteredItemsStats[currentstat] = ItemStats[statI];
            currentstat ++;
            statI ++;
        }
    }

    public static void GetStats(String ItemName) {
        i = 0;
        for (String s : RegisteredItems) {
            i++;
            if(s.equals(ItemName)) {
                System.out.println(s);
                break;
            }
        }
        int laststat = i * 7, firststat, statI = 0, currentstat;
        if(i == 1) {
            laststat --;
            firststat = laststat - 6;
        } else {
            firststat = laststat - 7;
            laststat--;
        }
        currentstat = firststat;
        while ( currentstat <= laststat ) {
            System.out.println(RegisteredItemsStats[currentstat]);
            currentstat ++;
        }
        System.out.println(Arrays.toString(RegisteredItemsStats));
    }
}
