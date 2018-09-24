package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class JogoPanel extends JPanel{
	
	private Inventario inventario;
	private Fase1 fase1;
	
	public JogoPanel(){
		setLayout(new BorderLayout());
		
		inventario = new Inventario();
		fase1 = new Fase1();
		
		setPreferredSize(new Dimension(800,600));
		add(inventario, BorderLayout.WEST);
		add(fase1, BorderLayout.CENTER);
		
	}

	public Inventario getInventario() {
		return inventario;
	}

	public Fase1 getFase1() {
		return fase1;
	}

}
