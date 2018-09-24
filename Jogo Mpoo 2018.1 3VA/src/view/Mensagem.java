package view;

import javax.swing.JOptionPane;

public class Mensagem {
	
	public static int criarConfirmecaoDialog(String mensagem){
		return JOptionPane.showConfirmDialog(null, mensagem);
	}
	
	public static void criarMensagemDialog(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static String criarInputMensagem(String mensagem){
		return JOptionPane.showInputDialog(null, mensagem);
	}

}
