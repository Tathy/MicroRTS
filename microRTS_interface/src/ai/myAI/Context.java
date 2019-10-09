// Classe Singleton com informações capturadas da tela

package ai.myAI;

public class Context {
	
	private static Context uniqueInstance = new Context();
	
	private Context() {}
	
	/// Barra Inferior
	private boolean pause = true;
	private boolean restart = false;
	private boolean play = false;
	
	
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
