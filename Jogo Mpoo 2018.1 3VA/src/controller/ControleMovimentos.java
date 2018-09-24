package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import model.Arquivo;
import model.GeraQuestao;
import model.InformacaoJogadorArquivo;
import model.InformacoesJogadoDisplay;
import model.Meteoro;
import model.Nave;
import model.Tiro;
import view.Fase1;
import view.Inventario;
import view.JogoPanel;
import view.Mensagem;
import view.Tela;

public class ControleMovimentos extends Thread implements KeyListener {

	private Fase1 fase1;
	private Tela tela;

	private Inventario inventario;

	private InformacoesJogadoDisplay informacoesPersonagem;
	private List<Nave> naves;
	private List<Meteoro> meteoros;

	private GeraQuestao gerarQuestao;

	private Rectangle meteoroCorretoRectangle;
	private List<Rectangle> tirosRectangle;

	private boolean colisao;

	private Arquivo arquivo;

	public ControleMovimentos(Arquivo arquivo ,List<Rectangle> rectangleTiros ,JogoPanel jogoPanel, 
			GeraQuestao gerarQuestao, List<Nave> naves, List<Meteoro> meteoros, 
			InformacoesJogadoDisplay informacoesPersonagem, Tela tela){ 

		this.naves = naves;
		this.meteoros = meteoros;

		this.arquivo = arquivo;
		this.informacoesPersonagem = informacoesPersonagem;
		this.tela = tela;
		this.fase1 = tela.getJogoPanel().getFase1();
		this.inventario = tela.getJogoPanel().getInventario();
		this.gerarQuestao = gerarQuestao;
		this.tirosRectangle = rectangleTiros;

		for(int i = 0; i < meteoros.size(); i++){
			meteoros.get(i).setAlternativa(gerarQuestao.getAlternativas().get(i));
		}

		inventario.getTirosStatusLabel().setText(Integer.toString(informacoesPersonagem.getTirosRestantes()));
		inventario.getStatusPontosLabel().setText(Integer.toString(informacoesPersonagem.getPontos()));
		inventario.getOperacaoLabel().setText(gerarQuestao.getOperacao());
		System.out.println("Operação: " + gerarQuestao.getOperacao());

		colisao = false;

		marcarMeteoroCorreto();

		fase1.addKeyListener(this);
		fase1.requestFocus();

		tela.getMenuInicial().getSinglePlayerButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				naves.get(1).setVisibilidade(false);

			}
		});

		start();

	}

	public void marcarMeteoroCorreto(){
		for(Meteoro meteoro : meteoros){
			if(meteoro.isMeteoroCorreto()){
				meteoroCorretoRectangle = meteoro.getBounds();
			}
		}

	}

	public void marcarPosicaoTiros(){

		for(Tiro tiro : naves.get(0).getTiros()){
			if(tiro.getVisibilidade() == true){
				tirosRectangle.add(tiro.getBounds());
			}
		}

		for(Tiro tiro : naves.get(1).getTiros()){
			if(tiro.getVisibilidade() == true){
				tirosRectangle.add(tiro.getBounds());
			}
		}

	}

	public void colisao(){
		marcarMeteoroCorreto();
		marcarPosicaoTiros();

		for(Rectangle rectangleTiro : tirosRectangle){
			if(rectangleTiro.intersects(meteoroCorretoRectangle)){
				informacoesPersonagem.incrementarPontos();
				inventario.getStatusPontosLabel().setText(Integer.toString(informacoesPersonagem.getPontos()));

				colisao = true;
				break;
			}
		}

		if(colisao){
			reiniciarQuestao();
		}
	}

	public void reiniciarQuestao(){
		colisao = false;

		naves.get(0).reiniciarTiros();
		naves.get(1).reiniciarTiros();
		tirosRectangle.clear();

		for(int i = 0; i < Meteoro.numeroDeMeteoros; i++){
			meteoros.get(i).setMeteoroCorreto(false);
		}

		gerarQuestao.getAlternativas().clear();
		gerarQuestao.gerarOperacao();

		meteoros.get(gerarQuestao.getAlternativaCorreta()).setMeteoroCorreto(true);;

		for(int i = 0; i < Meteoro.numeroDeMeteoros; i++){
			meteoros.get(i).setAlternativa(gerarQuestao.getAlternativas().get(i));
		}

		inventario.getOperacaoLabel().setText(gerarQuestao.getOperacao());

	}

	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:{
			naves.get(0).setDirecao("subir");
			break;
		}
		case KeyEvent.VK_DOWN:{
			naves.get(0).setDirecao("descer");
			break;
		}		
		case KeyEvent.VK_LEFT:{
			naves.get(0).setDirecao("esquerda");
			break;
		}
		case KeyEvent.VK_RIGHT:{
			naves.get(0).setDirecao("direita");
			break;
		}
		case KeyEvent.VK_J:{
			informacoesPersonagem.atualizarInformacoes();
			informacoesPersonagem.decrementarTirosRestantes();
			naves.get(0).atirar();
			marcarPosicaoTiros();

			inventario.getTirosStatusLabel().setText(Integer.toString(informacoesPersonagem.getTirosRestantes()));
			inventario.repaint();

			if(!informacoesPersonagem.isVivo()){
				stop();
			}
			break;
		}


		case KeyEvent.VK_W:{
			if(naves.get(1).getVisibilidade())
				naves.get(1).setDirecao("subir");
			break;
		}
		case KeyEvent.VK_Z:{
			if(naves.get(1).getVisibilidade())
				naves.get(1).setDirecao("descer");
			break;
		}		
		case KeyEvent.VK_A:{
			if(naves.get(1).getVisibilidade())
				naves.get(1).setDirecao("esquerda");
			break;
		}
		case KeyEvent.VK_S:{
			if(naves.get(1).getVisibilidade())
				naves.get(1).setDirecao("direita");
			break;
		}
		case KeyEvent.VK_F:{
			if(naves.get(1).getVisibilidade()){
				informacoesPersonagem.atualizarInformacoes();
				informacoesPersonagem.decrementarTirosRestantes();
				naves.get(1).atirar();
				marcarPosicaoTiros();

				inventario.getTirosStatusLabel().setText(Integer.toString(informacoesPersonagem.getTirosRestantes()));
				inventario.repaint();
				
				if(!informacoesPersonagem.isVivo()){
					stop();
					Mensagem.criarMensagemDialog("Fim de Jogo");
				}
			}

			break;
		}
		}
	}

	
	@Override
	public void keyReleased(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:{
			naves.get(0).setDirecao("stop");
			break;
		}
		case KeyEvent.VK_DOWN:{
			naves.get(0).setDirecao("stop");
			break;
		}		
		case KeyEvent.VK_LEFT:{
			naves.get(0).setDirecao("stop");
			break;
		}
		case KeyEvent.VK_RIGHT:{
			naves.get(0).setDirecao("stop");
			break;
		}

		case KeyEvent.VK_W:{
			naves.get(1).setDirecao("stop");
			break;
		}
		case KeyEvent.VK_Z:{
			naves.get(1).setDirecao("stop");
			break;
		}		
		case KeyEvent.VK_A:{
			naves.get(1).setDirecao("stop");
			break;
		}
		case KeyEvent.VK_S:{
			naves.get(1).setDirecao("stop");
			break;
		}


		default: {
			break;
		}

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void run() {	

		while(true){
			if(meteoros.get(0).isFim()){
				arquivo.salvarInformacoes(new InformacaoJogadorArquivo(Mensagem.criarInputMensagem("Digite seu nome."),
						Integer.toString(informacoesPersonagem.getPontos())));
				stop();
			}

			for(int i = 0; i < 2; i++){
				naves.get(i).mover();
			}

			for(Meteoro meteoro : meteoros){
				meteoro.mover();
			}

			for(int i = 0; i < 2; i++){
				for(Tiro tiro : naves.get(i).getTiros()){
					if(tiro.getVisibilidade() == true){
						tiro.mover();
					}
				}
			}

			colisao();

			try {
				sleep(50);				
			} catch (InterruptedException e) {	
				Mensagem.criarMensagemDialog("Houve um problema, o jogo será enserrado!");
				System.exit(0);
			}

		}

	}

	

}
