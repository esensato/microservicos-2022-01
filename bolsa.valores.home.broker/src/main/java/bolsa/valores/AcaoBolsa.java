package bolsa.valores;

public class AcaoBolsa {
	
	public static final String[] IDS = {"VALE3", "ITUB4", "PETR4", "BBDC4", "XPTO"};
	
	public String id;
	
	public float cotacao;
	
	public AcaoBolsa() {
		super();
	}

	public AcaoBolsa(String id, float cotacao) {
		this.id = id;
		this.cotacao = cotacao;
	}

}
