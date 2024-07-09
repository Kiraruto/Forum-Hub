package br.com.alura.forum.controller;

import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.resposta.dto.DadosRespostas;
import br.com.alura.forum.domain.resposta.dto.DetalhamentoResposta;
import br.com.alura.forum.domain.resposta.dto.DetalharRetornoResposta;
import br.com.alura.forum.domain.resposta.repositorio.RespostaRepository;
import br.com.alura.forum.domain.resposta.service.RespostaService;
import br.com.alura.forum.domain.topico.repositorio.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarResposta(@Valid @RequestBody DetalhamentoResposta dados) {

        if (respostaRepository.existsByMensagem(dados.mensagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Resposta já cadastrada");
        }

        respostaService.saveResposta(dados);

        var retornnoResposta = new DadosRespostas(dados);

        return ResponseEntity.status(200).body(retornnoResposta);

    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getRespostasPeloId(@PathVariable Long Id) {

        var resposta = respostaRepository.findByTopicoId(Id);

        Optional<Resposta> respostaOptional = resposta.stream().findAny();

        if (!respostaOptional.isPresent()) {
            return ResponseEntity.status(404).body("Respostas não encontrado");
        }

        DetalharRetornoResposta detalhes = new DetalharRetornoResposta(resposta);

        return ResponseEntity.status(200).body(detalhes);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {

        Optional<Resposta> topicoOptional = respostaRepository.findById(id);

        if (!topicoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Resposta não encontrado");
        }

        respostaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
