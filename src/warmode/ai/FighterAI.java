package warmode.ai;

import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.type.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.ai.*;
import mindustry.ai.types.*;

import static mindustry.Vars.*;

public class FighterAI extends AIController{

    @Override
    public void updateMovement(){
        if(target != null && unit.hasWeapons() && command() == UnitCommand.attack){
            if(!unit.type.circleTarget){
                Vec2 vec = new Vec2();
                vec.trns(unit.rotation(), 100);
                moveTo(target, 10);
                unit.lookAt(target);
            }else{
                attack(360f);
            }
        }

        if(target == null && command() == UnitCommand.attack && state.rules.waves && unit.team == state.rules.defaultTeam){
            moveTo(getClosestSpawner(), state.rules.dropZoneRadius + 120f);
        }

        if(command() == UnitCommand.rally){
            moveTo(targetFlag(unit.x, unit.y, BlockFlag.rally, false), 60f);
        }
    }

    @Override
    protected Teamc findTarget(float x, float y, float range, boolean air, boolean ground){
        Teamc result = target(x, y, range, air, ground);
        if(result != null) return result;

        if(ground) result = targetFlag(x, y, BlockFlag.core, true);
        if(result != null) return result;

        if(ground) result = targetFlag(x, y, BlockFlag.generator, true);
        if(result != null) return result;

        return null;
    }

    protected void attack(float circleLength){
        vec.set(target).sub(unit);

        float ang = unit.angleTo(target);
        float diff = Angles.angleDist(ang, unit.rotation());

        if(diff > 100f && vec.len() < circleLength){
            vec.setAngle(unit.vel().angle());
        }else{
            vec.setAngle(Mathf.slerpDelta(unit.vel().angle(), vec.angle(), 0.6f));
        }

        vec.setLength(unit.speed());

        unit.moveAt(vec);
    }
}