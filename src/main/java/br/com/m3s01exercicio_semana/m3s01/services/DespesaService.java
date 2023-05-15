package br.com.m3s01exercicio_semana.m3s01.services;

import br.com.m3s01exercicio_semana.m3s01.entities.Despesas;
import br.com.m3s01exercicio_semana.m3s01.repositories.DespesaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesas save(Despesas despesas) throws Exception {

        if (despesas.getId() != null && !despesaRepository.existsById(despesas.getId())) {
            throw new Exception("Pendente!");
        }

        if (despesas.getCredor() == null || despesas.getCredor().isEmpty()) {
            throw new Exception("Credor é obrigatório!");
        }

        if (despesas.getDataVencimento() == null) {
            throw new Exception("Data de Vencimento é necessária");
        }

        if (despesas.getDataPagamento() == null) {
            throw new Exception("Data de Pagamento é necessária");
        }

        if (despesas.getValor() == null || despesas.getValor() <= 0) {
            throw new Exception("Valor deve ser maior que zero!!");
        }

        despesas = despesaRepository.save(despesas);

        return despesas;
    }

    public List<Despesas> getAll() {
        return despesaRepository.findAll();
    }

    public Despesas getById(Long id) throws Exception {
        Optional<Despesas> despesaOpt = despesaRepository.findById(id);
        if (despesaOpt.isEmpty()) {
            throw new Exception("Despesa não encontrada!");
        }
        return despesaOpt.get();
    }

    public boolean delete(Long id) throws Exception {
        Despesas despesas = getById(id);
        try {
            despesaRepository.delete(despesas);
            return true;
        } catch (Exception e) {
            throw new Exception("Algo de errado não está certo!");
        }
    }
}
