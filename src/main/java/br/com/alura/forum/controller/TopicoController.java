package br.com.alura.forum.controller;

import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.topico.dto.*;
import br.com.alura.forum.domain.topico.repositorio.TopicoRepository;
import br.com.alura.forum.domain.topico.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService topicoService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DetalhamentoTopico dados) {

        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Topico já cadastrado,  mesma mensagem e titulo");
        }

        topicoService.save(dados);

        var retornoTopico = new DadosToDadosTopicos(dados.titulo(), dados.mensagem() , dados.autor().getNome() , dados.curso().getNome());

        return ResponseEntity.ok(new DadosTopicos(retornoTopico));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhamentoTopicoToStatusEDataCriacao>> buscarTodos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable pageable) {

        var page = repository.findAllByStatusTrueOrderByDataCriacaoAsc(pageable).map(DetalhamentoTopicoToStatusEDataCriacao::new);

        return  ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTodosPorId(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        Optional<Topico> topicoOptional = repository.findById(id);

        if (!topicoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Tópico não encontrado");
        }

        return ResponseEntity.ok(new DetalhamentoTopicoToStatusEDataCriacao(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarTopico(@RequestBody @Valid DetalhamentoTopicoId dados, @PathVariable Long id) {

        Optional<Topico> topicoOptional = repository.findById(id);

        if (!topicoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Tópico não encontrado");
        }

        if (!dados.id().equals(id)){
            return ResponseEntity.status(404).body("O id da URL está diferente do id do JSON");
        }

        var topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosToDadosTopicos(dados.titulo(), dados.mensagem() , dados.autor().getNome() , dados.curso().getNome()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {

        Optional<Topico> topicoOptional = repository.findById(id);

        if (!topicoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Tópico não encontrado");
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

