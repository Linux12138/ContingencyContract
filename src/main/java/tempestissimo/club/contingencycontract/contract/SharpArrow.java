package tempestissimo.club.contingencycontract.contract;

import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import tempestissimo.club.contingencycontract.ContingencyContract;

public class SharpArrow extends Contract implements Listener {
    public SharpArrow(Configuration config, ContingencyContract plugin) {
        super("SharpArrow", config, plugin);
    }

    @EventHandler
    public void onShootArrow(EntityShootBowEvent e){
        if (!plugin.ctrl.gameIsOn){
            return;
        }
        if (this.selectedIndex<0)
            return;
        Entity shooter = e.getEntity();
        if (shooter.getType().equals(EntityType.SKELETON)){
            Skeleton skeleton = (Skeleton) shooter;
            Entity projectile = e.getProjectile();
            Double baseMoveValue = skeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue()*(1+this.levelColumnZero.get(this.selectedIndex)/100);
            skeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(baseMoveValue);
            if (projectile.getType().equals(EntityType.ARROW)){
                Arrow arrow = (Arrow) projectile;
                arrow.setDamage(arrow.getDamage()*(1+this.levelColumnOne.get(this.selectedIndex)/100));
                arrow.setVisualFire(true);
            }
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
