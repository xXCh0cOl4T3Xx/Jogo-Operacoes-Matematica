package model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class GeraQuestao {
	private int firstNumber, secondNumber, result;
	private String operacao;
	
	private List<String> alternativas = new ArrayList<String>();
	private int alternativaCorreta;

	public GeraQuestao(){
		gerarOperacao();
	}

	public void embaralharResposta(){

		SecureRandom random = new SecureRandom();
		SecureRandom numeroAleatorio = new SecureRandom();

		for(int i = 0; i < Meteoro.numeroDeMeteoros; i++){
			alternativas.add(Integer.toString(numeroAleatorio.nextInt(99)));
		}

		alternativaCorreta = random.nextInt(Meteoro.numeroDeMeteoros);

		alternativas.set(alternativaCorreta, Integer.toString(result));
		
	}

	public void gerarOperacao() {
		SecureRandom random = new SecureRandom();
		
		firstNumber = random.nextInt(99) + 1;
		secondNumber = random.nextInt(99) + 1;

		switch (random.nextInt(5)) {
		case 1:{ 
			result = firstNumber + secondNumber;
			operacao = Integer.toString(firstNumber) + "+" + Integer.toString(secondNumber);
			break;
		}
		case 2:{ 
			result = firstNumber - secondNumber;
			operacao = Integer.toString(firstNumber) + "-" + Integer.toString(secondNumber);
			break;
		}
		case 3:{
			result = firstNumber * secondNumber;
			operacao = Integer.toString(firstNumber) + "*" + Integer.toString(secondNumber);
			break;
		}
		case 4:{
			result = firstNumber / secondNumber;
			operacao = Integer.toString(firstNumber) + "/" + Integer.toString(secondNumber);
			break;
		}

		}

		embaralharResposta();

	}

	public int getResult() {
		return result;
	}

	public int getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public String getOperacao() {
		return operacao;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}

}
