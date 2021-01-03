package warmode.content;

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
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.with;

public class WarBlocks implements ContentList {
  //factory
  public static Block factoryOfBronze, factoryOfCryocrystals, factoryOfTitanit,
  //turrets
    //air
      airDefense, /*calm,*/ fireworks, storm,
    //ground
      //artillery
        //acid, mortar, volcano,
      //item turret
        //cudo, flamethrower, machineGun, /*projectOmega, roseHipAlpha, roseHipBeta,*/
      //power turret
        //laserMachineGun, laserTurret,
    //ground air
      //item turret
        /*bastion,*/ bronzeTurret; //largeBronzeTurret, dragon, /*hurricane,*/ multiTurret, /*star,*/ trampPilot, /*veil, volley,*/
      //liquid turret
        //sprayer, stream, 
      //power turret
        //hellTurret, teslaTurret,
      //turret effect
        //shocking,
      //sniper
        //armorPiercingSniper, sniper, starSniper;
  
  @Override
  public void load() {
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
  };
}
