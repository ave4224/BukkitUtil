/*
 * Copyright 2014 Avery Cowan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package averycowan.bukkit.util;


import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Avery Cowan
 */
public class ItemGiveTask implements Runnable{
    private ItemStack s;
    private Player p;
    private int sl;
    
    public ItemGiveTask(Player player, ItemStack itemstack, int slot){
        s = itemstack;
        p = player;
        sl = slot;
    }

    @Override
    public void run() {
        p.getInventory().setItem(sl, s);
    }
}
