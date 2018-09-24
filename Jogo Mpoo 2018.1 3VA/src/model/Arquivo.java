package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class Arquivo {
	
	private static final String caminhoArquivo = "file/basedados.xml";
	private static final String nomeArquivo = "basedados";
	
	public void salvarInformacoes(InformacaoJogadorArquivo arquivoJogador){
		
		JogadoresArray jogadoresArray = new JogadoresArray();
		
		XStream xStream = new XStream(new Dom4JDriver());
		xStream.alias(nomeArquivo, JogadoresArray.class);
		
		File file = new File(caminhoArquivo);
		
		if(file.exists()){
			jogadoresArray = (JogadoresArray) xStream.fromXML(file);
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		jogadoresArray.getInformacoesJogados().add(arquivoJogador);
		
		try {
			OutputStream outputStream = new FileOutputStream(file);
			xStream.toXML(jogadoresArray, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public String retornarStringArquivo() {
		JogadoresArray jogadoresArray = new JogadoresArray();
		
		XStream xStream = new XStream(new Dom4JDriver());
		xStream.alias(nomeArquivo, JogadoresArray.class);
		
		File file = new File(caminhoArquivo);
		
		String stringArquivo = "";
		
		if(!file.exists()){
			return "Arquivo não encontrado";
		}
		
		jogadoresArray = (JogadoresArray) xStream.fromXML(file);
		
		for(InformacaoJogadorArquivo informacaoJogadorArquivo : jogadoresArray.getInformacoesJogados()){
			stringArquivo += "Nome: " + informacaoJogadorArquivo.getNome() +
					"\tPontos: " + informacaoJogadorArquivo.getPontos() + "\n";
		}
		
		return stringArquivo;
	}
	
}
