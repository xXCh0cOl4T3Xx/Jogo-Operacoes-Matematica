package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class FaseModel {
	
	private TiledMap fundo;
	private TiledMap casas;
	private List<TiledMap> maps;
	private List<Nave> naves;
	private List<Meteoro> meteoros;
	private GeraQuestao gerarQuestao;
	private List<Rectangle> rectangleTiros;
	
	public FaseModel() {
		super();
	
		naves = new ArrayList<Nave>();
		naves.add(new Nave(10, 150, true));
		naves.add(new Nave(10, 400, false));
		
		fundo = new TiledMap(30, 30, 32, 32, "tilesheet.png", "Fundo.txt");
		casas = new TiledMap(30, 30, 32, 32, "tilesheet.png", "Casas.txt");
		maps = new ArrayList<TiledMap>();
		meteoros = new ArrayList<Meteoro>(Meteoro.numeroDeMeteoros);
		gerarQuestao = new GeraQuestao();
		rectangleTiros = new ArrayList<Rectangle>();
		
		for(int i = 0; i < 3; i++){
			meteoros.add(new Meteoro(550, 20 + (i * 200), "meteoro.png"));
			meteoros.get(i).setAlternativa(gerarQuestao.getAlternativas().get(i));
		}
		
		meteoros.get(gerarQuestao.getAlternativaCorreta()).setMeteoroCorreto(true);
		
		maps.add(fundo);
		maps.add(casas);
				
	}

	public List<TiledMap> getMaps() {
		return maps;
	}

	public List<Meteoro> getMeteoros() {
		return meteoros;
	}

	public GeraQuestao getGerarQuestao() {
		return gerarQuestao;
	}

	public List<Rectangle> getRectangleTiros() {
		return rectangleTiros;
	}

	public List<Nave> getNaves() {
		return naves;
	}

}
