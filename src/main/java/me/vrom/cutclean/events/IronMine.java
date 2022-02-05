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
            e.getBlock().setType(Material.AIR);

            //Check if the item in hand is a pickaxe has fortune
            if (e.getPlayer().getInventory().getItemInHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
                //Check if the player has permission cutclean.ironmine
                if (e.getPlayer().hasPermission("cutclean.ironmine")) {
                    int enchantmentLevel = e.getPlayer().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    if (enchantmentLevel <= 3) {
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron." + enchantmentLevel)));
                    } else {
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.4")));
                    }
                }
            } else {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, plugin.getConfig().getInt("iron.normal")));
            }
        }
    }
}
