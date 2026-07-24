package imc_calculator.entities;

public class Person {

    private String nome, classificacao;
    private double peso, imc;
    private double altura;

    public Person(String nome, Double peso, Double altura){
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getStatusCssClass() {
        if (classificacao == null) return "";
        return switch (classificacao) {
            case "Abaixo do peso" -> "status-abaixo";
            case "Normal" -> "status-normal";
            case "Sobrepeso" -> "status-sobrepeso";
            case "Obesidade Grau I" -> "status-obesidade-1";
            case "Obesidade Grau II" -> "status-obesidade-2";
            case "Obesidade Grau III" -> "status-obesidade-3";
            default -> "";
        };
    }
}
