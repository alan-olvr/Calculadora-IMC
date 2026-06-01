package entities;

public class Person {

    //atributos principais
    private String nome, classificacao;
    private double peso, imc;
    private double altura;

    //construtor
    public Person(String nome, Double peso, Double altura){
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    //getters e setters dos atributos encapsulados
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
}
