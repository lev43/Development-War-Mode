package warmode.world.blocks.defense.turrets;

import arc.math.*;
import arc.math.geom.*;
import mindustry.entities.bullet.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;

import arc.*;
import arc.audio.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.core.*;
import mindustry.entities.Units.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.blocks.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class VolleyTurret extends ItemTurret {
  public float DBT = 1f; //Distance between trunks
  public VolleyTurret(String name){
    super(name);
  }
  public class VolleyTurretBuild extends ItemTurret.ItemTurretBuild{
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
        for(int i = 1; i <= shots; i++){
          tr.trns(rotation, 0, ((float)i/shots)*DBT-size * tilesize / 2 / (DBT/11));
          bullet(type, rotation);
          effects();
        }

        shotCounter++;

        heat = 1f;
        useAmmo();
      }
    }
  }
}