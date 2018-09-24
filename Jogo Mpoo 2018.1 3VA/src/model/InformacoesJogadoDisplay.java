package model;

public class InformacoesJogadoDisplay{
	
	private static int tirosRestantes;
	private static int pontos;
	private static boolean vivo;
	
	public InformacoesJogadoDisplay() {
		super();
		tirosRestantes = Tiro.quantidadeTitos;
		pontos = 0; 
		vivo = true;
	}
	
	public void atualizarInformacoes() {
		if(tirosRestantes <= 0){
			vivo = false;
		}
	}
	
	public void decrementarTirosRestantes(){
		tirosRestantes--;
	}
	
	public void incrementarPontos(){
		pontos++;
	}

	public int getTirosRestantes() {
		return tirosRestantes;
	}

	public int getPontos() {
		return pontos;
	}

	public boolean isVivo() {
		return vivo;
	}

	public static void setPontos(int pontos) {
		InformacoesJogadoDisplay.pontos = pontos;
	}

}
