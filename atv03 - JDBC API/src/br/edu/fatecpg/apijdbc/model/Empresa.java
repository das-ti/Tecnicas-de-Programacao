package br.edu.fatecpg.apijdbc.model;

public class Empresa {
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String logradouro;
    private qsa; //(Uma List de objetos do tipo Socio)

    qsa = ArrayList<Socio> listaSocios = new ArrayList<>();

    public Empresa(String cnpj, String razao_social, String nome_fantasia, String logradouro, ArrayList<Socio> listaSocios) {
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.logradouro = logradouro;
        this.listaSocios = listaSocios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public ArrayList<Socio> getListaSocios() {
        return listaSocios;
    }

    public void setListaSocios(ArrayList<Socio> listaSocios) {
        this.listaSocios = listaSocios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cnpj='" + cnpj + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", listaSocios=" + listaSocios +
                '}';
    }
}

