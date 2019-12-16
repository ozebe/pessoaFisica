package control;

/**
 *
 * @author wesley.santos
 */
public class PessoaFisica extends Pessoa {

    private int id;
    private String nome;
    private String CPF;
    private String dataNascimento;
    private String Sexo;
    private Escolaridade escolaridade;
    private Profissao profissao;
    
    public PessoaFisica(String nome, String CPF, String dataNascimento, String Sexo, Endereco endereco, Contato contato) {
        super(endereco, contato);
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.Sexo = Sexo;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
    
    
}
