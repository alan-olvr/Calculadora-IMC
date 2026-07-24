package imc_calculator;

import imc_calculator.entities.Person;
import imc_calculator.services.Calculator;
import imc_calculator.services.HistoricoService;
import imc_calculator.services.TabelaReferencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImcController {

    private final HistoricoService historicoService;
    private final TabelaReferencia tabelaReferenciaService;

    public ImcController(HistoricoService historicoService, TabelaReferencia tabelaReferenciaService) {
        this.historicoService = historicoService;
        this.tabelaReferenciaService = tabelaReferenciaService;
    }

    @GetMapping("/")
    public String exibirFormulario() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularImc(
            @RequestParam("nome") String nome,
            @RequestParam("peso") double peso,
            @RequestParam("altura") double altura,
            Model model) {

        Person person = new Person(nome, peso, altura);
        Calculator calc = new Calculator(person);

        calc.calcularImc();
        calc.classificaImc();

        historicoService.adicionar(person);

        model.addAttribute("person", person);
        model.addAttribute("imcFormatado", String.format("%.1f", person.getImc()));
        model.addAttribute("mensagem", calc.imcMessage());
        model.addAttribute("gaugePercent", calcularPosicaoGauge(person.getImc()));

        return "resultado";
    }

    private String calcularPosicaoGauge(double imc) {
        double min = 10.0, max = 45.0;
        double clamped = Math.max(min, Math.min(max, imc));
        double percent = ((clamped - min) / (max - min)) * 100.0;
        return String.format(java.util.Locale.US, "%.1f", percent);
    }

    @GetMapping("/tabela")
    public String exibirTabela(Model model) {
        model.addAttribute("faixas", tabelaReferenciaService.obterFaixas());
        return "tabela";
    }

    @GetMapping("/historico")
    public String exibirHistorico(Model model) {
        model.addAttribute("consultas", historicoService.listarTodos());
        return "historico";
    }

    @PostMapping("/historico/limpar")
    public String limparHistorico() {
        historicoService.limpar();
        return "redirect:/historico";
    }

    @GetMapping("/sobre")
    public String exibirSobre() {
        return "sobre";
    }
}