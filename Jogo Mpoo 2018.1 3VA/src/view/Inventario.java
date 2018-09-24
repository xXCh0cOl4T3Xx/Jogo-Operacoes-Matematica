package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inventario  extends JPanel{
	
	private JLabel tirosRestantesLabel, tirosStatusLabel, primeiraLinhaLabel, segundaLinhaLabel, operacaoLabel;
	private JLabel statusPontosLabel, pontosLabel;

	public Inventario() {
		setLayout(null);
		setPreferredSize(new Dimension(130,600));
		setBackground(Color.yellow);
		
		primeiraLinhaLabel = new JLabel("Atire na resposta");
		segundaLinhaLabel = new JLabel("correspondente");
		operacaoLabel = new JLabel("Pergunta ???");
		
		tirosRestantesLabel = new JLabel("Tiros restantes: ");
		tirosStatusLabel = new JLabel("");
		
		pontosLabel = new JLabel("Pontos: ");
		statusPontosLabel = new JLabel("");
		
		primeiraLinhaLabel.setBounds(10, 10, 100, 20);
		segundaLinhaLabel.setBounds(10, 10, 100, 50);
		operacaoLabel.setBounds(10, 80, 100, 60);
		tirosRestantesLabel.setBounds(10, 500, 100,20);
		tirosStatusLabel.setBounds(100, 500, 100,20);
		
		pontosLabel.setBounds(10, 520, 100, 20);
		statusPontosLabel.setBounds(100, 520, 100, 20);
		
		add(primeiraLinhaLabel);
		add(segundaLinhaLabel);
		add(operacaoLabel);
		add(tirosRestantesLabel);
		add(tirosStatusLabel);
		add(statusPontosLabel);
		add(pontosLabel);
		
	}

	public void setLbPergunta(JLabel lbPergunta) {
		this.operacaoLabel = lbPergunta;
	}

	public JLabel getTirosStatusLabel() {
		return tirosStatusLabel;
	}

	public JLabel getStatusPontosLabel() {
		return statusPontosLabel;
	}

	public JLabel getOperacaoLabel() {
		return operacaoLabel;
	}

}
