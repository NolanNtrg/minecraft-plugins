package fr.xlan.duelgestionjoueurs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Ajouter un délai pour garantir que le respawn est complètement pris en compte
        new BukkitRunnable() {
            @Override
            public void run() {
                player.setGameMode(GameMode.SPECTATOR);
                kit(player);
            }
        }
                .runTaskLater(Bukkit.getPluginManager().getPlugin("duelgestionjoueurs"), 2L); // 2 ticks de délai

        kit(player);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        // Ajouter un délai pour garantir que le respawn est complètement pris en compte
        new BukkitRunnable() {
            @Override
            public void run() {
                player.setGameMode(GameMode.SPECTATOR);
                kit(player);
            }
        }
                .runTaskLater(Bukkit.getPluginManager().getPlugin("duelgestionjoueurs"), 2L); // 2 ticks de délai

        kit(player);
    }

    public void kit(Player player) {
        player.getInventory().clear();

        Inventory menukit = Bukkit.createInventory(null, 27, "§4Choix du kit");

        ItemStack guerrier = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrierMeta = guerrier.getItemMeta();
        if (guerrierMeta != null) {
            guerrierMeta.setDisplayName("§cGuerrier");
            guerrierMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
            guerrier.setItemMeta(guerrierMeta);
        }

        ItemStack alchimiste = new ItemStack(Material.SPLASH_POTION);
        ItemMeta alchimisteMeta = alchimiste.getItemMeta();
        if (alchimisteMeta != null) {
            alchimisteMeta.setDisplayName("§aAlchimiste");
            alchimisteMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
            alchimiste.setItemMeta(alchimisteMeta);
        }
        ItemStack sniper = new ItemStack(Material.BOW);
        ItemMeta sniperMeta = sniper.getItemMeta();
        if (sniperMeta != null) {
            sniperMeta.setDisplayName("§bSniper");
            sniperMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
            sniper.setItemMeta(sniperMeta);
        }

        ItemStack terroriste = new ItemStack(Material.TNT);
        ItemMeta terroristeMeta = terroriste.getItemMeta();
        if (terroristeMeta != null) {
            terroristeMeta.setDisplayName("§0Terroriste");
            terroristeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
            terroriste.setItemMeta(terroristeMeta);
        }

        menukit.setItem(10, guerrier);
        menukit.setItem(12, alchimiste);
        menukit.setItem(14, sniper);
        menukit.setItem(16, terroriste);

        player.openInventory(menukit);
    }

    @EventHandler
    public void onGuerrierClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§4Choix du kit")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCurrentItem();
            if (item != null && item.getType() == Material.IRON_SWORD && item.getItemMeta().getDisplayName().equals("§cGuerrier")) {
                if (event.isLeftClick()) {
                    event.setCancelled(true);
                    player.closeInventory();
                    player.getInventory().clear();

                    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                    ItemMeta helmetMeta = helmet.getItemMeta();
                    if (helmetMeta != null) {
                        helmetMeta.setUnbreakable(true);
                        helmet.setItemMeta(helmetMeta);
                    }

                    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta chestplateMeta = chestplate.getItemMeta();
                    if (chestplateMeta != null) {
                        chestplateMeta.setUnbreakable(true);
                        chestplate.setItemMeta(chestplateMeta);
                    }

                    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
                    ItemMeta leggingsMeta = leggings.getItemMeta();
                    if (leggingsMeta != null) {
                        leggingsMeta.setUnbreakable(true);
                        leggings.setItemMeta(leggingsMeta);
                    }

                    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
                    ItemMeta bootsMeta = boots.getItemMeta();
                    if (bootsMeta != null) {
                        bootsMeta.setUnbreakable(true);
                        boots.setItemMeta(bootsMeta);
                    }

                    ItemStack shield = new ItemStack(Material.SHIELD);
                    ItemMeta shieldMeta = shield.getItemMeta();
                    if (shieldMeta != null) {
                        shieldMeta.setUnbreakable(true);
                        shield.setItemMeta(shieldMeta);
                    }

                    ItemStack ironsword = new ItemStack(Material.IRON_SWORD);
                    ItemMeta ironswordMeta = ironsword.getItemMeta();
                    if (ironswordMeta != null) {
                        ironswordMeta.setUnbreakable(true);
                        ironsword.setItemMeta(ironswordMeta);
                    }

                    ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 64);
                    ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);

                    player.getInventory().setHeldItemSlot(0);
                    player.getInventory().setHelmet(helmet);
                    player.getInventory().setChestplate(chestplate);
                    player.getInventory().setLeggings(leggings);
                    player.getInventory().setBoots(boots);
                    player.getInventory().setItemInOffHand(shield);
                    player.getInventory().setItem(0, ironsword);
                    player.getInventory().setItem(1, gapple);
                    player.getInventory().setItem(2, steak);

                    Location location = new Location(player.getWorld(), 411, 84, 20);
                    player.teleport(location);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.closeInventory();
                }
            }
        }
    }

    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getDrops().clear();
        String dead = event.getEntity().getDisplayName();
        Player killer = event.getEntity().getKiller();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("test");
            player.sendMessage("§6[BarryLand] §a" + dead + "§b a été tué par §4" + killer.getDisplayName());
        }
    }
}
