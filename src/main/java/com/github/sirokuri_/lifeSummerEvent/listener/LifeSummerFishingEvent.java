package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.ChatColor;
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
        Random random = new Random();
        if(event.getCaught() instanceof Item){
            Item item = (Item) event.getCaught();
            if(item.getItemStack().getType().equals(Material.COD)){
                int randomValue = random.nextInt(100);
                ItemStack itemStack = item.getItemStack();
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta == null) return;
                itemMeta.setCustomModelData(1);
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4ザリガニ"));
                List<String> lore = new ArrayList<String>();
                lore.add(ChatColor.translateAlternateColorCodes('&',"&a[ " + playerName + " ] &rが釣りあげた"));
                lore.add(ChatColor.translateAlternateColorCodes('&',"&aザリガニのサイズは&b[ " + randomValue + " ] &acm"));
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                item.setItemStack(itemStack);
            }else {
                ItemStack itemStack = item.getItemStack();
                ItemMeta itemMeta = itemStack.getItemMeta();
                if(itemMeta == null) return;
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4誰かが捨てたゴミ"));
                itemStack.setItemMeta(itemMeta);
            }
        }
    }
}
