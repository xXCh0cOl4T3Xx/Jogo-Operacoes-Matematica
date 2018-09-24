package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import view.Fase1;
import model.GeraQuestao;
import model.Meteoro;
import model.Nave;
import model.TiledMap;
import model.Tiro;

public class ControlePintura extends Jogo{
	
	private List<Meteoro> meteoros;
	private List<Nave> naves;
	
	private GeraQuestao gerarQuestao;
	
	static int x = 0;
	static int y = 0;
	
	private List<TiledMap> maps;
	private BufferedImage tela;
	private Graphics g;
	
	public ControlePintura(Fase1 fase1 , List<Nave> naves, GeraQuestao gerarQuestao, 
			List<Meteoro> meteoros, List<TiledMap> maps) {
		super(fase1);
		
		this.naves = naves;
		this.meteoros = meteoros;
		
		this.gerarQuestao = gerarQuestao;

		this.maps = maps;
		
		tela = new BufferedImage(maps.get(0).getLarguraTela(), maps.get(0).getAlturaTela(), BufferedImage.TYPE_4BYTE_ABGR);
		g = tela.getGraphics();
		
		star();
	}
	
	@Override
	public void renderizar(){

		for(TiledMap tiledMap : maps){
			tiledMap.montarMapa();
			g.drawImage(tiledMap.getMapa(), 0, 0, null);	
		}
		
		for(Tiro tiro : naves.get(0).getTiros()){
			if(tiro.getVisibilidade() == true){
				tiro.draw(g);
			}
		}
		
		for(Tiro tiro : naves.get(1).getTiros()){
			if(tiro.getVisibilidade() == true){
				tiro.draw(g);
			}
		}
		
		for(Meteoro meteoro : meteoros){
			meteoro.draw(g);
		}
		
		naves.get(0).draw(g);
		if(naves.get(1).getVisibilidade() == true){
			naves.get(1).draw(g);
		}
		
	}
	
	@Override
	public void draw(Graphics2D g){
		
		x = Math.min(tela.getWidth() - 800, Math.max(0, naves.get(0).getX() - 800 / 2));
		y = Math.min(tela.getHeight() - 600, Math.max(0, naves.get(0).getY() - 600 / 2));
			
		g.drawImage(tela, -x, -y, null);
	}
	
}
