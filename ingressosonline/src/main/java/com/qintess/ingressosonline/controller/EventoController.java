package com.qintess.ingressosonline.controller;
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

import com.qintess.ingressosonline.entity.Evento;
import com.qintess.ingressosonline.service.EventoService;

@Component // para indicar pro spring que Ã© um componente
@RestController // para indicar que Ã© um controller
@RequestMapping("/evento")  // para indicar a url que irÃ¡ ser acessada
public class EventoController {
	@Autowired
	private EventoService eventoService;
	
	@GetMapping({"/"}) //--> aqui indica o tipo do metodo, ele serÃ¡ um Get (somente consulta)
	public ResponseEntity<List<Evento>> findAll(){ // --> aqui vc passa como ResponseEntity, ele que farÃ¡ o retorno
		
		//colocar regra: apresentar só eventos validos (conformidade:data e ingresso)
		
		return ResponseEntity.ok().body(eventoService.buscarTodos()); //--> aqui vc retorna um ok e no corpo (body) retorna o conteudo que vier do service
	}
	@GetMapping({"/{id}"}) //--> aqui indica o tipo do metodo, ele serÃ¡ um Get (somente consulta)
	public ResponseEntity<Object> findById(@PathVariable(name="id") Long id){ // --> aqui vc passa como ResponseEntity, ele que farÃ¡ o retorno
		return ResponseEntity.ok().body(eventoService.buscarPorId(id)); //--> aqui vc retorna um ok e no corpo (body) retorna o conteudo que vier do service
	}
	
	@PostMapping("/") //-->cadastrar um new object
	public ResponseEntity<Evento> create(@RequestBody Evento evento) {
		return ResponseEntity.ok().body(eventoService.salvar(evento));
	}
	
	@DeleteMapping({"/{id}"}) //--> deletar um objeto
	public ResponseEntity<Evento> delete(@PathVariable("id") Long id) {
		eventoService.deleteId(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping({"/{id}"}) //deletar e salvar
	public void alterar (@PathVariable(name="id") Long id,
						 @RequestBody Evento evento) {
			eventoService.atualizar(evento, id);
    }
	
}