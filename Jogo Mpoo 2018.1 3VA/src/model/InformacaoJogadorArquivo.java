package model;

public class InformacaoJogadorArquivo {
	
	private String nome;
	private String pontos;
	
	public InformacaoJogadorArquivo(String nome, String pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPontos() {
		return pontos;
	}
	public void setPontos(String pontos) {
		this.pontos = pontos;
	}

}
