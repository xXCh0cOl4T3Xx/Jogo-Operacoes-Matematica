package controller;

import java.awt.Graphics2D;

import view.Fase1;

public abstract class Jogo implements Runnable{
	
	private Fase1 fase1;
	private Thread thread;

	public Jogo(Fase1 fase1) {
		super();
		this.fase1 = fase1;
	}

	public void star() {

		thread = new Thread(this);
		thread.start();

	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				
				if(fase1.isVisible())
				{
					renderizar();
					draw(fase1.getG());
					fase1.repaint();					
				}
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public abstract void renderizar();
	
	public abstract void draw(Graphics2D g);

}
