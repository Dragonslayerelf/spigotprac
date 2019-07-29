package com.dragonslayerelf.spigottesting.spigottesting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("healme")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(args.length<1) {
                    player.sendMessage(ChatColor.RED + "Please include how much you are healing by.");
                }
                else if(args.length==1)
                {
                    try {
                        double phealth = player.getHealth();
                        double addHealth = Double.parseDouble(args[0]);
                        if(phealth + addHealth >= player.getMaxHealth())
                            player.setHealth(player.getMaxHealth());
                        else {
                            player.setHealth(phealth + addHealth);
                        }
                    } catch(NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Please use a damn number!!!!");
                        return true;
                    }
                }
            }
            else {
                sender.sendMessage("Can't use, not player apparently.");
            }

        }
        if(command.getName().equalsIgnoreCase("setRace")) {
            if(sender instanceof Player)
            {
                Player player = (Player) sender;
                if(args.length<1) {
                    player.sendMessage(ChatColor.RED + "Please specify race.");
                }
                else if(args.length==1) {
                    if(args[0].equals("orc"))
                    {
                        player.sendMessage("Setting race to: Orc");
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(5);
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.2);
                        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(20);
                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                    }
                    else if(args[0].equals("elf"))
                    {
                        player.sendMessage("Setting race to: Elf");
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.4);
                        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0);
                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(38);
                    }
                    else if(args[0].equals("dwarf")) {
                        player.sendMessage("Setting race to: Dwarf");
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(3);
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.15);
                        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(50);
                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(48);
                    }
                    else if(args[0].equals("human")){
                        player.sendMessage("Setting race to: Human");
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
                        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(.2);
                        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0);
                        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                    }
                    else
                    {
                        player.sendMessage("Not a race! Races are: orc, elf, dwarf, human");
                    }
                }
            }

        }
        else {
            sender.sendMessage("Can't use, not player apparently.");
        }
        if(command.getName().equalsIgnoreCase("getLoredItem")) {
            if(sender instanceof Player) {
                ItemStack item = ItemSmith.makeItem(Material.IRON_AXE, "Battleaxe", "A heavy battle axe", 1);
                Player player = (Player) sender;
                player.getInventory().addItem(item);
            }
        }
        return true;
    }
}
