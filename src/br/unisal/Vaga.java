package br.unisal;

import java.util.Date;

public class Vaga {
	private Carro carro;
	private Date data;
	private String posicao;
	
	public Vaga(String posicao){
		this.posicao = posicao;
	}
	
	public void ocupar(Carro carro){
		this.carro = carro;
		this.data = new Date();
	}
	
	public void desocupar(){
		this.carro = null;
		this.data = null;
	}
	
	public Carro getCarroEstacionado(){
		return this.carro;
	}
	
	public int periodoEstacionado(){
		int periodoEmHoras = 0;
		
		if (this.data != null){
			Date dataAtual = new Date();
			
//			periodoEmHoras = (int) (dataAtual.getTime() - this.data.getTime())/(1000 * 60 * 60); 
			
			//	para teste usa segundos.
			periodoEmHoras = 1 + (int) ((dataAtual.getTime() - this.data.getTime())/(1000 * 30));
		}
		return periodoEmHoras;
	}
	
	public boolean estaOcupada(){
		if (this.carro != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isCarroEstacionado(Carro carroProcurado){
		boolean retorno = false;
		
		if (this.carro != null && this.carro.getPlaca().equals(carroProcurado.getPlaca())){
			retorno = true;
		}
		return retorno;
	}
	
	public double getValorTotal(double valorHora){
		return this.periodoEstacionado() * valorHora;
	}
	
	public String toString(){
		return "Vaga: " + this.posicao + ", " +
				this.carro.toString() + ", " +
				"\nData Entrada: " +  this.data + "\n";
	}
}