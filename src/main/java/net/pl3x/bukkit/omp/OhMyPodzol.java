package net.pl3x.bukkit.omp;

import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OhMyPodzol extends JavaPlugin {
    @Override
    public void onEnable() {
        new Metrics(this);

        getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onStructureGrow(StructureGrowEvent event) {
                if (event.getSpecies() == TreeType.MEGA_REDWOOD) {
                    event.getBlocks().removeIf(b -> b.getType() == Material.PODZOL);
                }
            }
        }, this);
    }
}
