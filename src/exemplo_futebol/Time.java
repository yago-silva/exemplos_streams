package exemplo_futebol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Time {
	private List<Jogador> jogadores = Arrays.asList(new Jogador("Pelé", 1000, Posicao.ATACANTE),
			new Jogador("Matheus", 2000, Posicao.GOLEIRO),
			new Jogador("Hanna", 10000, Posicao.MEIO));
	
	public List<Jogador> getAtacantes(){
		return jogadores.stream()
		.filter(j -> j.getPosicao().equals(Posicao.ATACANTE))
		.collect(Collectors.toList());
	}
	
	public List<Jogador> jogadoresOrdenadosPorNome(){
		return jogadores
					.stream()
					.sorted(Comparator.comparing(Jogador::getNome))
					.collect(Collectors.toList());
	}
	
	public List<Jogador> jogadoresOrdenadosPorNomeOrdemReversa(){
		return jogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getNome).reversed())
				.collect(Collectors.toList());
	}
	
	public List<Jogador> jogadoresOrdenadosPorNomeENumeroDeGols(){
		return jogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getNome)
						.thenComparing(Comparator.comparing(Jogador::getNome)))
				.collect(Collectors.toList());
	}
	
	public boolean todosFizeramGols(){
		return jogadores
				.stream()
				.allMatch(jogador -> jogador.getGols() > 0);
	}
	
	public boolean podeIrAoFantastico(){
		return jogadores
				.stream()
				.anyMatch(jogador -> jogador.getGols() > 3);
	}
	
	public boolean nenhumGolContra(){
		return jogadores
				.stream()
				.noneMatch(jogador -> jogador.getGols() < 0);
	}
	
	public List<String> nomesDosJogadores(){
		return jogadores
				.stream()
				.map(Jogador::getNome)
				.collect(Collectors.toList());
	}
	
	public String escalacao(){
		return jogadores
				.stream()
				.map(Jogador::getNome)
				.collect(Collectors.joining(","));
	}
	
	public Integer somatoriaDosGols(){
		return jogadores
				.stream()
				.mapToInt(Jogador::getGols)
				.sum();
	}
	
	public Integer min(){
		return jogadores
				.stream()
				.mapToInt(Jogador::getGols)
				.min().getAsInt();
	}
	
	public Integer max(){
		return jogadores
				.stream()
				.mapToInt(Jogador::getGols)
				.max().getAsInt();
	}
	
	
	public Map<Posicao, List<Jogador>> jogadoresPorPosicao(){
		return jogadores
				.stream()
				.collect(Collectors.groupingBy(Jogador::getPosicao));
	}
	
	public Map<Boolean, List<Jogador>> jogadoresQueVaoParaOFantastico(){
		 return jogadores
				.stream()
				.collect(Collectors.partitioningBy(jogador -> jogador.getGols() > 3));
	}
	
	public Map<Boolean, List<String>> nomesJogadoresQueVaoParaOFantastico(){
		 return jogadores
				.stream()
				.collect(Collectors.partitioningBy(jogador -> jogador.getGols() > 3 ,Collectors.mapping(Jogador::getNome, Collectors.toList())));
	}
}
	