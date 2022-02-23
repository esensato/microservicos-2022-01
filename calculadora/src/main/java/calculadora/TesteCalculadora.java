package calculadora;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteCalculadora {

	public static void main(String[] args) {

		// Somar somar = new Somar();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Operacao op = (Operacao) ctx.getBean("subtrair");
		
		System.out.println(op.executar(10.0f, 20.0f));
		
		Calculadora calculadora = (Calculadora) ctx.getBean("calculadora");
		
		System.out.println(calculadora.executar(10.0f, 20.f));
		System.out.println(calculadora.executar());
	}

}
