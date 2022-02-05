package me.vrom.cutclean.events;

import me.vrom.cutclean.CutClean;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class IronMine implements Listener {
    
    private final CutClean plugin;
    public IronMine(CutClean instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.IRON_ORE)) {
            //Check if the item in hand is a pickaxe has fortune
            if (e.getPlayer().getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
                //Check if the player has permission cutclean.ironmine
                if (e.getPlayer().hasPermission("cutclean.ironmine")) {
                    //Check if the fortune level is 1
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                        //Make the iron ore drop 2 iron ingots
                        e.getBlock().setType(Material.AIR);
                        //Drop 2 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.1")));
                    }
                    //Check if the fortune level is 2
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                        //Make the iron ore drop 3 iron ingots
                        e.getBlock().setType(Material.AIR);
                        //Drop 3 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.2")));
                    }
                    //Check if the fortune level is 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                        //Make the iron ore drop 4 iron ingots
                        e.getBlock().setType(Material.AIR);
                        //Drop 4 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.3")));
                    }
                    //Check if fortune level is more than 3
                    if (e.getPlayer().getInventory().getItemInHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) > 3) {
                        //Make the iron ore drop 5 iron ingots
                        e.getBlock().setType(Material.AIR);
                        //Drop 5 iron ingots
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.4")));
                    }
                }
            } else {
                //Make the iron ore drop 1 iron ingot
                e.getBlock().setType(Material.AIR);
                //Drop iron ingot with amount from config
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.normal")));
            }
        }
    }
}
