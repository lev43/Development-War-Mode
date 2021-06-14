package warmode.content;

import warmode.ai.*;

import arc.graphics.*;
import arc.struct.*;
import mindustry.ai.types.*;
import mindustry.ctype.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.ai.types.*;

import static mindustry.Vars.*;


public class WarUnits implements ContentList{
  public static UnitType fighterT1, fighterT2, fighterT3, fighterT4;
  @Override
    public void load(){
      fighterT1 = new UnitType("fighter-t1"){{
        constructor = UnitEntity::create;
        defaultController = () -> new FighterAI();
        targetFlag = BlockFlag.core;
        
        flying = true;
        faceTarget = false;
        circleTarget = true;
        
        health = 230;
        speed = 4f;
        range = 9999f;
        //maxRange = -1f;
        hitSize = 4f;
        
        rotateSpeed = 7f;
        baseRotateSpeed = 7f;
        commandLimit = 0;
        
        accel = 0.01f;
        drag = 0.008f;

        engineOffset = 5f;
        engineSize = 0.8f;

        weapons.add(new Weapon(){{
          alternate = false;
          
          reload = 10f;
          
          x = 0f;
          y = 0f;
          
          bullet = new BasicBulletType(2f, 30){{
            lifetime = 50f;
            width = 4f;
            height = 4f;
          }};
          shootSound = Sounds.shoot;
        }});
      }};
      fighterT2 = new UnitType("fighter-t2"){{
        constructor = UnitEntity::create;
        defaultController = () -> new FighterAI();
        targetFlag = BlockFlag.core;
        
        flying = true;
        faceTarget = false;
        circleTarget = true;
        
        health = 450;
        speed = 6f;
        range = 9999f;
        hitSize = 10f;
        
        rotateSpeed = 6f;
        baseRotateSpeed = 6f;
        commandLimit = 3;
        
        accel = 0.05f;
        drag = 0.005f;

        engineOffset = 8f;
        engineSize = 2f;

        weapons.add(
          new Weapon(){{
            alternate = false;
            
            reload = 5f;
            
            x = 5f;
            y = 0f;
            
            bullet = new BasicBulletType(4f, 60){{
              lifetime = 50f;
            
              width = 5f;
              height = 5f;
            }};
            shootSound = Sounds.shoot;
          }}
        );
      }};
      fighterT3 = new UnitType("fighter-t3"){
        {
          constructor = UnitEntity::create;
          defaultController = () -> new FighterAI();
          targetFlag = BlockFlag.core;
          
          flying = true;
          faceTarget = false;
          circleTarget = true;
          
          health = 670;
          speed = 7f;
          range = 9999f;
          hitSize = 17f;
          
          rotateSpeed = 7f;
          baseRotateSpeed = 7f;
          commandLimit = 6;
          
          accel = 0.09f;
          drag = 0.006f;

          engineOffset = 10f;
          engineSize = 2f;

          weapons.add(
            new Weapon("gun-1"){{
                top = true;
                alternate = false;
                
                reload = 3f;
                
                x = 7f;
                y = 2f;
                
                bullet = new BasicBulletType(5f, 90){{
                  lifetime = 40f;
                
                  width = 6f;
                  height = 6f;
                }};
                shootSound = Sounds.shoot;
              }}
          );
        }
          //Object data = new Object();
          //Fx.artilleryTrail.create(Fx.artilleryTrail, 0f, 0f, unit.rotation(), Color.valueOf("FFFFFF"), data);
      };
      fighterT4 = new UnitType("fighter-t4"){
        {
          constructor = UnitEntity::create;
          defaultController = () -> new FighterAI();
          targetFlag = BlockFlag.core;
          
          flying = true;
          faceTarget = false;
          circleTarget = true;
          
          health = 2300;
          speed = 9f;
          range = 9999f;
          hitSize = 30f;
          
          rotateSpeed = 9f;
          baseRotateSpeed = 9f;
          commandLimit = 8;
          
          accel = 0.08f;
          drag = 0.01f;

          engineOffset = 20f;
          engineSize = 4f;

          weapons.add(
            new Weapon(){{
              top = true;
              alternate = false;
              ignoreRotation = true;
              
              reload = 1f;
              
              x = 15f;
              y = 5f;
              
              bullet = new BasicBulletType(6f, 130){{
                lifetime = 30f;
              
                width = 6f;
                height = 8f;
              }};
              shootSound = Sounds.shoot;
            }},
            new Weapon(){{
              top = true;
              alternate = false;
              ignoreRotation = true;
              
              reload = 1f;
              
              x = 20f;
              y = 3f;
              
              bullet = new BasicBulletType(6f, 130){{
                lifetime = 30f;
              
                width = 6f;
                height = 8f;
              }};
              shootSound = Sounds.shoot;
            }},
            new Weapon(){{
              top = true;
              alternate = false;
              ignoreRotation = true;
              
              reload = 30f;
              
              x = 10f;
              y = 0f;
              
              bullet = new MissileBulletType(2f, 200){{
                lifetime = 80f;
              
                width = 8f;
                height = 10f;

                splashDamageRadius = 50f;
                splashDamage = 300f;
              }};
              shootSound = Sounds.shoot;
            }}
          );
        }
      };
    }
}