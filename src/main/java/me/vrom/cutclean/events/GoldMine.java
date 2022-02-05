package me.vrom.cutclean.events;

import me.vrom.cutclean.CutClean;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class GoldMine implements Listener {
    
    private CutClean plugin;
    public GoldMine(CutClean instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        if (e.getBlock().getType().equals(org.bukkit.Material.GOLD_ORE)) {
            if (e.getPlayer().getInventory().getItemInHand().getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS)) {
                //Check if player has permission cutclean.goldmine
                if (e.getPlayer().hasPermission("cutclean.goldmine")) {
                    //Check if the fortune level is 1
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                        //Make the gold ore drop 2 gold ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 2 gold ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.GOLD_INGOT, plugin.getConfig().getInt("gold.1")));
                    }
                    //Check if the fortune level is 2
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                        //Make the gold ore drop 3 gold ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 3 gold ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.GOLD_INGOT, plugin.getConfig().getInt("gold.2")));
                    }
                    //Check if the fortune level is 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                        //Make the gold ore drop 4 gold ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 4 gold ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.GOLD_INGOT, plugin.getConfig().getInt("gold.3")));
                    }
                    //Check if the fortune level is higher than 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) > 3) {
                        //Make the gold ore drop 5 gold ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 5 gold ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.GOLD_INGOT, plugin.getConfig().getInt("gold.4")));
                    }
                }
            } else {
                //Make the gold ore drop 1 gold ingot
                e.getBlock().setType(org.bukkit.Material.AIR);
                //Drop 1 gold ingot
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.GOLD_INGOT, plugin.getConfig().getInt("gold.normal")));
            }
        }
    }
}
