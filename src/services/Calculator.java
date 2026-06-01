package services;
import entities.Person;
import java.lang.Math;

public class Calculator {
    Person person;

    public Calculator(Person person) {
        this.person = person;
    }

    public double calcularImc() {
        Double imc = person.getPeso() / Math.pow(person.getAltura(), 2);
        person.setImc(imc);
        return person.getImc();
    }

    public String classificaImc() {
        if (person.getImc() < 18.5) {
            person.setClassificacao("Abaixo do peso");
            return person.getClassificacao();
        }
        else if (person.getImc() >= 18.5 && person.getImc() <= 24.9) {
            person.setClassificacao("Normal");
            return person.getClassificacao();
        }
        else if (person.getImc() >= 25.0 && person.getImc() <= 29.9) {
            person.setClassificacao("Sobrepeso");
            return person.getClassificacao();
        }
        else if (person.getImc() >= 30.0 && person.getImc() <= 34.9) {
            person.setClassificacao("Obesidade Grau I");
            return person.getClassificacao();
        }
        else if (person.getImc() >= 35.0 && person.getImc() <= 39.9) {
            person.setClassificacao("Obesidade Grau II");
            return person.getClassificacao();
        }
        person.setClassificacao("Obesidade Grau III");
        return person.getClassificacao();
    }

    public String imcMessage() {
        if("Abaixo do peso".equals(person.getClassificacao())) {
            return "Atenção. Pequenas adequações na rotina diária e alimentar podem prevenir riscos futuros";
        } else if("Normal".equals(person.getClassificacao())) {
            return "Parabéns! Seu IMC está dentro do intervalo ideal. Mantenha seus hábitos saudáveis.";
        } else if("Sobrepeso".equals(person.getClassificacao())) {
            return "Atenção. Pequenas adequações na rotina diária e alimentar podem prevenir riscos futuros";
        }
        return "Recomendação: É altamente aconselhável buscar a orientação de um profissional de saúde qualificado.";
    }

}
