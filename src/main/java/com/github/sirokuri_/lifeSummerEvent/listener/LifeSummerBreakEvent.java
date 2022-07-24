package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LifeSummerBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        if (!block.getWorld().getName().contains("2022summer")) return;
        if (e.getPlayer().getGameMode() != GameMode.SURVIVAL) {
            return;
        }
        if (block.getType() == Material.AIR) return;
        if (block.getType() == Material.MELON){
            ItemStack itemStack = new ItemStack(Material.PAPER);
            ItemMeta itemMeta = itemStack.getItemMeta();
            if(itemMeta == null) return;
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&42022サマーチケット"));
            itemStack.setItemMeta(itemMeta);
            e.getPlayer().getInventory().addItem(itemStack);
        }
    }
}
