package com.dragonslayerelf.spigottesting.spigottesting;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemSmith {
    public static ItemStack makeItem(Material m, String name, String description, int amt) {
        ItemStack item = new ItemStack(m, amt);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(description);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
