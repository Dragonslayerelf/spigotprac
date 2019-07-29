package com.dragonslayerelf.spigottesting.spigottesting;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;
import org.bukkit.inventory.meta.ItemMeta;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

public class EventClass implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == 20)
            event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
        Block block = event.getBlock();
        event.getPlayer().sendMessage("You broke " + block.getType());
        if(block.getType().equals(Material.IRON_ORE))
        {
            ItemStack itemStack = new ItemStack(Material.IRON_BARS, 9);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(ChatColor.AQUA + "Copper");
            List<String> lore = new ArrayList<>();
            lore.add("This is an ore of copper.");
            lore.add("Workability: 1");
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
            block.getDrops().clear();
            block.getDrops().add(itemStack);
        }

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        Block block = event.getBlock();
        event.getPlayer().sendMessage("You placed " + block.getType());
        if(block.getType().equals(Material.TNT))
        {
            event.getPlayer().sendMessage("BOOM!");
            Location loc = block.getLocation();
            loc.setY(loc.getY() + 1);
            event.getPlayer().getWorld().createExplosion(loc, 1);
        }
    }
    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        if(message.contains("This")){
            message.replaceAll("This", "That");
        }
    }
}
