package warmode.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class WarItems implements ContentList{
	public static Item bronze, titanit, cryocrystal; 

	@Override
    public void load(){
    	bronze = new Item("bronze", Color.valueOf("ffdab9")){{}};
      titanit = new Item("titanit", Color.valueOf("276468")){{}};
      cryocrystal = new Item("cryocrystal", Color.valueOf("47EDEF")){{}};
    }
}