package warmode.content;

import arc.util.Log;
import arc.graphics.*;
import arc.graphics.g2d.TextureRegion;
import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.meta.*;
import mindustry.entities.bullet.*;
import mindustry.world.blocks.*;
import warmode.world.blocks.defense.turrets.*;


import static mindustry.type.ItemStack.with;

public class WarBlocks implements ContentList {
  //factory
  public static Block testBlock, factoryOfBronze, factoryOfCryocrystals, factoryOfTitanit,
  //turrets
    //air
      airDefense, calm, fireworks, storm,
    //ground
      //artillery
        acid, mortar, volcano,
      //item turret
        cudo, flamethrower, machineGun, projectOmega, roseHipAlpha, roseHipBeta,
      //power turret
        laserMachineGun, laserTurret,
    //ground air
      //item turret
        bastion, bronzeTurret, largeBronzeTurret, dragon, hurricane, multiTurret, star, trampPilot, veil, volley,
      //liquid turret
        sprayer, stream, 
      //power turret
        hellTurret, teslaTurret,
      //turret effect
        shocking,
      //sniper
        armorPiercingSniper, sniper, starSniper,
  //Units factory
    airFactory, reconstructor1, reconstructor2, reconstructor3,
    
  block;//End
  
  @Override
  public void load() {
    testBlock = new ConstructBlock(2){
      public void updateTile(){
        targetable = !targetable;
      }
      {
        requirements(Category.crafting, with(Items.copper, 1));
    }};
    //Factory
      factoryOfBronze = new GenericSmelter("factory-of-bronze"){{
        requirements(Category.crafting, with(Items.copper, 40, Items.lead, 40));
        outputItem = new ItemStack(WarItems.bronze, 2);
        size = 2;
        hasPower = true;
        craftTime = 60f;
        health = 300;
        updateEffect = Fx.smeltsmoke;
        consumes.items(with(
          Items.lead, 1,
          Items.copper, 2
        ));
        consumes.power(0.5f);
        ambientSound = Sounds.respawning;
        ambientSoundVolume = 0.5f;
      }};
      factoryOfTitanit = new GenericSmelter("factory-of-titanit"){{
        requirements(Category.crafting, with(
          Items.copper, 40, 
          Items.lead, 40, 
          WarItems.bronze, 35, 
          Items.graphite, 35, 
          Items.titanium, 40
        ));
        outputItem = new ItemStack(WarItems.titanit, 2);
        size = 2;
        hasPower = true;
        craftTime = 100f;
        health = 300;
        updateEffect = Fx.smeltsmoke;
        consumes.items(with(
          Items.lead, 2,
          Items.titanium, 2,
          WarItems.bronze, 2
        ));
        consumes.power(4f);
        ambientSound = Sounds.respawning;
        ambientSoundVolume = 0.5f;
      }};
      factoryOfCryocrystals = new GenericCrafter("factory-of-cryocrystals"){{
        requirements(Category.crafting, with(
          Items.copper, 40, 
          Items.lead, 40, 
          WarItems.bronze, 60, 
          Items.silicon, 50, 
          Items.titanium, 30
        ));
        outputItem = new ItemStack(WarItems.cryocrystal, 4);
        size = 2;
        hasPower = true;
        craftTime = 100f;
        health = 300;
        updateEffect = Fx.none;
        consumes.items(with(
          Items.metaglass, 4
        ));
        consumes.power(0.5f);
        consumes.liquid(Liquids.cryofluid, 0.1183333333f);
      }};
    //Turrets
      //Air
        airDefense = new ItemTurret("air-defense"){{
          requirements(Category.turret, with(WarItems.titanit, 90, WarItems.bronze, 80, Items.silicon, 50, Items.lead, 60));

          range = 350f;
          recoilAmount = 1f;
          reloadTime = 10f;
          size = 3;
          health = 1600;
          inaccuracy = 5f;
          rotateSpeed = 3f;
          coolantMultiplier = 0.7f;
          
          targetGround = false;
          
          ammoUseEffect = Fx.casing1;
          ammo(
            WarItems.bronze, WarBullets.bronzeAirDefense,
            WarItems.titanit, WarBullets.titanitAirDefense
          );
        }};
        calm = new HurricaneTurret("calm"){{
          requirements(Category.turret, with(WarItems.titanit, 250, WarItems.bronze, 250, Items.plastanium, 130, Items.lead, 120, Items.silicon, 130));
          size = 3;
          rotateSpeed = 5;
          range = 300f;
          health = 1200;
          reloadTime = 30f;
          //shootSound = missile
          targetGround = false;
          shots = 8;
          coolantMultiplier = 0.7f;
          ammo(
            WarItems.titanit, WarBullets.titanitCalm,
            WarItems.bronze, WarBullets.bronzeCalm
          );
        }};
        fireworks = new ItemTurret("fireworks"){{
          requirements(Category.turret, with(WarItems.bronze, 100, Items.titanium, 60, Items.silicon, 65, Items.lead, 70));
          range = 200f;
          recoilAmount = 1f;
          reloadTime = 60f;
          inaccuracy = 3f;
          rotateSpeed = 1f;
          size = 2;
          health = 1000;
          coolantMultiplier = 0.7f;
          targetGround = false;
          //shootSound = missile
          ammoUseEffect = Fx.casing3;
          ammo(
            WarItems.bronze, WarBullets.bronzeFireworks,
            WarItems.titanit, WarBullets.titanitFireworks,
            Items.plastanium, WarBullets.plastaniumFireworks,
            Items.surgeAlloy, WarBullets.surgeAlloyFireworks
          );
        }};
        storm = new ItemTurret("storm"){{
          requirements(Category.turret, with(WarItems.bronze, 80, Items.copper, 120, Items.silicon, 35, Items.lead, 50));
          health = 400;
          size = 3;
          recoilAmount = 1f;
          reloadTime = 0.1f;
          range = 200f;
          inaccuracy = 1f;
          shots = 5;
          rotateSpeed = 1.5f;
          xRand = 3f;
          spread = 0f;
          coolantMultiplier = 0.7f;
          targetGround = false;
          ammoUseEffect = Fx.casing1;
          ammo(
            WarItems.bronze, WarBullets.bronzeStorm,
            Items.copper, WarBullets.copperStorm
          );
        }};
      //Ground
        //Artillery
          acid = new ItemTurret("acid"){{
            requirements(Category.turret, with(WarItems.bronze, 130, WarItems.titanit, 60, Items.plastanium, 60, Items.silicon, 70));
            health = 3000;
            size = 3;
            recoilAmount = 2f;
            reloadTime = 20f;
            range = 200;
            inaccuracy = 3.0f;
            shots = 1;
            rotateSpeed = 2.0f;
            coolantMultiplier = 0.7f;

            targetAir = false;
            ammoUseEffect = Fx.casing3;
            ammo(
              Items.plastanium, WarBullets.plastaniumAcid
            );
          }};
          mortar = new ItemTurret("mortar"){{
            requirements(Category.turret, with(WarItems.bronze, 70, WarItems.titanit, 190, Items.thorium, 120, Items.plastanium, 150, Items.silicon, 90));
            health = 2500;
            size = 4;
            recoilAmount = 5f;
            reloadTime = 120f;
            range = 500;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.explosionbig;
            targetAir = false;
            inaccuracy = 1f;
            shots = 1;
            rotateSpeed = 0.3f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitMortar,
              Items.thorium, WarBullets.thoriumMortar
            );
          }};
          volcano = new ItemTurret("volcano"){{
            requirements(Category.turret, with(WarItems.bronze, 180, WarItems.titanit, 350, Items.thorium, 390, Items.plastanium, 380, Items.silicon, 230, Items.surgeAlloy, 125));
            health = 4500;
            size = 4;
            range = 500;
            recoilAmount = 5f;
            reloadTime = 180f;
            inaccuracy = 5f;
            rotateSpeed = 2f;
            coolantMultiplier = 0.7f;
            targetAir = false;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.explosionbig;
            ammo(
              WarItems.titanit, WarBullets.titanitVolcano,
              Items.thorium, WarBullets.thoriumVolcano
            );
          }};
        //ItemTurret
          cudo = new ItemTurret("cudo"){{
            requirements(Category.turret, with(WarItems.bronze, 59, WarItems.titanit, 40, Items.lead, 20, Items.graphite, 20));
            health = 1200;
            size = 2;
            range = 150;
            targetAir = false;
            rotateSpeed = 5f;
            shootCone = 5f;
            ammoUseEffect = Fx.casing1;
            shots = 2;
            alternate = true;
            reloadTime = 10f;
            recoilAmount = 0f;
            inaccuracy = 15f;
            coolantMultiplier = 0.7f;
            itemCapacity = 30;
            maxAmmo = 30;
            ammo(
              WarItems.titanit, WarBullets.titanitCudo,
              WarItems.bronze, WarBullets.bronzeCudo
            );
          }};
          flamethrower = new ItemTurret("flamethrower"){{
            requirements(Category.turret, with(WarItems.bronze, 160, Items.copper, 400, Items.lead, 320, Items.metaglass, 30, WarItems.cryocrystal, 15));
            health = 2000;
            size = 3;
            range = 80f;
            ammoUseEffect = Fx.burning;
            //shootSound = WarSounds.flamethrower;
            targetAir = false;
            inaccuracy = 1f;
            shots = 10;
            spread = 1f;
            rotateSpeed = 4f;
            coolantMultiplier = 0.7f;
            ammo(
              Items.coal, WarBullets.coalFlamethrower,
              Items.pyratite, WarBullets.pyratiteFlamethrower
            );
          }};
          machineGun = new ItemTurret("machine-gun"){{
            requirements(Category.turret, with(
              WarItems.titanit, 560, 
              WarItems.bronze, 540, 
              WarItems.cryocrystal, 15, 
              Items.copper, 630, 
              Items.lead, 570, 
              Items.titanium, 350
            ));
            health = 5300;
            size = 4;
            range = 225f;
            targetAir = false;
            shootCone = 5f;
            shootShake = 0.5f;
            ammoUseEffect = Fx.casing3;
            reloadTime = 1f;
            recoilAmount = 1f;
            inaccuracy = 0.1f;
            coolantMultiplier = 0.7f;
            itemCapacity = 500;
            maxAmmo = 250;
            ammo(
              WarItems.titanit, WarBullets.titanitMachineGun
            );
          }};
          projectOmega = new ProjectOmegaTurret("project-omega"){{
            requirements(Category.turret, with(
              WarItems.titanit, 2300, 
              WarItems.bronze, 5600, 
              WarItems.cryocrystal, 3200, 
              Items.surgeAlloy, 640, 
              Items.metaglass, 4300, 
              Items.titanium, 4300,
              Items.plastanium, 4300,
              Items.silicon, 4300,
              Items.graphite, 4300,
              Items.thorium, 5600,
              Items.copper, 7800,
              Items.lead, 7800
            ));
            health = 8800;
            shootShake = 10f;
            size = 16;
            recoilAmount = 3f;
            reloadTime = 180f;
            range = 1000f;
            coolantUsage = 10f;
            cooldown = 0.009f;
            ammoUseEffect = Fx.none;
            inaccuracy = 0f;
            shots = 1;
            shootCone = 1f;
            chargeTime = 60f;
            chargeEffects = 5;
            chargeMaxDelay = 70f;
            chargeSound = Sounds.lasercharge;
            shootSound = Sounds.laserbig;
            targetAir = false;
            ammoPerShot = 100;
            maxAmmo = 100;
            rotateSpeed = 0.03f;
            coolantMultiplier = 1f;
            chargeEffect = WarEffects.chargeProjectOmega;
            ammo(Items.surgeAlloy, WarBullets.projectOmegaLaser);
          }};
          roseHipAlpha = new CircularTurret("rose-hip-alpha"){{
            requirements(Category.turret, with(WarItems.bronze, 90, Items.copper, 85, Items.silicon, 35));
            size = 2;
            range = 70f;
            health = 800;
            reloadTime = 40f;
            inaccuracy = 360f;
            targetAir = false;
            shots = 100;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.bronze, WarBullets.bronzeRoseHip,
              Items.lead, WarBullets.leadRoseHip
            );
          }};
          roseHipBeta = new CircularTurret("rose-hip-beta"){{
            requirements(Category.turret, with(WarItems.bronze, 70, WarItems.titanit, 150, Items.lead, 66, Items.silicon, 55));
            size = 2;
            range = 120f;
            health = 1000;
            reloadTime = 30f;
            inaccuracy = 90f;
            targetAir = false;
            shots = 100;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.bronze, WarBullets.bronzeRoseHip,
              WarItems.titanit, WarBullets.titanitRoseHip,
              Items.lead, WarBullets.leadRoseHip
            );
          }};
        //Power turret
          laserMachineGun = new PowerTurret("laser-machine-gun"){{
            requirements(Category.turret, with(
              WarItems.titanit, 650,
              WarItems.bronze, 1500,
              WarItems.cryocrystal, 50,
              Items.metaglass, 70,
              Items.graphite, 480,
              Items.plastanium, 250
            ));
            health = 2500;
            size = 4;
            recoilAmount = 1f;
            reloadTime = 1f;
            chargeTime = 10f;
            range = 200f;
            chargeMaxDelay = 30f;
            shootType = new LaserBulletType(50){{
              damage = 50;
              hitEffect = Fx.hitLancer;
              despawnEffect = Fx.none;
              hitSize = 8f;
              lifetime = 5f;
              drawSize = 400f;
              collidesAir = false;
            }};
            rotateSpeed = 0.5f;
            targetAir = false;
            powerUse = 25f;
            inaccuracy = 0f;
            chargeEffects = 50;
            coolantMultiplier = 0.7f;
          }};
          laserTurret = new PowerTurret("laser-turret"){{
            requirements(Category.turret, with(
              WarItems.bronze, 140,
              WarItems.cryocrystal, 10,
              Items.graphite, 60,
              Items.plastanium, 20,
              Items.metaglass, 60
            ));
            health = 200;
            size = 3;
            recoilAmount = 0f;
            reloadTime = 50f;
            range = 200f;
            chargeMaxDelay = 30f;
            shootType = new LaserBulletType(10){{
              hitEffect = Fx.hitLancer;
              despawnEffect = Fx.none;
              hitSize = 14f;
              lifetime = 30f;
              drawSize = 500f;
              collidesAir = false;
            }};
            targetAir = false;
            powerUse = 5f;
            inaccuracy = 0f;
            rotateSpeed = 2f;
            chargeEffects = 50;
            coolantMultiplier = 0.7f;
          }};

      //Ground Air
        //ItemTurret
          bastion = new CircularTurret("bastion"){{
            requirements(Category.turret, with(
              WarItems.bronze, 580,
              WarItems.titanit, 650,
              Items.lead, 1800,
              Items.silicon, 650,
              Items.titanium, 1200,
              Items.thorium, 550,
              Items.plastanium, 340
            ));
            size = 6;
            range = 220f;
            health = 15500;
            reloadTime = 60f;
            shots = 8;
            maxAmmo = 150;
            //shootSound = missile
            itemCapacity = 250;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitBastion,
              Items.surgeAlloy, WarBullets.surgeAlloyBastion,
              Items.thorium, WarBullets.thoriumBastion
            );
          }};
          bronzeTurret = new ItemTurret("bronze-turret"){{
            requirements(Category.turret, with(WarItems.bronze, 25, Items.copper, 30, Items.lead, 25));
            health = 800;
            size = 2;
            recoilAmount = 1f;
            reloadTime = 4f;
            range = 100f;
            inaccuracy = 10f;
            rotateSpeed = 10f;
            coolantMultiplier = 0.7f;
            ammoUseEffect = Fx.casing1;
            ammo(
              WarItems.bronze, WarBullets.bronzeBronzeTurret,
              Items.copper, WarBullets.copperBronzeTurret
            );
          }};
          largeBronzeTurret = new ItemTurret("large-bronze-turret"){{
            requirements(Category.turret, with(WarItems.bronze, 60, Items.copper, 70, Items.lead, 60));
            health = 1400;
            size = 3;
            recoilAmount = 2f;
            reloadTime = 4f;
            range = 100;
            ammoUseEffect = Fx.casing2;
            inaccuracy = 3f;
            rotateSpeed = 8f;
            spread = 6f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.bronze, WarBullets.bronzeLargeBronzeTurret,
              Items.copper, WarBullets.copperLargeBronzeTurret
            );
          }};
          dragon = new ItemTurret("dragon"){{
            requirements(Category.turret, with(WarItems.titanit, 130, Items.plastanium, 50, Items.silicon, 65, Items.lead, 70));
            range = 400;
            recoilAmount = 5f;
            reloadTime = 30f;
            ammoUseEffect = Fx.casing3;
            //shootSound = missile
            size = 3;
            health = 1500;
            inaccuracy = 0f;
            rotateSpeed = 3f;
            targetAir = true;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitDragon,
              Items.plastanium, WarBullets.plastaniumDragon,
              Items.surgeAlloy, WarBullets.surgeAlloyDragon
            );
          }};
          hurricane = new HurricaneTurret("hurricane"){{
            requirements(Category.turret, with(WarItems.titanit, 330, WarItems.bronze, 550, Items.plastanium, 125, Items.silicon, 50));
            health = 4600;
            size = 6;
            reloadTime = 20f;
            range = 300f;
            shots = 6;
            rotateSpeed = 5;
            //shootSound = WarSounds.shoot1;
            coolantMultiplier = 0.9f;
            ammo(
              Items.titanium, WarBullets.titaniumHurricane,
              Items.plastanium, WarBullets.plastaniumHurricane
            );
          }};
          multiTurret = new ItemTurret("multi-turret"){{
            requirements(Category.turret, with(WarItems.bronze, 50, Items.copper, 80, Items.lead, 80));
            health = 1300;
            size = 3;
            range = 200f;
            ammoUseEffect = Fx.casing3;
            reloadTime = 10f;
            recoilAmount = 3f;
            inaccuracy = 5f;
            itemCapacity = 30;
            maxAmmo = 30;
            rotateSpeed = 5f;
            coolantMultiplier = 0.7f;
            ammo(
              Items.copper, WarBullets.copperMultiTurret,
              Items.lead, WarBullets.leadMultiTurret,
              Items.scrap, WarBullets.scrapMultiTurret,
              Items.titanium, WarBullets.titaniumMultiTurret,
              Items.graphite, WarBullets.graphiteMultiTurret
            );
          }};
          star = new StarTurret("star"){{
            requirements(Category.turret, with(
              WarItems.titanit, 330,
              WarItems.bronze, 550, 
              Items.plastanium, 125, 
              Items.silicon, 50,
              Items.surgeAlloy, 550
            ));
            health = 4600;
            size = 6;
            reloadTime = 20f;
            range = 500f;
            shots = 8;
            shootEffect = Fx.none;
            shootSound = Sounds.sap;
            rotateSpeed = 5f;
            coolantMultiplier = 0.9f;
            ammo(
              Items.surgeAlloy, WarBullets.surgeAlloyStar
            );
          }};
          trampPilot = new ItemTurret("tramp-pilot"){{
            requirements(Category.turret, with(WarItems.bronze, 20, Items.copper, 40, Items.lead, 20, Items.titanium, 40));
            health = 1300;
            size = 2;
            recoilAmount = 0.1f;
            reloadTime = 0.333333333f;
            range = 150f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 90f;
            rotateSpeed = 10f;
            ammo(
              WarItems.bronze, WarBullets.bronzeTrampPilot,
              Items.copper, WarBullets.copperTrampPilot
            );
          }};
          veil = new VeilTurret("veil"){{
            requirements(Category.turret, with(WarItems.bronze, 70, WarItems.titanit, 100, Items.lead, 55, Items.silicon, 55));
            size = 3;
            shiftRotation = 45f;
            rotateSpeed = 4;
            range = 120f;
            health = 1000;
            reloadTime = 6f;
            shots = 4;
            maxAmmo = 100;
            coolantMultiplier = 0.7f;
            ammo(
              Items.sporePod, WarBullets.sporePodVeil,
              Items.sand, WarBullets.sandVeil
            );
          }};
          volley = new VolleyTurret("volley"){{
            requirements(Category.turret, with(
              WarItems.bronze, 340, 
              WarItems.titanit, 185, 
              Items.copper, 550, 
              Items.lead, 550, 
              Items.silicon, 250, 
              Items.plastanium, 50
            ));
            health = 1400;
            size = 3;
            DBT = 15f;
            recoilAmount = 0f;
            reloadTime = 30f;
            range = 400f;
            shootCone = 10f;
            ammoUseEffect = Fx.none;
            //shootSound = missile
            inaccuracy = 0f;
            shots = 5;
            rotateSpeed = 5f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitVolley,
              Items.surgeAlloy, WarBullets.surgeAlloyVolley
            );
          }};
        //Liquid turret
          stream = new LiquidTurret("stream"){{
            requirements(Category.turret, with(WarItems.bronze, 5, Items.copper, 25, Items.metaglass, 5));
            health = 500;
            size = 1;
            recoilAmount = 0f;
            reloadTime = 1f;
            range = 60f;
            ammoUseEffect = Fx.casing1;
            targetAir = false;
            inaccuracy = 1f;
            shots = 1;
            rotateSpeed = 6f;
            ammo(
              Liquids.water, WarBullets.waterBullet,
              Liquids.slag, WarBullets.slagBullet,
              Liquids.cryofluid, WarBullets.cryofluidBullet,
              Liquids.oil, WarBullets.oilBullet
            );
            }};
          sprayer = new LiquidTurret("sprayer"){{
            requirements(Category.turret, with(WarItems.bronze, 70, WarItems.titanit, 85, Items.copper, 120, Items.lead, 50, Items.metaglass, 35));
            health = 2000;
            size = 3;
            recoilAmount = 1f;
            reloadTime = 0.5f;
            range = 100f;
            ammoUseEffect = Fx.casing1;
            targetGround = true;
            inaccuracy = 0f;
            shots = 15;
            rotateSpeed = 5f;
            ammo(
              Liquids.water, WarBullets.waterBullet,
              Liquids.slag, WarBullets.slagBullet,
              Liquids.cryofluid, WarBullets.cryofluidBullet,
              Liquids.oil, WarBullets.oilBullet
            );
            }};
        //Power turret
          hellTurret = new LaserTurret("hell-turret"){{
            requirements(Category.turret, with(
              WarItems.titanit, 780,
              WarItems.cryocrystal, 60,
              Items.surgeAlloy, 110,
              Items.metaglass, 120,
              Items.graphite, 140,
              Items.plastanium, 375,
              Items.silicon, 100
            ));
            health = 9800;
            size = 4;
            recoilAmount = 0f;
            range = 250f;
            reloadTime = 0.5f;
            powerUse = 200f;
            inaccuracy = 0f;
            rotateSpeed = 0.5f;
            shootCone = 5f;
            firingMoveFract = 0.5f;
            shootDuration = 250f;
            buildCostMultiplier = 8f;
            shootType = new ContinuousLaserBulletType(230){{
              hitEffect = Fx.hitMeltdown;
              despawnEffect = Fx.none;
              hitSize = 18f;
              lifetime = 40f;
              drawSize = 400f;
              collidesAir = true;
            }};
            shootEffect = Fx.shootBigSmoke2;
            shootShake = 2f;
            shootSound = Sounds.laserbig;
            loopSound = Sounds.beam;
            loopSoundVolume = 2f;
            }};
          teslaTurret = new PowerTurret("tesla-turret"){{
            requirements(Category.turret, with(
              WarItems.titanit, 120,
              WarItems.bronze, 230,
              Items.metaglass, 45,
              Items.graphite, 70,
              Items.plastanium, 20
            ));
            health = 1200;
            size = 4;
            recoilAmount = 0f;
            reloadTime = 10f;
            shots = 5;
            shootSound = Sounds.spark;
            shootCone = 15f;
            range = 200f;
            chargeMaxDelay = 30f;
            shootType = new LightningBulletType(){{
              damage = 20;
              lightningLength = 25;
              collidesAir = true;
            }};
            powerUse = 18f;
            inaccuracy = 20f;
            rotateSpeed = 2f;
            chargeEffects = 0;
            coolantMultiplier = 0.7f;
            }};
        //Effects
          shocking = new ItemTurret("shocking"){{
            requirements(Category.turret, with(
              WarItems.titanit, 120,
              WarItems.bronze, 50,
              Items.lead, 40,
              Items.plastanium, 60
            ));
            size = 3;
            health = 1500;
            recoilAmount = 10f;
            reloadTime = 35f;
            range = 280f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 0f;
            shots = 1;
            rotateSpeed = 9f;
            coolantMultiplier = 0.9f;
            ammo(
              WarItems.titanit, WarBullets.titanitShocking,
              Items.plastanium, WarBullets.plastaniumShocking
            );
            }};
        //sniper
          sniper = new ItemTurret("sniper"){{
            requirements(Category.turret, with(
              WarItems.titanit, 90,
              WarItems.bronze, 70,
              Items.lead, 35,
              Items.plastanium, 40
            ));
            size = 3;
            health = 450;
            recoilAmount = 1f;
            reloadTime = 35f;
            range = 500f;
            ammoUseEffect = Fx.casing1;
            shootSound = Sounds.shotgun;
            inaccuracy = 0f;
            shots = 1;
            rotateSpeed = 0.7f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.bronze, WarBullets.bronzeSniper,
              WarItems.titanit, WarBullets.titanitSniper
            );
            }};
          armorPiercingSniper = new ItemTurret("armor-piercing-sniper"){{
            requirements(Category.turret, with(
              WarItems.titanit, 130,
              WarItems.bronze, 70,
              Items.lead, 35,
              Items.plastanium, 70
            ));
            size = 3;
            health = 1600;
            recoilAmount = 1f;
            reloadTime = 120f;
            range = 500f;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.shotgun;
            inaccuracy = 0f;
            rotateSpeed = 0.3f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitArmorPiercingSniper,
              Items.plastanium, WarBullets.plastaniumArmorPiercingSniper
            );
            }};
          starSniper = new ItemTurret("star-sniper"){{
            requirements(Category.turret, with(
              WarItems.titanit, 1200,
              WarItems.bronze, 2100,
              WarItems.cryocrystal, 120,
              Items.lead, 2300,
              Items.plastanium, 550,
              Items.surgeAlloy, 300
            ));
            size = 4;
            health = 4500;
            recoilAmount = 1f;
            reloadTime = 60f;
            range = 1100f;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.shotgun;
            inaccuracy = 0f;
            shots = 3;
            rotateSpeed = 0.6f;
            coolantMultiplier = 0.7f;
            ammo(
              WarItems.titanit, WarBullets.titanitStarSniper,
              Items.surgeAlloy, WarBullets.surgeAlloyStarSniper
            );
          }};
    //Units
      airFactory = new UnitFactory("air-factory"){{
        requirements(Category.units, with(Items.copper, 60, Items.lead, 70));
        plans = Seq.with(
            new UnitPlan(WarUnits.fighterT1, 60f * 10, with(Items.silicon, 30, Items.titanium, 25, Items.metaglass, 25))
        );
        size = 3;
        consumes.power(1.2f);
      }};
      reconstructor1 = new Reconstructor("reconstructor1"){{
        requirements(Category.units, with(Items.copper, 200, Items.lead, 120, Items.silicon, 90));

        size = 3;
        consumes.power(3f);
        consumes.items(with(Items.silicon, 40, Items.graphite, 40));

        constructTime = 60f * 10f;

        upgrades.addAll(
          new UnitType[]{WarUnits.fighterT1, WarUnits.fighterT2}
        );
      }};
      reconstructor2 = new Reconstructor("reconstructor2"){{
        requirements(Category.units, with(Items.lead, 650, Items.silicon, 450, Items.titanium, 350, Items.thorium, 650));

        size = 5;
        consumes.power(6f);
        consumes.items(with(Items.silicon, 130, Items.titanium, 80, Items.metaglass, 40));

        constructTime = 60f * 30f;

        upgrades.addAll(
            new UnitType[]{WarUnits.fighterT2, WarUnits.fighterT3}
        );
      }};
      reconstructor3 = new Reconstructor("reconstructor3"){{
        requirements(Category.units, with(Items.lead, 2000, Items.silicon, 1000, Items.titanium, 2000, Items.thorium, 750, Items.plastanium, 450, Items.phaseFabric, 600));

        size = 7;
        consumes.power(13f);
        consumes.items(with(Items.silicon, 850, Items.titanium, 750, Items.plastanium, 650));
        consumes.liquid(Liquids.cryofluid, 1f);

        constructTime = 60f * 60f * 1.5f;
        liquidCapacity = 60f;

        upgrades.addAll(
          new UnitType[]{WarUnits.fighterT3, WarUnits.fighterT4}
        );
      }};
    //End
  };
}
