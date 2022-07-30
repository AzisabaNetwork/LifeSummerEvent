package com.github.sirokuri_.lifeSummerEvent.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LifeSummerRequestEvent implements Listener {

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e){
        Player player = e.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta == null) return;
        String itemDisplayName = itemMeta.getDisplayName();
        if(itemDisplayName.equals((ChatColor.translateAlternateColorCodes('&',"&4サリガ二")))) {
            Block clickedBlock = e.getBlock();
            if (clickedBlock.getType() == Material.OAK_WALL_SIGN) {
                Sign sign = (Sign) clickedBlock.getState();
                String line = sign.getLine(0);
                if(line.equals("ザリガニ提出")){
                    Block block = e.getBlock();
                    for (BlockFace face : new BlockFace[] {BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST,}) {
                        Block relative = block.getRelative(face);
                        if (relative.getType() == Material.CHEST) {
                            Chest chest = (Chest) relative.getState();
                            Inventory inv = chest.getInventory();
                            int emptySlot = inv.firstEmpty();
                            if (emptySlot == -1) {
                                player.sendMessage("チェストが満タンです。運営に報告してください");
                                return;
                            }else{
                                inv.addItem(itemStack);
                                itemStack.setAmount(0);
                                player.sendMessage("リクエスト用紙を申請しました");
                            }
                        }
                    }
                }
            }
        }
    }
}
