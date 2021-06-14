package warmode.world.blocks.defense.turrets;

import mindustry.entities.bullet.BulletType;
import arc.math.*;

public class VeilTurret extends HurricaneTurret{
  public float minDrag=0.01f;
  public float maxDrag=0.5f;
  public VeilTurret(String name){
    super(name);
  }
  public class VeilTurretBuild extends HurricaneTurret.HurricaneTurretBuild{
    protected void bullet(BulletType type, float angle){
      float drag = Mathf.random() + minDrag;
      type.drag = drag > maxDrag ? drag/10 : drag;

      float lifeScl = type.scaleVelocity ? Mathf.clamp(Mathf.dst(x + tr.x, y + tr.y, targetPos.x, targetPos.y) / type.range(), minRange / type.range(), range / type.range()) : 1f;

      type.create(this, team, x + tr.x, y + tr.y, angle, 1f + Mathf.range(velocityInaccuracy), lifeScl);
    }
  }
}