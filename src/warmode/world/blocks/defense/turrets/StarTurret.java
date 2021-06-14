package warmode.world.blocks.defense.turrets;

import mindustry.entities.bullet.BulletType;
import arc.*;
import arc.math.*;
import arc.math.geom.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import static mindustry.Vars.*;

public class StarTurret extends HurricaneTurret{
  public Cons<TurretBuild> drawer = tile -> Draw.rect(region, tile.x + tr2.x, tile.y + tr2.y, 0);
  public Cons<TurretBuild> heatDrawer = tile -> {
      if(tile.heat <= 0.00001f) return;

      Draw.color(heatColor, tile.heat);
      Draw.blend(Blending.additive);
      Draw.rect(heatRegion, tile.x + tr2.x, tile.y + tr2.y, 0);
      Draw.blend();
      Draw.color();
  };
  public StarTurret(String name){
    super(name);
  }
  public class StarTurretBuild extends HurricaneTurret.HurricaneTurretBuild{
    protected float rotate = 0;
    public void draw(){
      Draw.rect(baseRegion, x, y);
      Draw.color();

      Draw.z(Layer.turret);

      tr2.trns(0, 0);

      Drawf.shadow(region, x - (size / 2f), y - (size / 2f), 0);
      drawer.get(this);

      if(heatRegion != Core.atlas.find("error")){
          heatDrawer.get(this);
      }
    }
    protected void turnToTarget(float targetRot){
      if(rotate == 0 ? rotation <= rotate : rotation >= rotate){
        rotate = rotate == 0 ? 180 : 0;
        rotateSpeed = -rotateSpeed;
      }
      rotation+=rotateSpeed;
    }
    protected void shoot(BulletType type){
      //when charging is enabled, use the charge shoot pattern
      if(chargeTime > 0){
          useAmmo();

          tr.trns(rotation, size * tilesize / 2f);
          chargeBeginEffect.at(x + tr.x, y + tr.y, rotation);
          chargeSound.at(x + tr.x, y + tr.y, 1);

          for(int i = 0; i < chargeEffects; i++){
              Time.run(Mathf.random(chargeMaxDelay), () -> {
                  if(!isValid()) return;
                  tr.trns(rotation, size * tilesize / 2f);
                  chargeEffect.at(x + tr.x, y + tr.y, rotation);
              });
          }

          charging = true;

          Time.run(chargeTime, () -> {
              if(!isValid()) return;
              tr.trns(rotation, size * tilesize / 2f);
              recoil = recoilAmount;
              heat = 1f;
              bullet(type, rotation + Mathf.range(inaccuracy));
              effects();
              charging = false;
          });

          //when burst spacing is enabled, use the burst pattern
      }else if(burstSpacing > 0.0001f){
          for(int i = 0; i < shots; i++){
              Time.run(burstSpacing * i, () -> {
                  if(!isValid() || !hasAmmo()) return;

                  recoil = recoilAmount;

                  tr.trns(rotation, size * tilesize / 2f, Mathf.range(xRand));
                  bullet(type, rotation + Mathf.range(inaccuracy));
                  effects();
                  useAmmo();
                  recoil = recoilAmount;
                  heat = 1f;
              });
          }

      }else{
        spread = 360f / shots;
        for(int i = 1; i <= shots; i++){
          tr.trns(spread * i + shiftRotation, (Mathf.sin(45) * (size * tilesize / 2f)));
          bullet(type, spread * i + rotation + shiftRotation);
          effects();
        }
        turnToTarget(0f);

        shotCounter++;

        heat = 1f;
        useAmmo();
      }
    }
  }
}
