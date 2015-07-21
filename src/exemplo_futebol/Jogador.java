package exemplo_futebol;

public class Jogador {
	
	private String nome;
	private int gols;
	private Posicao posicao;

	public Jogador(String nome, int gols, Posicao posicao) {
		this.nome = nome;
		this.gols = gols;
		this.posicao = posicao;
	}

	public String getNome() {
		return nome;
	}

	public int getGols() {
		return gols;
	}

	public Posicao getPosicao() {
		return posicao;
	}
}