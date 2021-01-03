package warmode.content;

import arc.graphics.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;

public class WarBullets implements ContentList {
    public static BulletType bronzeAirDefense, titanitAirDefense,
    bronzeFireworks, titanitFireworks, plastaniumFireworks, surgeAlloyFireworks,
    bronzeStorm, copperStorm,
    bronzeBronzeTurret, copperBronzeTurret;
    @Override
    public void load(){
        bronzeAirDefense = new BasicBulletType(25f, 100){{
            lifetime = 14f;
            width = 3f;
            height = 5f;
            inaccuracy = 2f;
            ammoMultiplier = 2f;
            frontColor = Color.valueOf("ffdab9");
            backColor = Color.valueOf("AF8A69");
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
        }};
        titanitAirDefense = new BasicBulletType(20f, 200){{
            reloadMultiplier = 0.6f;
            lifetime = 17f;
            width = 3f;
            height = 5f;
            frontColor = Color.valueOf("276468");
            backColor = Color.valueOf("2A5C60");
        }};
        titanitFireworks = new MissileBulletType(2f, 150){{
            lifetime = 100f;
            reloadMultiplier = 0.9f;
            width = 1f;
            height = 3f;
            ammoMultiplier = 2f;
            splashDamageRadius = 15f;
            splashDamage = 600;
            fragBullets = 5;
            fragBullet = new BasicBulletType(1f, 50){{
                lifetime = 20f;
            }};
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            backColor = Color.valueOf("00EEFF");
            frontColor = Color.valueOf("A7F9FF");
        }};
        plastaniumFireworks = new MissileBulletType(4f, 150){{
            lifetime = 50f;
            width = 1f;
            height = 3f;
            ammoMultiplier = 1f;
            reloadMultiplier = 1.5f;

            fragBullets = 10;
            fragBullet = new BasicBulletType(2f, 25){{
              lifetime = 10f;
            }};

            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            backColor = Color.valueOf("00FF74");
            frontColor = Color.valueOf("7BFFB7");
        }};
        surgeAlloyFireworks = new MissileBulletType(4f, 500){{
            lifetime = 50f;
            ammoMultiplier = 1f;
            reloadMultiplier = 1f;
            width = 1f;
            height = 3f;
            
            fragBullets = 10;
            fragBullet = new BasicBulletType(2f, 130){{
                lifetime = 10f;
            }};
            
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            backColor = Color.valueOf("FFD800");
            frontColor = Color.valueOf("FFEC83");

            status = StatusEffects.burning;
            statusDuration = 60f;
        }};
        bronzeFireworks = new MissileBulletType(5f, 100){{
            lifetime = 40f;
            ammoMultiplier = 1f;
            reloadMultiplier = 1f;
            inaccuracy = 3f;
            width = 1f;
            height = 3f;

            fragBullets = 10;
            fragBullet = new BasicBulletType(2.5f, 20){{
                lifetime = 20f;
            }};
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            frontColor = Color.valueOf("FFE5CD");
            backColor = Color.valueOf("FF7A00");
        }};
        bronzeStorm = new BasicBulletType(6f, 10){{
            lifetime = 33f;
            reloadMultiplier = 0.1f;
            width = 7f;
            height = 9f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;

            ammoMultiplier = 1f;
            backColor = Color.valueOf("af8A69");
            frontColor = Color.valueOf("ffdab9");
        }};


        copperStorm = new BasicBulletType(10f, 1){{
            lifetime = 20f;
            width = 5f;
            height = 9f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;

            ammoMultiplier = 2f;
            backColor = Color.valueOf("ffd900");
            frontColor = Color.valueOf("ffd900");
        }};
        bronzeBronzeTurret = new BasicBulletType(1f, 15){{
            lifetime = 100f;
            reloadMultiplier = 1f;
            width = 7f;
            height = 9f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            
            ammoMultiplier = 2f;
            backColor = Color.valueOf("AF8A69");
            frontColor = Color.valueOf("ffdab9");
        }};
        copperBronzeTurret = new BasicBulletType(2f, 10){{
            lifetime = 50f;
            reloadMultiplier = 1.5f;
            width = 5f;
            height = 9f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            
            ammoMultiplier = 2f;
            backColor = Color.valueOf("FFBE00");
            frontColor = Color.valueOf("FFBE00");
        }};
    }
}