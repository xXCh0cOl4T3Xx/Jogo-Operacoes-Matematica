package app;

import controller.ControleMenu;
import controller.ControleMovimentos;
import controller.ControlePintura;
import view.JogoPanel;
import view.Tela;
import view.TelaExibirRecordes;
import model.Arquivo;
import model.FaseModel;
import model.InformacoesJogadoDisplay;

public class App {
	
	public static void main(String[] args) {

		FaseModel faseModel = new FaseModel();
		JogoPanel jogoPanel = new JogoPanel();
		Tela tela = new Tela();
		InformacoesJogadoDisplay informacoesPersonagem = new InformacoesJogadoDisplay();
		TelaExibirRecordes telaExibirRecordes = new TelaExibirRecordes("");
		
		Arquivo arquivo = new Arquivo();

		new ControleMenu(tela, telaExibirRecordes, arquivo);

		new ControlePintura(tela.getJogoPanel().getFase1(), faseModel.getNaves(), faseModel.getGerarQuestao(), 
				faseModel.getMeteoros(), faseModel.getMaps());

		new ControleMovimentos(new Arquivo() ,faseModel.getRectangleTiros(), jogoPanel, faseModel.getGerarQuestao(), faseModel.getNaves(), 
				faseModel.getMeteoros(), informacoesPersonagem, tela);
		
	}

}
