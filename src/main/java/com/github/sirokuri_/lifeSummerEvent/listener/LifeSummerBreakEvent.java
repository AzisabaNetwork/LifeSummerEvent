package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class LifeSummerBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (player.getGameMode() != GameMode.SURVIVAL) return;
        ItemStack playerItemStack = player.getInventory().getItemInMainHand();
        ItemMeta playerItemMeta = playerItemStack.getItemMeta();
        if (playerItemMeta == null) return;
        if (playerItemStack.getType().equals(Material.STICK)) {
            if (playerItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&b&l2022 &r&a[スイカ割り専用]&r 割り棒"))) {
                Random random = new Random();
                int num = random.nextInt(100);
                if (1 <= num && num <= 4) {
                    if (block.getType() == Material.AIR) return;
                    if (block.getType() == Material.MELON){
                        if (block.getWorld().getName().contains("resource") || block.getWorld().getName().contains("resource_the_end") || block.getWorld().getName().contains("resource_nether")) {
                            ItemStack itemStack = new ItemStack(Material.PAPER);
                            ItemMeta itemMeta = itemStack.getItemMeta();
                            if(itemMeta == null) return;
                            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l[2022] サマーチケット!"));
                            itemStack.setItemMeta(itemMeta);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',itemMeta.getDisplayName() + "を入手しました"));
                            player.getInventory().addItem(itemStack);
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 0);
                        }

                    }
                }
            }
        }
    }
}
