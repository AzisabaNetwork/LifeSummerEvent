package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LifeSummerFishingEvent implements Listener {

    @EventHandler
    public void onFishing(PlayerFishEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName();
        if (!player.getWorld().getName().contains("2022summer")) return;
        if (player.getGameMode() != GameMode.SURVIVAL) return;
        ItemStack playerItemStack = player.getInventory().getItemInMainHand();
        ItemMeta playerItemMeta = playerItemStack.getItemMeta();
        if (playerItemMeta == null) return;
        Random random = new Random();
        if(event.getCaught() instanceof Item){
            Item item = (Item) event.getCaught();
            if (playerItemStack.getType().equals(Material.FISHING_ROD)){
                if (playerItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r 釣り竿"))){
                    if(item.getItemStack().getType().equals(Material.COD)){
                        if (!player.getWorld().getName().contains("2022summer")) return;
                        int randomValue = random.nextInt(100000);
                        int randomValue2 = random.nextInt(100);
                        ItemStack itemStack = item.getItemStack();
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if (itemMeta == null) return;
                        itemMeta.setCustomModelData(1);
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4ザリガニ"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&a[ " + playerName + " ] &rが釣りあげた"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&aザリガニのサイズは&b[ " + randomValue + "." + randomValue2 + " ] &acm"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        if (playerItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r 釣り竿"))){
                            item.setItemStack(itemStack);
                        }
                    }else {
                        ItemStack itemStack = item.getItemStack();
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4誰かが捨てたゴミ"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&d/trash &r推奨"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
                if (playerItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r ミニ釣り竿"))){
                    if(item.getItemStack().getType().equals(Material.COD)){
                        if (!player.getWorld().getName().contains("2022summer")) return;
                        int randomValue = random.nextInt(1000);
                        int randomValue2 = random.nextInt(100);
                        ItemStack itemStack = item.getItemStack();
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if (itemMeta == null) return;
                        itemMeta.setCustomModelData(1);
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4ザリガニ"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&a[ " + playerName + " ] &rが釣りあげた"));
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&aザリガニのサイズは&b[ " + randomValue + "." + randomValue2 + " ] &acm"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        if (playerItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&l2022 &r&4[ザリガニ専用]&r ミニ釣り竿"))){
                            item.setItemStack(itemStack);
                        }
                    }else {
                        ItemStack itemStack = item.getItemStack();
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if(itemMeta == null) return;
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4誰かが捨てたゴミ"));
                        List<String> lore = new ArrayList<>();
                        lore.add(ChatColor.translateAlternateColorCodes('&',"&d/trash &r推奨"));
                        itemMeta.setLore(lore);
                        itemStack.setItemMeta(itemMeta);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
            }
        }
    }
}
