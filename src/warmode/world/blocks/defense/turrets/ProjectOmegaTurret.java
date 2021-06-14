package warmode.world.blocks.defense.turrets;

import arc.math.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.entities.bullet.*;

import static mindustry.Vars.*;

public class ProjectOmegaTurret extends ItemTurret{
  public ProjectOmegaTurret(String name){
    super(name);
  }
  public class ProjectOmegaTurretBuild extends ItemTurretBuild{
    protected void bullet(BulletType type, float angle){
      tr.trns(rotation, -(size * tilesize / 3.5f));

      float lifeScl = type.scaleVelocity ? Mathf.clamp(Mathf.dst(x + tr.x, y + tr.y, targetPos.x, targetPos.y) / type.range(), minRange / type.range(), range / type.range()) : 1f;

      type.create(this, team, x + tr.x, y + tr.y, angle, 1f + Mathf.range(velocityInaccuracy), lifeScl);
    }
  }
}
