package model;

import java.awt.Graphics;

public class Meteoro extends Figura {
	private boolean meteoroCorreto;
	public static final int numeroDeMeteoros = 3;
	private boolean fim;
	private String alternativa;
	
	public Meteoro(int x, int y, String endereco) {
		super(x, y, endereco);
		
		meteoroCorreto = false;
		fim = false;
		alternativa = new String();
	}

	public void reiniciar(int x, int y,String alternativa){
		setX(x);
		setY(y);
		this.alternativa = alternativa;
		
	}
	
	@Override
	public void mover() {
		if(getX() <= 0){
			fim = true;
		}else{
			setX(getX() - (getNumeroPasso() - 5));
		}
	}

	public boolean isMeteoroCorreto() {
		return meteoroCorreto;
	}

	public void setMeteoroCorreto(boolean meteoroCorreto) {
		this.meteoroCorreto = meteoroCorreto;
	}

	public boolean isFim() {
		return fim;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawString(alternativa, getX(), getY() + 130);
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public void setFim(boolean fim) {
		this.fim = fim;
	}

}
