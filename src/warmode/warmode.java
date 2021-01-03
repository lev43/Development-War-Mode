package warmode;

import arc.*;
import arc.func.*;
import arc.util.Log;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import warmode.content.*;

public class warmode extends Mod{
    public static final String githubURL = "https://github.com/lev43/Development-war-mode";
    public static SettingAdder settingAdder = new SettingAdder();

    private final ContentList[] WarContent = {
        new WarItems(),
        new WarBullets(),
        new WarBlocks()
    };

    public warmode() {
        super();
    }

    @Override
    public void init(){
        Vars.enableConsole = true;

        if(!Vars.headless){
            //Partial credits to ProjectUnity
            LoadedMod mod = Vars.mods.locateMod("warmode");
            Func<String, String> stringf = value -> Core.bundle.get("mod." + value);

            //mod.meta.displayName = stringf.get(mod.meta.name + ".name");
            //mod.meta.description = stringf.get(mod.meta.name + ".description");
            //mod.meta.version = mod.meta.version + "\n" + stringf.get(mod.meta.name + ".short");
            //mod.meta.author = "[royal]" + mod.meta.author + "[]";
        }
    }

    @Override
    public void loadContent(){
        for(ContentList list : WarContent){
            list.load();

            //Log.info("@: Loaded content list: @", getClass().getSimpleName(), list.getClass().getSimpleName());
        }
    }
}
