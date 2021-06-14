package warmode.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;
import warmode.entities.bullet.*;

public class WarBullets implements ContentList {
    public static BulletType bronzeAirDefense, titanitAirDefense,//Air defense
    titanitCalm, bronzeCalm,//Calm
    bronzeFireworks, titanitFireworks, plastaniumFireworks, surgeAlloyFireworks,//Fireworks
    bronzeStorm, copperStorm,//Storm
    plastaniumAcid,//Acid
    titanitMortar, thoriumMortar,//Mortar
    titanitVolcano, thoriumVolcano,//Volcano
    titanitCudo, bronzeCudo,//Cudo
    coalFlamethrower, pyratiteFlamethrower,//Flamethrower
    titanitMachineGun,//Machine gun
    bronzeRoseHip, titanitRoseHip, leadRoseHip,//Rose hip
    titanitBastion, surgeAlloyBastion, thoriumBastion,//Bastion
    bronzeBronzeTurret, copperBronzeTurret,//Bronze turret
    bronzeLargeBronzeTurret, copperLargeBronzeTurret,//Large bronze turret
    titanitDragon, plastaniumDragon, surgeAlloyDragon,//Dragon
    titaniumHurricane, plastaniumHurricane,//Hurricane
    copperMultiTurret, leadMultiTurret, scrapMultiTurret, titaniumMultiTurret, graphiteMultiTurret,//Multi turret
    surgeAlloyStar,//Star
    bronzeTrampPilot, copperTrampPilot,//Tramp pilot
    sporePodVeil, sandVeil,//Veil
    titanitVolley, surgeAlloyVolley,//Volley
    titanitShocking, plastaniumShocking,//Shocking
    titanitArmorPiercingSniper, plastaniumArmorPiercingSniper,//Armor piercing sniper
    bronzeSniper, titanitSniper, //Sniper
    surgeAlloyStarSniper, titanitStarSniper,
    waterBullet, slagBullet, cryofluidBullet, oilBullet,//Liquid bullet

    projectOmegaLaser;//Project Omega
    @Override
    public void load(){
        //Air defense
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
        //Calm
            titanitCalm = new MissileBulletType(3f, 350){{
                lifetime = 100f;
                width = 3f;
                height = 5f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                splashDamageRadius = 15f;
                splashDamage = 50f;
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
            }};
            bronzeCalm = new MissileBulletType(3f, 250){{
                lifetime = 100f;
                width = 3f;
                height = 5f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                backColor = Color.valueOf("AF8A69");
                frontColor = Color.valueOf("ffdab9");
                splashDamageRadius = 20f;
                splashDamage = 35f;
            }};
        //Fireforks
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

        //Storm
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

        //Acid
            plastaniumAcid = new ArtilleryBulletType(3f, 50){{
                lifetime = 66.6666667f;
                splashDamageRadius = 10f;
                splashDamage = 40f;
                fragBullets = 5;
                fragBullet = new ArtilleryBulletType(1f, 50){{
                    lifetime = 5;
                    fragBullets = 2;
                    splashDamageRadius = 10;
                    splashDamage = 40;
                    fragBullet = new ArtilleryBulletType(1f, 50){{
                        lifetime = 5;
                        splashDamageRadius = 5;
                        splashDamage = 40;
                    }};
                }};
                reloadMultiplier = 1.0f;
                width = 10f;
                height = 10f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                ammoMultiplier = 1f;
                frontColor = Color.valueOf("62A222");
                backColor = Color.valueOf("468B00");
            }};

        //Mortar
            titanitMortar = new ArtilleryBulletType(5f, 660){{
                lifetime = 100f;
                width = 10f;
                height = 10f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
                splashDamageRadius = 50f;
                splashDamage = 600f;
            }};
            thoriumMortar = new ArtilleryBulletType(5f, 220){{
                lifetime = 100f;
                width = 10f;
                height = 10f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                frontColor = Color.valueOf("C73BA0");
                backColor = Color.valueOf("8F2271");
                splashDamageRadius = 50f;
                splashDamage = 800f;
            }};

        //Volcano
            titanitVolcano = new ArtilleryBulletType(2f, 720){{
            lifetime = 250f;
            width = 10f;
            height = 10f;
            status = StatusEffects.burning;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            fragBullets = 8;
            fragBullet = new ArtilleryBulletType(2.5f, 20){{
                width = 5f;
                height = 5f;
                lifetime = 20f;
                splashDamageRadius = 5f;
                splashDamage = 5f;
                status = StatusEffects.burning;
            }};
            splashDamageRadius = 50f;
            splashDamage = 600f;
            }};
            thoriumVolcano = new ArtilleryBulletType(2f, 440){{
            lifetime = 250f;
            fragBullets = 10;
            fragBullet = new ArtilleryBulletType(3f, 15){{
                width = 5f;
                height = 5f;
                lifetime = 20f;
                splashDamageRadius = 5f;
                splashDamage = 5f;
                status = StatusEffects.burning;
            }};
            width = 10f;
            height = 10f;
            status = StatusEffects.burning;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            splashDamageRadius = 50f;
            splashDamage = 800f;
            }};

        //Cudo
            titanitCudo = new BasicBulletType(5f, 45){{
                reloadMultiplier = 0.8f;
                ammoMultiplier = 3f;
                lifetime = 30f;
                inaccuracy = 5f;
                knockback = 30f;
                width = 4f;
                height = 5f;
                frontColor = Color.valueOf("276468");
                backColor = Color.valueOf("2A5C60");
            }};
            bronzeCudo = new BasicBulletType(5f, 15){{
                ammoMultiplier = 4f;
                lifetime = 30f;
                inaccuracy = 5f;
                knockback = 30f;
                width = 4f;
                height = 5f;
                frontColor = Color.valueOf("ffdab9");
                backColor = Color.valueOf("AF8A69");
            }};

        //Flamethrower
            coalFlamethrower = new BasicBulletType(3f, 5){{
                lifetime = 25f;
                width = 10f;
                height = 10f;
                shootEffect = Fx.shootPyraFlame;
                smokeEffect = Fx.fireSmoke;
                
                backColor = Color.valueOf("FFA200");
                frontColor = Color.valueOf("FFA200");
                status = StatusEffects.burning;
            }};
            pyratiteFlamethrower = new BasicBulletType(2f, 15){{
                lifetime = 40f;
                width = 10f;
                height = 10f;
                shootEffect = Fx.shootPyraFlame;
                smokeEffect = Fx.fireSmoke;
                
                backColor = Color.valueOf("FFA200");
                frontColor = Color.valueOf("FFA200");
                status = StatusEffects.burning;
            }};

        //Machine gun
            titanitMachineGun = new BasicBulletType(10f, 55){{
                ammoMultiplier = 2f;
                lifetime = 22.5f;
                inaccuracy = 6f;
                knockback = 4f;
                width = 5f;
                height = 6f;
                frontColor = Color.valueOf("276468");
                backColor = Color.valueOf("2A5C60");
            }};

        //Rose hip
            bronzeRoseHip = new BasicBulletType(1.5f, 30){{
                lifetime = 46f;
                width = 3f;
                height = 5f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                            
                backColor = Color.valueOf("AF8A69");
                frontColor = Color.valueOf("ffdab9");
            }};
            leadRoseHip = new BasicBulletType(1.5f, 15){{
                lifetime = 46;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                width = 3f;
                height = 5f;
                
                backColor = Color.valueOf("6998D8");
                frontColor = Color.valueOf("6998D8");
            }};
            titanitRoseHip = new BasicBulletType(3f, 70){{
                lifetime = 40f;
                width = 3f;
                height = 5f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;

                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
            }};

        //Bastion
            titanitBastion = new MissileBulletType(2f, 320){{
                lifetime = 110f;
                width = 8f;
                height = 8f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                ammoMultiplier = 2f;
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");

                splashDamageRadius = 5f;
                splashDamage = 50f;
            }};
            surgeAlloyBastion = new MissileBulletType(2f, 550){{
              lifetime = 110f;
              width = 8f;
              height = 8f;
              status = StatusEffects.burning;
              shootEffect = Fx.none;
              smokeEffect = Fx.none;
              backColor = Color.valueOf("CAB14E");
              frontColor = Color.valueOf("CAB14E");

              splashDamageRadius = 5f;
              splashDamage = 120f;
            }};
            thoriumBastion = new MissileBulletType(2f, 100){{
              lifetime = 110f;
              width = 8f;
              height = 8f;
              shootEffect = Fx.none; //shootBig
              smokeEffect = Fx.none; //shootBigSmoke
              backColor = Color.valueOf("A40089");
              frontColor = Color.valueOf("C711A9");

              splashDamageRadius = 5f;
              splashDamage = 20f;
            }};
        //Bronze turret
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

        //Large bronze turret
            bronzeLargeBronzeTurret = new BasicBulletType(6f, 55){{
                lifetime = 16f;
                reloadMultiplier = 0.5f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                ammoMultiplier = 2f;
                backColor = Color.valueOf("AF8A69");
                frontColor = Color.valueOf("ffdab9");
            }};
            copperLargeBronzeTurret = new BasicBulletType(6f, 20){{
                lifetime = 16f;
                width = 5f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                ammoMultiplier = 2f;
                backColor = Color.valueOf("FFBA00");
                frontColor = Color.valueOf("FFBA00");
            }};

        //Dragon
            titanitDragon = new MissileBulletType(2f, 150){{
                lifetime = 200f;
                reloadMultiplier = 0.9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 3f;
                height = 5f;
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
                ammoMultiplier = 2f;
                splashDamageRadius = 15f;
                splashDamage = 600f;
            }};
            plastaniumDragon = new MissileBulletType(4f, 150){{
                lifetime = 100f;
                reloadMultiplier = 1.5f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("00FF55");
                frontColor = Color.valueOf("00FF55");
            }};
            surgeAlloyDragon = new MissileBulletType(4f, 300){{
                lifetime = 100f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("FFD800");
                frontColor = Color.valueOf("FFD800");
                status = StatusEffects.burning;
            }};
        //Hurricane
            titaniumHurricane = new BasicBulletType(1f, 120){{
                lifetime = 300f;
                width = 9f;
                height = 9f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                fragBullets = 2;
                fragBullet = new BasicBulletType(0.5f, 60){{
                    lifetime = 30f;
                    width = 4f;
                    height = 4f;
                    
                    backColor = Color.valueOf("BFE8F4");
                    frontColor = Color.valueOf("99CAD8");
                }};
                backColor = Color.valueOf("BFE8F4");
                frontColor = Color.valueOf("99CAD8");
            }};
            plastaniumHurricane = new BasicBulletType(1f, 230){{
              lifetime = 300f;
              width = 9f;
              height = 9f;
              shootEffect = Fx.none;
              smokeEffect = Fx.none;
              ammoMultiplier = 2f;
              fragBullets = 4;
              fragBullet = new BasicBulletType(1f, 90){{
                lifetime = 30f;
                width = 4f;
                height = 4f;
                
                backColor = Color.valueOf("92D554");
                frontColor = Color.valueOf("9BED4F");
              }};
              backColor = Color.valueOf("92D554");
              frontColor = Color.valueOf("9BED4F");
            }};
        //Multi turret
            copperMultiTurret = new BasicBulletType(6f, 25){{
                ammoMultiplier = 2f;
                inaccuracy = 5f;
                lifetime = 33.3333f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 7f;
                height = 10f;
                frontColor = Color.valueOf("AA8B32");
                backColor = Color.valueOf("765D15");
            }};
            leadMultiTurret = new BasicBulletType(6f, 25){{
                reloadMultiplier = 2f;
                inaccuracy = 7f;
                lifetime = 33.3333f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 7f;
                height = 10f;
                frontColor = Color.valueOf("6063A7");
                backColor = Color.valueOf("363971");
            }};
            scrapMultiTurret = new BasicBulletType(5.5f, 35){{
                lifetime = 36.3636364f;
                inaccuracy = 5f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 7f;
                height = 10f;
                frontColor = Color.valueOf("8A7155");
                backColor = Color.valueOf("5A4A38");
            }};
            titaniumMultiTurret = new BasicBulletType(4f, 55){{
                lifetime = 50f;
                reloadMultiplier = 0.8f;
                inaccuracy = 1f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 7f;
                height = 10f;
                frontColor = Color.valueOf("306EAD");
                backColor = Color.valueOf("1A4A7C");
            }};
            graphiteMultiTurret = new BasicBulletType(5f, 60){{
                lifetime = 40f;
                fragBullets = 10;
                fragBullet = new BasicBulletType(2f, 25){{
                    lifetime = 60f;
                }};
                inaccuracy = 3f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                width = 7f;
                height = 10f;
                frontColor = Color.valueOf("8FADB7");
                backColor = Color.valueOf("53646A");
            }};
        //Star
            surgeAlloyStar = new BasicBulletType(0.5f, 1650){{
                lifetime = 1000f;
                width = 9f;
                height = 9f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                ammoMultiplier = 4f;
                backColor = Color.valueOf("B19416");
                frontColor = Color.valueOf("FFD10B");
                splashDamageRadius = 20f;
                splashDamage = 100f;
            }};
        //Tramp pilot
            bronzeTrampPilot = new BasicBulletType(5f, 50){{
                lifetime = 30f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                ammoMultiplier = 2f;
                backColor = Color.valueOf("AF8A69");
                frontColor = Color.valueOf("ffdab9");
            }};
            copperTrampPilot = new BasicBulletType(5f, 20){{
                lifetime = 30f;
                reloadMultiplier = 1.5f;
                width = 5f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                ammoMultiplier = 2f;
                backColor = Color.valueOf("FFBE00");
                frontColor = Color.valueOf("FFBE00");
            }};
        //Veil
            sporePodVeil = new BasicBulletType(10f, 45){{
                lifetime = 600f;
                width = 5f;
                height = 5f;
                ammoMultiplier = 10f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                collidesTiles = false;
                backColor = Color.valueOf("8000BF");
                frontColor = Color.valueOf("AB00FF");
            }};
            sandVeil = new BasicBulletType(10f, 25){{
                lifetime = 600f;
                width = 5f;
                height = 5f;
                ammoMultiplier = 20f;
                reloadMultiplier = 10f;
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                collidesTiles = false;
                backColor = Color.valueOf("B09113");
                frontColor = Color.valueOf("E1B918");
            }};
        //Volley
            titanitVolley = new MissileBulletType(3f, 90){{
                lifetime = 130f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                backColor = Color.valueOf("817FE3");
                frontColor = Color.valueOf("276468");
            }};
            surgeAlloyVolley = new MissileBulletType(3f, 150){{
                lifetime = 130f;
                width = 7f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("CAB14E");
                frontColor = Color.valueOf("CAB14E");
                status = StatusEffects.burning;
            }};
        //Sprayer
            waterBullet = new LiquidBulletType(Liquids.water){{
                speed = 2f;
                damage = 15f;
                lifetime = 50f;
                damage = 15f;
                shootEffect = Fx.shootLiquid;
                smokeEffect = Fx.shootSmallSmoke;
                
                status = StatusEffects.wet;
            }};
            slagBullet = new LiquidBulletType(Liquids.slag){{
                speed = 2f;
                damage = 20f;
                lifetime = 50f;
                shootEffect = Fx.shootLiquid;
                smokeEffect = Fx.shootSmallSmoke;
                
                status = StatusEffects.burning;
            }};
            cryofluidBullet = new LiquidBulletType(Liquids.cryofluid){{
                speed = 2f;
                damage = 17;
                lifetime = 50f;
                shootEffect = Fx.shootLiquid;
                smokeEffect = Fx.shootSmallSmoke;
                
                status = StatusEffects.freezing;
            }};
            oilBullet = new LiquidBulletType(Liquids.oil){{
                speed = 2f;
                damage = 10;
                lifetime = 50f;
                shootEffect = Fx.shootLiquid;
                smokeEffect = Fx.shootSmallSmoke;
                
                status = StatusEffects.tarred;
            }};

        //Shocking
            titanitShocking = new BasicBulletType(50f, 5){{
                lifetime = 5f;
                reloadMultiplier = 0.5f;
                inaccuracy = 0f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
                status = StatusEffects.unmoving;
                statusDuration = 9999f;
            }};
            plastaniumShocking = new BasicBulletType(50f, 10){{
                lifetime = 5f;
                reloadMultiplier = 0.5f;
                inaccuracy = 0f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                backColor = Color.valueOf("80FF00");
                frontColor = Color.valueOf("80FF00");
                status = StatusEffects.unmoving;
                statusDuration = 9999f;
            }};
        //Armor piercing sniper
            titanitArmorPiercingSniper = new BasicBulletType(100f, 660){{
                lifetime = 5f;
                reloadMultiplier = 0.5f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
                status = WarStatusEffects.brokenArmor;
                statusDuration = 999999f;
            }};
            plastaniumArmorPiercingSniper = new BasicBulletType(100f, 650){{
                lifetime = 5f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("00FF65");
                frontColor = Color.valueOf("00FF65");
                status = WarStatusEffects.brokenArmor;
                statusDuration = 999999f;
            }};
        //Sniper
            bronzeSniper = new BasicBulletType(50f, 95){{
                lifetime = 10f;
                reloadMultiplier = 0.5f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                backColor = Color.valueOf("AF8A69");
                frontColor = Color.valueOf("ffdab9");
            }};
            titanitSniper = new BasicBulletType(50f, 150){{
                lifetime = 10f;
                reloadMultiplier = 0.5f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                
                backColor = Color.valueOf("2A5C60");
                frontColor = Color.valueOf("276468");
            }};
        //Star sniper
            surgeAlloyStarSniper = new BasicBulletType(100f, 1000){{
                lifetime = 11f;
                reloadMultiplier = 0.5f;
                width = 3f;
                height = 9f;
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootBigSmoke;
                
                backColor = Color.valueOf("FFFFFF");
                frontColor = Color.valueOf("FFFFFF");
                status = StatusEffects.burning;
            }};
            titanitStarSniper = new BasicBulletType(100f, 500){{
              lifetime = 11f;
              reloadMultiplier = 0.5f;
              width = 3f;
              height = 9f;
              shootEffect = Fx.shootBig;
              smokeEffect = Fx.shootBigSmoke;
              
              backColor = Color.valueOf("FFFFFF");
              frontColor = Color.valueOf("FFFFFF");
              status = StatusEffects.freezing;
            }};
        projectOmegaLaser = new BigLaser(10000){{
            hitEffect = Fx.hitMeltdown;
            hitSize = 1800f;
            lifetime = 40f;
            width = 30f;
            oscScl = 2f;
            oscMag = 4f;
            length = 1000f;
            drawSize = 5500f;
            collidesAir = false;
        }};
        //End
    }
}