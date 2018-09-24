package view;

import java.awt.CardLayout;

public class Tela extends FrameGenerico{
	
	private MenuInicial menuInicial;
	private JogoPanel jogoPanel;
	
	private CardLayout cardLayout;
	
	public Tela(){
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		menuInicial = new MenuInicial();
		jogoPanel = new JogoPanel();
		
		add(menuInicial, "m");
		add(jogoPanel, "j");
		
	}

	public MenuInicial getMenuInicial() {
		return menuInicial;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JogoPanel getJogoPanel() {
		return jogoPanel;
	}

}
