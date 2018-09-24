package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaExibirRecordes extends FrameGenerico{
	
	private JTextArea areaTexto;
	
	public TelaExibirRecordes(String infromacoes){
		
		areaTexto = new JTextArea(infromacoes, 5, 15);
		areaTexto.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(areaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		
		setVisible(false);
		
	}

	public JTextArea getAreaTexto() {
		return areaTexto;
	}

	public void setAreaTexto(JTextArea areaTexto) {
		this.areaTexto = areaTexto;
	}

}
