package warmode.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.graphics.*;
import mindustry.entities.*;

public class WarEffects implements ContentList{
  public static Effect chargeProjectOmega;
  @Override
    public void load(){
      chargeProjectOmega = new Effect(60f, e -> {
        Vec2 vec = new Vec2();
        Draw.color(Pal.lightOrange);
        for(int i = 0; i<110; i+=30){
          vec.trns(e.rotation, -i, 2);
          Lines.lineAngle(e.x + vec.x, e.y + vec.y, e.rotation - 10, e.fslope() * 5 + 1);
          vec.trns(e.rotation, -i, -2);
          Lines.lineAngle(e.x + vec.x, e.y + vec.y, e.rotation + 10, e.fslope() * 5 + 1);
        }
        Draw.color();
      });
    }
}