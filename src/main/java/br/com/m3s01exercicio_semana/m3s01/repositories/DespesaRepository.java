package br.com.m3s01exercicio_semana.m3s01.repositories;

import br.com.m3s01exercicio_semana.m3s01.entities.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository  extends JpaRepository<Despesas, Long> {
}
