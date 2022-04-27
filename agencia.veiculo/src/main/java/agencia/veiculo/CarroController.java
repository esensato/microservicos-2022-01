package agencia.veiculo;

import java.util.Random;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {
	
	@Autowired
	private CarroDAO dao;
	
	@Value("${carro.totalDigitos}")
	private int totalDigitos;
	
	@GetMapping("/carro/listar")
	public ResponseEntity<Iterable<Carro>> getAll() {
		return new ResponseEntity<Iterable<Carro>>(dao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/carro/placa")
	public ResponseEntity<String> getPlaca() {
		Random sorteio = new Random();
		String placa = "";
		for (int i = 0; i < totalDigitos; i++) {
			int letra = sorteio.nextInt(25) + 65;
			int numero = sorteio.nextInt(10);
			placa += numero < 5 ? (char) letra : "" + numero; 
		}
		return new ResponseEntity<String>(placa, HttpStatus.OK);
	}
	
	@PostMapping("/carro/criar")
	public String criar(@RequestBody String carro) {
		
		System.out.println(carro);
		
		JSONObject obj = new JSONObject(carro);
		System.out.println(obj.getString("msg"));
			
		return "OK";
	}
}