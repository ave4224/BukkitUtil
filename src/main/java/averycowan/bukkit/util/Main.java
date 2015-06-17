/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package averycowan.bukkit.util;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Avery
 */
public class Main extends JavaPlugin{
//    @Override
//    public void onEnable(){
//        getConfig().options().copyDefaults(true);
//        Configuration config = getConfig();
//        config.addDefault("Percent-Damage", Boolean.TRUE);
//        saveConfig();
//        if (config.getBoolean("Percent-Damage")) {
//            getServer().getPluginManager().registerEvents(new Listener(){
//                @EventHandler
//                public void playerInteract(PlayerInteractEvent event){
//                    if(event.getItem().getType()!=Material.AIR && Tools.hasDurabilityByPercentage(event.getItem())){
//                        
//                    }
//                }
//            }, this);
//        }
//    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("speed")) {
            if(args.length == 0)
                return false;
            if(!(sender instanceof Player))
                return true;
            ((Player)sender).setAllowFlight(true);
            ((Player)sender).setFlySpeed(new Float(args[0]));
            return true;
        }
        return false;
    }
}
