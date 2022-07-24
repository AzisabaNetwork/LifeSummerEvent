package com.github.sirokuri_.lifeSummerEvent.commands;

import com.github.sirokuri_.lifeSummerEvent.LifeSummerEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LifeSummerCommands implements CommandExecutor {

    private final LifeSummerEvent plugin;

    public LifeSummerCommands(LifeSummerEvent lifeSummerEvent) {
        this.plugin = lifeSummerEvent;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("2022lifeSummer")) {
            if (args.length <= 0) {
                return true;
            }
            if (args[0].equalsIgnoreCase("get")) {
                if (sender.hasPermission("2022lifeSummerCommand.permission.Admin")) {
                    ItemStack itemStack = new ItemStack(Material.PAPER);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if(itemMeta == null) return true;
                    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&42022サマーチケット"));
                    itemStack.setItemMeta(itemMeta);
                    player.getInventory().addItem(itemStack);
                }
            }
        }
        return true;
    }
}
