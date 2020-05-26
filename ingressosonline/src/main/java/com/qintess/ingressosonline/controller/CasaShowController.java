package com.qintess.ingressosonline.controller;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.ingressosonline.entity.CasaShow;
import com.qintess.ingressosonline.entity.Usuario;
import com.qintess.ingressosonline.service.CasaShowService;

@Component // para indicar pro spring que Ã© um componente
@RestController // para indicar que Ã© um controller
@RequestMapping("/casashow")  // para indicar a url que irÃ¡ ser acessada
public class CasaShowController {
	
	@Autowired
	private CasaShowService service;
	
	/*@GetMapping("/casashow/lista")    //desnecessario banco em update
	public List<CasaShow> CasaShow(){
		List<CasaShow> casashow = new ArrayList<CasaShow>();
		casashow.add(new CasaShow("Teatro São José", "I de Maio","32143234", "222234-111", "Sorocaba", "São Paulo"));
		casashow.add(new CasaShow("Teatro Guarani", "XV de Novembro","32143234", "444332-000", "São Paulo", "São Paulo"));
		casashow.add(new CasaShow("Teatro Vasconceloz", "Francico Teixeira", "32143234","876332-080", "Rio de Janeiro", "Rio de Janeiro"));
		casashow.add(new CasaShow("Teatro Morumbi", "Sergio Amaral", "32143234", "984332-004", "Recife", "Recife"));
		casashow.add(new CasaShow("Teatro Municipal", "Eugenia da Silva", "32143234", "494331-765", "Santa Catarina", "Santa Catarina"));
		return casashow;
	} */ 	
	
	@GetMapping({"/"}) //--> aqui indica o tipo do metodo, ele serÃ¡ um Get (somente consulta)
	public ResponseEntity<List<CasaShow>> findAll(){ // --> aqui vc passa como ResponseEntity, ele que farÃ¡ o retorno
		return ResponseEntity.ok().body(service.buscarTodos()); //--> aqui vc retorna um ok e no corpo (body) retorna o conteudo que vier do service
	}
	@GetMapping({"{id}"}) //--> aqui indica o tipo do metodo, ele serÃ¡ um Get (somente consulta)
	public ResponseEntity<Object> findById(@PathVariable(name="id") Long id){ // --> aqui vc passa como ResponseEntity, ele que farÃ¡ o retorno
		return ResponseEntity.ok().body(service.buscarPorId(id)); //--> aqui vc retorna um ok e no corpo (body) retorna o conteudo que vier do service
	}
	
	@PostMapping({"/"}) //-->cadastrar um new object
	public ResponseEntity<CasaShow> create(@RequestBody CasaShow casashow) {
		return ResponseEntity.ok().body(service.salvar(casashow));
	}
	@DeleteMapping({"/{id}"}) //--> deletar um objeto
	public ResponseEntity<Usuario> delete(@PathVariable("id") Long id) {
		service.deleteId(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping({"/{id}"}) //atualizar e salvar
	public void alterar (@PathVariable(name="id") Long id,
						 @RequestBody CasaShow casashow) {
			service.atualizar(casashow, id);
    }
}
