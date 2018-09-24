package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Nave extends Figura{

	private Boolean visibilidade;
	private List<Tiro> tiros;
	private int tiroAtual;
	private boolean player1;
	private String identificacaoPlayer;

	public Nave(int x, int y, boolean player1) {
		super(x, y, "MinhaAeronave.png");
		
		tiros = new ArrayList<Tiro>();
		tiroAtual = 0;
		this.player1 = player1;
		visibilidade = true;
		
		if(player1 == true){
			identificacaoPlayer = "player1";
		}else {
			identificacaoPlayer = "player2";
		}

		for(int i = 0; i < Tiro.quantidadeTitos; i++){
			tiros.add(new Tiro(getX(), getY(), player1));
		}

	}
	
	public void reiniciarTiros(){
		tiros.clear();
		tiros = new ArrayList<Tiro>();
		tiroAtual = 0;
		
		for(int i = 0; i < Tiro.quantidadeTitos; i++){
			tiros.add(new Tiro(getX(), getY(), player1));
		}
	}
	
	public void atirar(){

		if(tiroAtual < tiros.size() - 1){
			tiros.get(tiroAtual).setX(getX());
			tiros.get(tiroAtual).setY(getY());
			tiros.get(tiroAtual).setVisibilidade(true);
			tiroAtual++;
		}
		else{
			tiroAtual = 0;
		}

	}

	@Override
	public void mover() {

		if(getDirecao().equals("subir")){
			setY(getY() - getNumeroPasso());
		}else if(getDirecao().equals("descer")){
			setY(getY() + getNumeroPasso());
		}else if(getDirecao().equals("esquerda")){
			if(getX() <= 0){
				return;
			}
			setX(getX() - getNumeroPasso());
		}else if(getDirecao().equals("direita")){
			setX(getX() + getNumeroPasso());
		}

	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawString(identificacaoPlayer, getX() + 10, getY() + getImage().getHeight() + 10);
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public int getTiroAtual() {
		return tiroAtual;
	}

	public Boolean getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(Boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

}
