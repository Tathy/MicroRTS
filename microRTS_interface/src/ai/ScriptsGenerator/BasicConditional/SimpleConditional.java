/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.ScriptsGenerator.BasicConditional;

import ai.ScriptsGenerator.BasicConditional.functions.IConditionalFunction;
import ai.abstraction.pathfinding.PathFinding;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rts.GameState;
import rts.PlayerAction;
import rts.units.Unit;
import rts.units.UnitTypeTable;

/**
 *
 * @author rubens
 */
public class SimpleConditional extends AbstractConditional implements IUnitConditional{

    public SimpleConditional(String function, List lParam1) {
        super(function, lParam1);
    }

    @Override
    public boolean runConditional(GameState game, int player, PlayerAction currentPlayerAction, PathFinding pf, UnitTypeTable a_utt) {
        List param = new ArrayList();
        param.add(game);
        param.add(player);
        param.add(currentPlayerAction);
        param.add(pf);
        param.add(a_utt);
        param.addAll(lParam1);
        try {
            IConditionalFunction fcond = (IConditionalFunction) Class.forName("ai.ScriptsGenerator.BasicConditional.functions." + function).newInstance();
            return fcond.runFunction(param);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ConditionalBiggerThen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public String toString() {
        return "SimpleConditional{" +this.function+" "+ this.lParam1+ '}';
    }

    @Override
    public boolean runConditional(GameState game, int player, PlayerAction currentPlayerAction, PathFinding pf, UnitTypeTable a_utt, Unit un) {
        List param = new ArrayList();
        param.add(game);
        param.add(player);
        param.add(currentPlayerAction);
        param.add(pf);
        param.add(a_utt);
        param.addAll(lParam1);
        param.add(un);
        try {
            IConditionalFunction fcond = (IConditionalFunction) Class.forName("ai.ScriptsGenerator.BasicConditional.functions." + function).newInstance();
            return fcond.runFunction(param);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ConditionalBiggerThen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Boolean isNecessaryUnit() {
        for (Object object : lParam1) {
            if(object instanceof String){
                String param = (String) object;
                if(param.equals("u")){
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
