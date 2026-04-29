package Model;

public class Hospede {

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String contato;
    private String IdentificacaoQuarto;
    private int numeroDiarias;
    private double saldoHosepde;

    public Hospede() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getIdentificacaoQuarto() {
        return IdentificacaoQuarto;
    }

    public void setIdentificacaoQuarto(String IdentificacaoQuarto) {
        this.IdentificacaoQuarto = IdentificacaoQuarto;
    }

    public int getNumeroDiarias() {
        return numeroDiarias;
    }


    public void setNumeroDiarias(int numeroDiarias) {
        this.numeroDiarias = numeroDiarias;
    }

    public double getSaldoHosepde() {
        return saldoHosepde;
    }

    public void setSaldoHosepde(double saldoHosepde) {
        this.saldoHosepde = saldoHosepde;
    }

    
}
