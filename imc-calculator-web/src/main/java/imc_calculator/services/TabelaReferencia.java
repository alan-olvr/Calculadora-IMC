package imc_calculator.services;

import imc_calculator.entities.ImcRange;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TabelaReferencia {
    public List<ImcRange> obterFaixas() {
        return List.of(
                new ImcRange("< 18.5", "Abaixo do peso", "status-abaixo"),
                new ImcRange("18.5 – 24.9", "Normal", "status-normal"),
                new ImcRange("25.0 – 29.9", "Sobrepeso", "status-sobrepeso"),
                new ImcRange("30.0 – 34.9", "Obesidade Grau I", "status-obesidade-1"),
                new ImcRange("35.0 – 39.9", "Obesidade Grau II", "status-obesidade-2"),
                new ImcRange(">= 40.0", "Obesidade Grau III", "status-obesidade-3")
        );
    }
}