package model;

public class Tiro extends Figura {
	 
	private Boolean visibilidade;
	public static final int quantidadeTitos = 10;
	private boolean player1;
	
	public Tiro(int x, int y, boolean player1){
		super(x, y, "Tiro.png");
		visibilidade = false;
		this.player1 = player1;
	}
	
	@Override
	public void mover() {
		
		if(getX() >= 800){
			visibilidade = false;
			return;
		}else{
			setX(getX() + getNumeroPasso() + 10);
		}
		
	}

	public Boolean getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(Boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	public boolean isPlayer1() {
		return player1;
	}

}
