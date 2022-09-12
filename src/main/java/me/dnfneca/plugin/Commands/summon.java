package me.dnfneca.plugin.Commands;

import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicSpider;
import me.dnfneca.plugin.utilities.managers.CustomMobs.BasicWolf;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Dummy;
import me.dnfneca.plugin.utilities.managers.CustomMobs.Ghoul;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class summon implements CommandExecutor {


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {


//        for (Player p: Bukkit.getOnlinePlayers()) {
//            Scoreboard board = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
//            Objective obj = board.registerNewObjective("Local", "dummy");
//            obj.setDisplayName("Test");
//            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
//            obj.getScoreboard();
//            Score onlineName = obj.getScore(ChatColor.GRAY + "» Online");
//            onlineName.setScore(15);
//
//            Score money = obj.getScore(ChatColor.GRAY + "» Money");
//            money.setScore(13);
//
//            Team moneyCounter = board.registerNewTeam("moneyCounter");
//            moneyCounter.addEntry(ChatColor.RED + "" + ChatColor.WHITE);
//            moneyCounter.setPrefix(ChatColor.GREEN + "$" + p.getHealth());
//            obj.getScore(ChatColor.RED + "" + ChatColor.WHITE).setScore(12);
//            System.out.println(money);
//            p.setScoreboard(board);
//        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("summon")) {
                    if (args[0].equalsIgnoreCase("Basic_Spider")) {
                        BasicSpider.createSpider(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("Basic_Wolf")) {
                        BasicWolf.createWolf(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("Dummy")) {
                        Dummy.createDummy(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("Ghoul")) {
                        Ghoul.createGhoul(player.getLocation(), player);
                    }
                }
            } else {
                player.sendMessage("You are not allowed to use this command!");
            }
            return true;
//            Player p = (Player) sender;
//            new CustomEntitiesUtils().spawnEntity(() ->
//                    new CraftCustomZombie((CraftServer) Bukkit.getServer(), new EntityCustomZombie((EntityTypes<? extends EntityZombie>) EntityTypes.be, (World) p.getWorld())), p.getLocation());

        }else {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
    }
}
