package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ControleMenu;

public class MenuInicial  extends JPanel{

	private JButton sairButton, singlePlayerButton, multiplayerButton, mostrarRecordesButton;
	private Graphics2D g;
	private BufferedImage fundo;

	public MenuInicial() {
		setLayout(null);

		sairButton = new JButton("Sair");
		singlePlayerButton = new JButton("Single Player");
		multiplayerButton = new JButton("Multiplayer");
		mostrarRecordesButton = new JButton("Mostrar Recordes");

		init();

		singlePlayerButton.setBounds(300, 100, 140, 40);
		multiplayerButton.setBounds(300, 250, 140, 40);
		mostrarRecordesButton.setBounds(300, 400, 140, 40);
		sairButton.setBounds(300, 500, 100, 40);
		
		add(sairButton);
		add(singlePlayerButton);
		add(multiplayerButton);
		add(mostrarRecordesButton);

	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(fundo, 0, 0, this);
	}
	
	public void init(){
		try {
			fundo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagemMenu.png"));
			g = (Graphics2D) fundo.getGraphics();
		} catch (IOException e) {
			System.out.println("Problema ao abrir a imagem de fundo de menu.");
		}
	}

	public void adicionaEvento(ControleMenu hendler) {
		singlePlayerButton.addActionListener(hendler);
		sairButton.addActionListener(hendler);

	}

	public JButton getSairButton() {
		return sairButton;
	}

	public JButton getSinglePlayerButton() {
		return singlePlayerButton;
	}

	public JButton getMultiplayerButton() {
		return multiplayerButton;
	}

	public JButton getMostrarRecordesButton() {
		return mostrarRecordesButton;
	}

}
