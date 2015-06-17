/*
 * Copyright 2014 Avery.
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

import org.bukkit.entity.Entity;

/**
 *
 * @author Avery
 */
public class EntityVectorToEntityTask implements Runnable{
    private Entity source;
    private Entity target;
    private double speed;
    private double stop;
    public EntityVectorToEntityTask(Entity sourceentity, Entity targetentity, double approachspeed, double stopdistance){
        source = sourceentity;
        target = targetentity;
        speed = approachspeed;
        stop = stopdistance;
    }
    
    @Override
    public void run(){
        double dist = source.getLocation().distance(target.getLocation());
        double tspeed = Math.min(dist, speed);
        
    }
}
