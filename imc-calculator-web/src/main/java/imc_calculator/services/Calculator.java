    package imc_calculator.services;

    import imc_calculator.entities.Person;

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
            } else if (person.getImc() >= 18.5 && person.getImc() <= 24.9) {
                person.setClassificacao("Normal");
            } else if (person.getImc() >= 25.0 && person.getImc() <= 29.9) {
                person.setClassificacao("Sobrepeso");
            } else if (person.getImc() >= 30.0 && person.getImc() <= 34.9) {
                person.setClassificacao("Obesidade Grau I");
            } else if (person.getImc() >= 35.0 && person.getImc() <= 39.9) {
                person.setClassificacao("Obesidade Grau II");
            } else {
                person.setClassificacao("Obesidade Grau III");
            }
            return person.getClassificacao();
        }

        public String imcMessage() {
            String c = person.getClassificacao();
            if ("Abaixo do peso".equals(c) || "Sobrepeso".equals(c)) {
                return "Atenção. Pequenas adequações na rotina diária e alimentar podem prevenir riscos futuros";
            } else if ("Normal".equals(c)) {
                return "Parabéns! Seu IMC está dentro do intervalo ideal. Mantenha seus hábitos saudáveis.";
            }
            return "Recomendação: É altamente aconselhável buscar a orientação de um profissional de saúde qualificado.";
        }
    }
