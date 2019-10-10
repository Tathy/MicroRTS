/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.ScriptsGenerator.professionalScripts;

import ai.CMAB.*;
import ai.PassiveAI;
import ai.RandomBiasedAI;
import ai.abstraction.HeavyRush;
import ai.abstraction.LightRush;
import ai.abstraction.RangedRush;
import ai.abstraction.WorkerRush;
import ai.competition.capivara.CmabAssymetricMCTS;
import ai.core.AI;
import ai.evaluation.SimpleSqrtEvaluationFunction3;
import ai.configurablescript.BasicExpandedConfigurableScript;
import ai.configurablescript.ScriptsCreator;
import gui.PhysicalGameStatePanel;
import gui.PhysicalGameStateScriptInterfaceJFrame;
import model.Context;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;


/**
 *
 * @author santi
 */
public class ScriptInterface {

    static String _nameStrategies = "", _enemy = "";
    static AI[] strategies = null;

    public static void main(String args[]) throws Exception {
        UnitTypeTable utt = new UnitTypeTable();
        PhysicalGameState pgs = PhysicalGameState.load(Context.getInstance().getMap(), utt);
        
        GameState gs = new GameState(pgs, utt);
        int MAXCYCLES = 8000;
        int PERIOD = 20; // Tempo para cada aÁ„o
        boolean gameover = false;

        AI ai1 = new PassiveAI(utt);
        AI ai2 = new PassiveAI(utt);
        //AI ai1 = new PassiveAI(utt); // VOLTAR este deve ser o estado inicial na interface
        //AI ai2 = new PassiveAI(utt);
             
        
        System.out.println("---------AI's---------");
        System.out.println("AI 1 = "+ai1.toString());
        System.out.println("AI 2 = "+ai2.toString()+"\n");        
        
        //mÈtodo para fazer a troca dos players
        // CriaÁ„o da tela
        //JFrame tela = PhysicalGameStatePanel.newVisualizer(gs, 720, 720, false, PhysicalGameStatePanel.COLORSCHEME_BLACK);
        //JFrame tela = PhysicalGameStatePanel.newVisualizer(gs, 720, 720, false, PhysicalGameStatePanel.COLORSCHEME_WHITE);
        
        /// Tathy - CriaÁ„o da tela
        PhysicalGameStatePanel pgsp = new PhysicalGameStatePanel(gs);
        PhysicalGameStateScriptInterfaceJFrame tela = new PhysicalGameStateScriptInterfaceJFrame("Script Interface", 983, 725, pgsp);
        
        long startTime = System.currentTimeMillis();
        long nextTimeToUpdate = System.currentTimeMillis() + PERIOD;
        
        do {
	        do {
	            if (System.currentTimeMillis() >= nextTimeToUpdate) { // ComeÁo do loop
	            	
	            	// Pause
	            	while(Context.getInstance().isPaused() && !Context.getInstance().isRestarted()) {
	            		nextTimeToUpdate = System.currentTimeMillis() + PERIOD;
	            		pauseGame();
	        			ai1 = attAI(utt);
	        			ai2 = attAI(utt);
	        			//System.out.println(ai1.toString());
	            	}
	            	// Apply durante a simulaÁ„o
	            	if(Context.getInstance().isApplied()) {
	            		
	            		ai1 = attAI(utt);
	        			ai2 = attAI(utt);
	            		Context.getInstance().setApply(false);
	            		
	            	}
	            	
	                /// Tathy
	                teste();

	                startTime = System.currentTimeMillis();
	                
	                PlayerAction pa1 = ai1.getAction(0, gs);
	                if( (System.currentTimeMillis() - startTime) >0){
	                //System.out.println("Tempo de execuÁ„o P1="+(startTime = System.currentTimeMillis() - startTime));
	                }
	                //System.out.println("Action A1 ="+ pa1.toString());
	                //System.out.println("Action A2 ="+ pa2.toString());
	                
	                startTime = System.currentTimeMillis();
	                PlayerAction pa2 = ai2.getAction(1, gs);
	                
	                if( (System.currentTimeMillis() - startTime) >0){
	                   //System.out.println("Tempo de execu√ß√£o P2="+(startTime = System.currentTimeMillis() - startTime));
	                }
	                
	                gs.issueSafe(pa1);
	                gs.issueSafe(pa2);
	                
	                // simulate:
	                gameover = gs.cycle();
	                tela.repaint();
	                nextTimeToUpdate += PERIOD;
	            } else {
	                try {
	                    Thread.sleep(1);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	           /* PhysicalGameState physical = gs.getPhysicalGameState();
	            System.out.println("---------TIME---------");
	            System.out.println(gs.getTime());
	            for (Unit u : physical.getUnits()) {
	                if (u.getPlayer() == 1) {
	                    System.out.println("Player 1: Unity - " + u.toString());
	                }
	                else if (u.getPlayer() == 0) {
	                     System.out.println("Player 0: Unity - " + u.toString());
	                } 
	            }
	            */
	        } while (!gameover && gs.getTime() < MAXCYCLES && !Context.getInstance().isRestarted());
	        
	        if(!Context.getInstance().isRestarted()) {
	        	System.out.println("Winner " + Integer.toString(gs.winner()));
	        	System.out.println("Game Over");
	        	Context.getInstance().setPause(true);
	        	while(Context.getInstance().isPaused() && !Context.getInstance().isRestarted() ) {
	        		pauseGame();
	        	}
	        	
	        	Context.getInstance().setRestart(true);
	        }
	        
	        Context.getInstance().setPause(true);
	        do {
		        //Restart Game
		        //utt = new UnitTypeTable();
				pgs = PhysicalGameState.load(Context.getInstance().getMap(), utt);
				//System.out.println("Restart");
				//System.out.println(Context.getInstance().getMap());
				gs = new GameState(pgs, utt);
				gameover = gs.cycle();
				pgsp = new PhysicalGameStatePanel(gs);
				tela.recreate(983, 725, pgsp);
				ai1 = attAI(utt);
				ai2 = attAI(utt);
				
				Context.getInstance().setPlay(false);
				Context.getInstance().setRestart(false);
				
				startTime = System.currentTimeMillis();
		        nextTimeToUpdate = System.currentTimeMillis() + PERIOD;
		        
		        // AtualizaÁ„o no Apply
		        if(Context.getInstance().isApplied()) {
		        	utt = new UnitTypeTable();
					pgs = PhysicalGameState.load(Context.getInstance().getMap(), utt);
					gs = new GameState(pgs, utt);
					gameover = gs.cycle();
					pgsp = new PhysicalGameStatePanel(gs);
					tela.recreate(983, 725, pgsp);
					//ai1 = new LightRush(utt, new BFSPathFinding());
				    //ai2 = new HeavyRush(utt, new BFSPathFinding());
					ai1 = attAI(utt);
					ai2 = attAI(utt);
					
					Context.getInstance().setPlay(false);
					Context.getInstance().setRestart(false);
					
					startTime = System.currentTimeMillis();
			        nextTimeToUpdate = System.currentTimeMillis() + PERIOD;
		        	Context.getInstance().setApply(false);
		        	
		        }
	        }while(Context.getInstance().isPaused());
	        
        } while(true);
    }
    
    public static List<AI> decodeScripts(UnitTypeTable utt, String sScripts) {
        
        //decomp√µe a tupla
        ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
        String[] itens = sScripts.split(";");

        for (String element : itens) {
            iScriptsAi1.add(Integer.decode(element));
        }
        
        List<AI> scriptsAI = new ArrayList<>();

        ScriptsCreator sc = new ScriptsCreator(utt,300);
        ArrayList<BasicExpandedConfigurableScript> scriptsCompleteSet = sc.getScriptsMixReducedSet();

        iScriptsAi1.forEach((idSc) -> {
            scriptsAI.add(scriptsCompleteSet.get(idSc));
        });

        return scriptsAI;
    }
    
    ///Tathy
    public static void pauseGame() {
    	try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public static AI attAI(UnitTypeTable utt) {
    	String a1, a2;
    	a1 = Context.getInstance().getAI1();
	
    	if(a1 == "Passive")
    		return new PassiveAI(utt);
    	else if(a1 == "Worker Rush")
    		return new WorkerRush(utt);
    	else if(a1 == "Light Rush")
    		return new LightRush(utt);
    	else if(a1 == "Ranged Rush")
    		return new RangedRush(utt);
    	else if(a1 == "Heavy Rush")
    		return new HeavyRush(utt);
    	else if(a1 == "Chromosome")
    		return new Script_Template(utt);	

    	a2 = Context.getInstance().getAI2();
	
    	if(a2 == "Passive")
    		return new PassiveAI(utt);
    	else if(a2 == "Worker Rush")
    		return new WorkerRush(utt);
    	else if(a2 == "Light Rush")
    		return new LightRush(utt);
    	else if(a2 == "Ranged Rush")
    		return new RangedRush(utt);
    	else if(a2 == "Heavy Rush")
    		return new HeavyRush(utt);
    	else if(a2 == "Chromosome")
    		return new Script_Template(utt);
    	
    	return new PassiveAI();
    }
/*    
    public static AI attAi2(UnitTypeTable utt) {
    	String a;
    	ArrayList<Integer> iScriptsAi = new ArrayList<>(Context.getInstance().getScritpsAi2());
    	a = Context.getInstance().getAI2();
    	
    	//System.out.println("Scripts aplicados 2:");
    	//System.out.println(iScriptsAi);
	
    	if(a == "Passive")
    		return new PassiveAI(utt);
    	else if(a == "Worker Rush")
    		return new WorkerRush(utt);
    	else if(a == "Light Rush")
    		return new LightRush(utt);
    	else if(a == "Ranged Rush")
    		return new RangedRush(utt);
    	else if(a == "Heavy Rush")
    		return new HeavyRush(utt);
    	else if(a == "A3N")
    		return new Script_Template(utt);			
										
    	return new PassiveAI();
    }*/
    
    
    public static void teste() {
        if(Context.getInstance().getClickWorker()) {
        	System.out.println("Clicou em WORKER!");
        	Context.getInstance().setClickWorker(false);
        }
        if(Context.getInstance().getClickLight()) {
        	System.out.println("Clicou em LIGHT!");
        	Context.getInstance().setClickLight(false);
        }
        if(Context.getInstance().getClickHeavy()) {
        	System.out.println("Clicou em HEAVY!");
        	Context.getInstance().setClickHeavy(false);
        }
        if(Context.getInstance().getClickRanged()) {
        	System.out.println("Clicou em RANGED!");
        	Context.getInstance().setClickRanged(false);
        }
        if(Context.getInstance().getClickBarrack()) {
        	System.out.println("Clicou em BARRACKS!");
        	Context.getInstance().setClickBarrack(false);
        }
    }


}
