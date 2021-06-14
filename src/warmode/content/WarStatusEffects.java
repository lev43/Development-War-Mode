package warmode.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.graphics.*;

public class WarStatusEffects implements ContentList{
  public static StatusEffect brokenArmor;
  @Override
    public void load(){
      brokenArmor = new StatusEffect("brokenArmor"){{
        healthMultiplier = 0.1f;
        speedMultiplier = 0.8f;
        color = Color.valueOf("b0b0b0");

        init(() -> {
          // trans(StatusEffects.blasted, ((unit, time, newTime, result) -> {
          //   result.set(this, time);
          // }));
        });
      }};
    }
}