// Classe Singleton com informações capturadas da tela

package model;

import java.util.ArrayList;

public class Context {
	
	private static Context uniqueInstance = new Context();
	
	private Context() {}
	
	// Barra Inferior
	private boolean pause = true;
	private boolean restart = true;
	private boolean play = false;
	private boolean apply = false;
	
	// Map
	private String map = "maps/24x24/basesWorkers24x24A.xml";
	//AIs
	private String ai1 = "Passive";
	private String ai2 = "Passive";
	//ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
    //ArrayList<Integer> iScriptsAi2 = new ArrayList<>();
	ArrayList<String> scriptsAi1 = new ArrayList<>();
	ArrayList<String> scriptsAi2 = new ArrayList<>();
	
	
	// TESTES
	private boolean clickMap = false;
	private boolean clickWorker = false;
	private boolean clickLight = false;
	private boolean clickHeavy = false;
	private boolean clickRanged = false;
	private boolean clickBarrack = false;
	
	public static Context getInstance() {
		return uniqueInstance;
	}
	
	// Barra inferior
	
	public void setApply(boolean op) {
		apply = op;
	}
	
	public boolean isApplied() {
		return apply;
	}
	
	public void setPause(boolean op) {
		pause = op;
	}
	
	public boolean isPaused() {
		return pause;
	}
		
	public void setRestart(boolean op) {
		if(op)
			setPause(true);
		restart = op;
	}
	
	public boolean isRestarted() {
		return restart;
	}
	
	public void setPlay(boolean op) {
		play = op;
	}
	
	public boolean isPlayClicked() {
		return play;
	}

	// Telinha Main
	public String getMap() {
		return map;
	}
	
	public void setMap(MapPath m) {
		if(m != null)
			map = m.getPath();
	}

	
	public String getAI1() {
		return ai1;
	}

	public String getAI2() {
		return ai2;
	}

	public void setAI1(String s_ai1) {
		if(s_ai1 != null)
			ai1 = s_ai1;
	}
	
	public void setAI2(String s_ai2) {
		if(s_ai2 != null)
			ai2 = s_ai2;
	}
	
	public void addScriptAI1(String i) {
		scriptsAi1.add(i);
	}
	
	public void clearScriptsAI1() {
		scriptsAi1.clear();
	}
	
	public ArrayList<String> getScritpsAi1(){
		return scriptsAi1;
	}
	
	public void addScriptAI2(String i) {
		scriptsAi2.add(i);
	}
	
	public void clearScriptsAI2() {
		scriptsAi2.clear();
	}
	
	public ArrayList<String> getScritpsAi2(){
		return scriptsAi2;
	}
	
	// TESTES
	
	public void setClickMap(boolean op) {
		clickMap = op;
	}
	
	public boolean getClickMap() {
		return clickMap;
	}
	
	
	public void setClickWorker(boolean op) {
		clickWorker = op;
	}
	
	public boolean getClickWorker() {
		return clickWorker;
	}
	
	
	public void setClickLight(boolean op) {
		clickLight = op;
	}
	
	public boolean getClickLight() {
		return clickLight;
	}
	
	
	public void setClickHeavy(boolean op) {
		clickHeavy = op;
	}
	
	public boolean getClickHeavy() {
		return clickHeavy;
	}
	
	
	public void setClickRanged(boolean op) {
		clickRanged = op;
	}
	
	public boolean getClickRanged() {
		return clickRanged;
	}
	
	
	public void setClickBarrack(boolean op) {
		clickBarrack = op;
	}
	
	public boolean getClickBarrack() {
		return clickBarrack;
	}
	

}
