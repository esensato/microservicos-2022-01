package calculadora;

public class Calculadora {
	
	private Operacao operacao;
	
	private float n1;
	
	private float n2;
	
	float executar (float n1, float n2) {
		return operacao.executar(n1, n2);
	}

	float executar () {
		return operacao.executar(n1, n2);
	}

	public float getN1() {
		return n1;
	}

	public void setN1(float n1) {
		this.n1 = n1;
	}

	public float getN2() {
		return n2;
	}

	public void setN2(float n2) {
		this.n2 = n2;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	
	
}
