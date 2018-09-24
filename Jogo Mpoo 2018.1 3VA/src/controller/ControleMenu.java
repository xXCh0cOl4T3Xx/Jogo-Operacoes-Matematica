package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Arquivo;
import view.JogoPanel;
import view.Mensagem;
import view.MenuInicial;
import view.Tela;
import view.TelaExibirRecordes;

public class ControleMenu implements ActionListener{
	
	private Tela tela;
	private MenuInicial menuInicial;
	private TelaExibirRecordes telaExibirRecordes;
	private Arquivo arquivo;
	
	private JogoPanel jogoPanel;
	
	public ControleMenu(Tela tela, TelaExibirRecordes telaExibirRecordes, Arquivo arquivo) {
		
		this.menuInicial = tela.getMenuInicial();
		this.tela = tela;
		this.telaExibirRecordes = telaExibirRecordes;
		
		this.tela.setVisible(true);
		this.tela.getMenuInicial().setVisible(true);
		this.jogoPanel = tela.getJogoPanel();
		
		this.arquivo = arquivo;
		
		menuInicial.getSairButton().addActionListener(this);
		menuInicial.getSinglePlayerButton().addActionListener(this);
		menuInicial.getMultiplayerButton().addActionListener(this);
		menuInicial.getMostrarRecordesButton().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == menuInicial.getSairButton()){
			if(Mensagem.criarConfirmecaoDialog("Deseja sair?") == 0){
				System.exit(0);
			}
		}
		else if(event.getSource() == menuInicial.getSinglePlayerButton()){
			tela.getCardLayout().show(tela.getContentPane(), "j");
			jogoPanel.getFase1().requestFocus();	
		}
		else if(event.getSource() == menuInicial.getMultiplayerButton()){
			tela.getCardLayout().show(tela.getContentPane(), "j");
			jogoPanel.getFase1().requestFocus();	
		}
		else if(event.getSource() == menuInicial.getMostrarRecordesButton()){
			telaExibirRecordes.setVisible(true);
			telaExibirRecordes.getAreaTexto().setText(arquivo.retornarStringArquivo());
		}
	}

}
