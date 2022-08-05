package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class LifeSummerBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        //if (!block.getWorld().getName().contains("resource")) return;
        if (e.getPlayer().getGameMode() != GameMode.SURVIVAL) {
            return;
        }
        Random random = new Random();
        int num = random.nextInt(200);
        if (1 <= num && num <= 4) {
            if (block.getType() == Material.AIR) return;
            if (block.getType() == Material.MELON){
                ItemStack itemStack = new ItemStack(Material.PAPER);
                ItemMeta itemMeta = itemStack.getItemMeta();
                if(itemMeta == null) return;
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&l[2022] サマーチケット!"));
                itemStack.setItemMeta(itemMeta);
                e.getPlayer().getInventory().addItem(itemStack);
            }
        }
    }
}
