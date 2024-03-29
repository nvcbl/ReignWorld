package reign;

import arc.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class Main extends Mod{
    @Override
    public void loadContent(){
        Events.run(Trigger.newGame, () -> {
            state.rules.spawns.each(spawn -> {
                spawn.type =

                spawn.type.flying || spawn.type.hovering ?  UnitTypes.eclipse :
                spawn.type.naval ?                          UnitTypes.navanax :
                spawn.type.allowLegStep ?                   UnitTypes.toxopid :
                                                            UnitTypes.reign;
            });
        });

        UnitTypes.eclipse.envDisabled = 0;
        UnitTypes.eclipse.envEnabled = Env.any;
        UnitTypes.toxopid.envDisabled = 0;
        UnitTypes.toxopid.envEnabled = Env.any;
        UnitTypes.navanax.envDisabled = 0;
        UnitTypes.navanax.envEnabled = Env.any;
        UnitTypes.reign.envDisabled = 0;
        UnitTypes.reign.envEnabled = Env.any;
    }
}
