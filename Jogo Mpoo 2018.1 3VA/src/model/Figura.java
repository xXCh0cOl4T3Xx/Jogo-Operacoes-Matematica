package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Figura implements Movimento{
	
	private int x,y;
	private int largura, altura;
	private int numeroPasso;
	private String endereco;
	private String direcao;
	
	private BufferedImage image;
	
	public Figura(int x, int y, String endereco) {
		super();
		direcao = "stop";
		this.x = x;
		this.y = y;
		numeroPasso = 6;
		try {
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco));
			largura = image.getWidth();
			altura = image.getHeight();
		} catch (IOException e) {
			
		}
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(image, getX(), getY(), null);
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumeroPasso() {
		return numeroPasso;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

}
