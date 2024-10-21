package fr.xlan.montrehub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        ItemStack montre = new ItemStack(Material.CLOCK);
        ItemMeta montreMeta = montre.getItemMeta();
        if (montreMeta != null) {
            montreMeta.setDisplayName("§bCarte du Monde");
            montreMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
            montreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON);
            montre.setItemMeta(montreMeta);
        }
        player.getInventory().setItem(4, montre);
    }

    @EventHandler
    public void onPlayerClicking(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null && item.getType() == Material.CLOCK && item.getItemMeta().getDisplayName().equals("§bCarte du Monde")) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Inventory menumonde = Bukkit.createInventory(null, 27, "§bCarte du Monde");

                ItemStack creatif = new ItemStack(Material.COMMAND_BLOCK);
                ItemMeta creatifMeta = creatif.getItemMeta();
                if (creatifMeta != null) {
                    creatifMeta.setDisplayName("§aCréatif");
                    creatifMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
                    creatifMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
                    creatif.setItemMeta(creatifMeta);
                }

                ItemStack hub = new ItemStack(Material.BEACON);
                ItemMeta hubMeta = hub.getItemMeta();
                if (hubMeta != null) {
                    hubMeta.setDisplayName("§6Hub");
                    hubMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
                    hubMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
                    hub.setItemMeta(hubMeta);
                }

                ItemStack survie = new ItemStack(Material.IRON_PICKAXE);
                ItemMeta survieMeta = survie.getItemMeta();
                if (survieMeta != null) {
                    survieMeta.setDisplayName("§bSurvie");
                    survieMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
                    survieMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
                    survie.setItemMeta(survieMeta);
                }

                ItemStack duel = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta duelMeta = duel.getItemMeta();
                if (duelMeta != null) {
                    duelMeta.setDisplayName("§4Duel");
                    duelMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
                    duelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
                    duel.setItemMeta(duelMeta);
                }

                menumonde.setItem(4, survie);
                menumonde.setItem(12, creatif);
                menumonde.setItem(14, duel);
                menumonde.setItem(22, hub);

                player.openInventory(menumonde);
            }
        }
    }
}
