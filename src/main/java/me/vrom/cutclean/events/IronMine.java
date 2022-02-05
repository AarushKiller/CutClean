package me.vrom.cutclean.events;

import me.vrom.cutclean.CutClean;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class IronMine implements Listener {
    private Plugin plugin = CutClean.getPlugin(CutClean.class);
    @EventHandler
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        if (e.getBlock().getType().equals(org.bukkit.Material.IRON_ORE)) {
            //Check if the item in hand is a pickaxe has fortune
            if (e.getPlayer().getInventory().getItemInHand().getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS)) {
                //Check if the player has permission cutclean.ironmine
                if (e.getPlayer().hasPermission("cutclean.ironmine")) {
                    //Check if the fortune level is 1
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                        //Make the iron ore drop 2 iron ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 2 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.IRON_INGOT, plugin.getConfig().getInt("iron.1")));
                    }
                    //Check if the fortune level is 2
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                        //Make the iron ore drop 3 iron ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 3 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.IRON_INGOT, plugin.getConfig().getInt("iron.2")));
                    }
                    //Check if the fortune level is 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                        //Make the iron ore drop 4 iron ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 4 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.IRON_INGOT, plugin.getConfig().getInt("iron.3")));
                    }
                    //Check if fortune level is more than 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(org.bukkit.enchantments.Enchantment.LOOT_BONUS_BLOCKS) > 3) {
                        //Make the iron ore drop 5 iron ingots
                        e.getBlock().setType(org.bukkit.Material.AIR);
                        //Drop 5 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.IRON_INGOT, plugin.getConfig().getInt("iron.4")));
                    }
                }
            } else {
                //Make the iron ore drop 1 iron ingot
                e.getBlock().setType(org.bukkit.Material.AIR);
                //Drop iron ingot with amount from config
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(org.bukkit.Material.IRON_INGOT, plugin.getConfig().getInt("iron.normal")));
            }
        }
    }
}
