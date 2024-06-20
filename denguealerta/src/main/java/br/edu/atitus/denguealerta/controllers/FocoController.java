package br.edu.atitus.denguealerta.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.denguealerta.dtos.FocoDTO;
import br.edu.atitus.denguealerta.entities.FocoEntity;
import br.edu.atitus.denguealerta.entities.UsuarioEntity;
import br.edu.atitus.denguealerta.services.FocoService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ws/foco")
public class FocoController {
	
	private final FocoService focoService;

	public FocoController(FocoService focoService) {
		super();
		this.focoService = focoService;
	}
	
	@GetMapping
	public ResponseEntity<Page<FocoEntity>> getFindAll(	
			@PageableDefault(page = 0,size = 5,sort = "data", direction = Direction.ASC)
			Pageable pageable) throws Exception {
		Page<FocoEntity> focos = this.focoService.findAll(pageable);
		return ResponseEntity.ok(focos);
	}
	
	@PostMapping()
	public ResponseEntity<FocoEntity> postSave(@RequestBody FocoDTO dto) throws Exception {
		FocoEntity novoFoco = new FocoEntity();
		BeanUtils.copyProperties(dto, novoFoco);
		var user = (UsuarioEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		novoFoco.setUsuario(user);
		novoFoco.setData(LocalDate.now());
		this.focoService.save(novoFoco);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFoco);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> trataExceptions(Exception e) {
		String cleanMessage = e.getMessage().replaceAll("\\r\\n", "");
		return ResponseEntity.badRequest().body(cleanMessage);
	}

}
