package br.com.m3s01exercicio_semana.m3s01.controller;

import br.com.m3s01exercicio_semana.m3s01.entities.Despesas;
import br.com.m3s01exercicio_semana.m3s01.services.DespesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesa")

public class DespesaController {

    private DespesaService despesaService;

    public  DespesaController(DespesaService despesaService){
        this.despesaService = despesaService;
    }

    @GetMapping
    public List<Despesas> get(){
        return  despesaService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        try {
            Despesas despesas = despesaService.getById(id);
            return ResponseEntity.ok(despesas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Despesas despesas) {
        try {
            despesas.setId(null);
            return ResponseEntity.ok(despesaService.save(despesas));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Despesas despesas) {
        try {
            despesas.setId(id);
            return ResponseEntity.ok(despesaService.save(despesas));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(despesaService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
