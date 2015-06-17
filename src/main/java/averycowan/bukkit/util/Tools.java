/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package averycowan.bukkit.util;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Avery Cowan
 */
public abstract class Tools {
    
    public static final String DAMAGE_PERCENT_KEY = "pdamage";
    
    public static ChatColor dyeToChatColor(DyeColor color){
        switch(color){
            case WHITE:
                return ChatColor.WHITE;
            case ORANGE:
                return ChatColor.RED;
            case MAGENTA:
                return ChatColor.LIGHT_PURPLE;
            case LIGHT_BLUE:
                return ChatColor.AQUA;
            case YELLOW:
                return ChatColor.YELLOW;
            case LIME:
                return ChatColor.GREEN;
            case PINK:
                return ChatColor.RED;
            case GRAY:
                return ChatColor.GRAY;
            case SILVER:
                return ChatColor.GRAY;
            case CYAN:
                return ChatColor.AQUA;
            case PURPLE:
                return ChatColor.DARK_PURPLE;
            case BLUE:
                return ChatColor.BLUE;
            case BROWN:
                return ChatColor.BLACK;
            case GREEN:
                return ChatColor.GREEN;
            case RED:
                return ChatColor.RED;
            case BLACK:
                return ChatColor.BLACK;
            default:
                return ChatColor.BLACK;
        }
    }
    
    private static ArrayList<DurabilityTracker> trackers = new ArrayList<DurabilityTracker>();
    
    public static void setDurability(ItemStack item, int value){
        DurabilityTracker t = getTracker(item);
        if(t==null)
            trackers.add(new DurabilityTracker(item, value));
        t.value=value;
    }
    
    public static boolean hasDurability(ItemStack item){
        return getTracker(item)!=null;
    }
    
    static DurabilityTracker getTracker(ItemStack item){
        for(DurabilityTracker t : trackers){
            if(t.stack==item)
                return t;
        }
        return null;
    }
    
    public static int getDurability(ItemStack item){
        DurabilityTracker t = getTracker(item);
        if(t==null)
            return 100 - item.getDurability() * 100 / item.getType().getMaxDurability();
        return t.value;
    }
    
    public static void changeDurability(ItemStack item, int change){
        DurabilityTracker t = getTracker(item);
        if(t==null)
            trackers.add(new DurabilityTracker(item, 100 - item.getDurability() * 100 / item.getType().getMaxDurability() + change));
        else
            t.value+=change;
    }
    
    public static void useDurability(ItemStack item){
        DurabilityTracker t = getTracker(item);
        if(t==null)
            trackers.add(new DurabilityTracker(item, 100 - item.getDurability() * 100 / item.getType().getMaxDurability()));
        else
            t.value=100 - item.getDurability() * 100 / item.getType().getMaxDurability();
    }
    
    public static void updateDurability(ItemStack item){
        DurabilityTracker t = getTracker(item);
        if(t!=null)
            item.setDurability((short) (t.value*item.getType().getMaxDurability()/100));
    }
}

class DurabilityTracker{
    DurabilityTracker(ItemStack i, int v){
        this(i, v, 100);
    }
    DurabilityTracker(ItemStack i, int v, int m){
        stack = i;
        value = v;
        maxvalue = m;
    }
    int value;
    int maxvalue = 100;
    ItemStack stack;
}
