package imc_calculator.services;

import imc_calculator.entities.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HistoricoService {

    private final List<Person> historico = new ArrayList<>();

    public void adicionar(Person person) {
        historico.add(person);
    }

    public List<Person> listarTodos() {
        // retorna cópia invertida (mais recente primeiro) para facilitar a leitura na tela
        List<Person> copia = new ArrayList<>(historico);
        Collections.reverse(copia);
        return copia;
    }

    public void limpar() {
        historico.clear();
    }

    public boolean isEmpty() {
        return historico.isEmpty();
    }

    public int total() {
        return historico.size();
    }
}

