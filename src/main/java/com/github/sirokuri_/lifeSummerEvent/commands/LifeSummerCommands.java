package com.github.sirokuri_.lifeSummerEvent.commands;

import com.github.sirokuri_.lifeSummerEvent.LifeSummerEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LifeSummerCommands implements CommandExecutor {

    private final LifeSummerEvent plugin;

    public LifeSummerCommands(LifeSummerEvent lifeSummerEvent) {
        this.plugin = lifeSummerEvent;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("lifeSummer")) {
            if (args.length <= 0) {
                return true;
            }
            if (args[0].equalsIgnoreCase("get")) {
                if (args.length <= 1) {
                    return true;
                }
                if (args[1].equalsIgnoreCase("1")) {
                    if (sender.hasPermission("2022lifeSummerCommand.permission.Admin")) {
                        ItemStack itemStack = new ItemStack(Material.PAPER);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return true;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l[2022] サマーチケット!"));
                        itemStack.setItemMeta(itemMeta);
                        player.getInventory().addItem(itemStack);
                    }
                }
                if (args[1].equalsIgnoreCase("2")) {
                    if (sender.hasPermission("2022lifeSummerCommand.permission.Admin")) {
                        ItemStack itemStack = new ItemStack(Material.FISHING_ROD);
                        itemStack.addUnsafeEnchantment(Enchantment.LURE,1);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return true;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r 釣り竿"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&a&llifeevent鯖の"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&b&l2022summer&6&bワールドの水場で"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&cザリガニ&rを釣ろう!"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        player.getInventory().addItem(itemStack);
                    }
                }

                if (args[1].equalsIgnoreCase("3")) {
                    if (sender.hasPermission("2022lifeSummerCommand.permission.Admin")) {
                        ItemStack itemStack = new ItemStack(Material.FISHING_ROD);
                        itemStack.addUnsafeEnchantment(Enchantment.LURE,1);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return true;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r ミニ釣り竿"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&a&llifeevent鯖の"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&b&l2022summer&6&bワールドの水場で"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&cザリガニ&rを釣ろう!"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        player.getInventory().addItem(itemStack);
                    }
                }
                if (args[1].equalsIgnoreCase("5")) {
                    if (sender.hasPermission("2022lifeSummerCommand.permission.Admin")) {
                        ItemStack itemStack = new ItemStack(Material.STICK);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return true;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&a[スイカ割り専用]&r 割り棒"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&a&lliferesource鯖の"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&aresourceワールドでスイカを壊そう！"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&d特殊なチケットが出るかも？"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        player.getInventory().addItem(itemStack);
                    }
                }
            }
        }
        return true;
    }
}
