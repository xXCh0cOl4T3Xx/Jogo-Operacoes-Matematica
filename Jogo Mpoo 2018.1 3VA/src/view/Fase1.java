package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Camada;

public class Fase1 extends JPanel{

	private Camada camada;
	private Graphics2D g;
	private BufferedImage fundo;

	public Fase1(){
		setPreferredSize(new Dimension(500,600));
		init();

	}

	@Override
	protected void paintComponent(Graphics g) {

		g.drawImage(fundo, 0, 0, null);

	}

	public void init(){
		setLayout(null);

		fundo = new BufferedImage(960, 800, BufferedImage.TYPE_4BYTE_ABGR);
		g = (Graphics2D) fundo.getGraphics();

	}

	public Graphics2D getG() {
		return g;
	}

	public BufferedImage getFundo() {
		return fundo;
	}

}
