package warmode.entities.bullet;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import mindustry.game.EventType.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;


public class BigLaser extends ContinuousLaserBulletType{
  public BigLaser(float damage){
    super(damage);
  }
  public void update(Bullet b){
    if(b.timer(1, 5f)){
      Vec2 vec = new Vec2();
      Damage.collideLine(b, b.team, hitEffect, b.x, b.y, b.rotation(), length, largeHit);
      vec.trns(b.rotation(), 0, 11);
      Damage.collideLine(b, b.team, hitEffect, b.x + vec.x, b.y + vec.y, b.rotation(), length, largeHit);
      vec.trns(b.rotation(), 0, -11);
      Damage.collideLine(b, b.team, hitEffect, b.x + vec.x, b.y + vec.y, b.rotation(), length, largeHit);
    }
    if(shake > 0){
        Effect.shake(shake, shake, b);
    }
  }
}