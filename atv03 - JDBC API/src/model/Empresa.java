package model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Empresa {

    private String cnpj;

    @SerializedName("razao_social")
    private String razaoSocial;

    @SerializedName("nome_fantasia")
    private String nomeFantasia;

    private String logradouro;
    private String municipio;
    private String uf;
    private String cep;

    private List<Socio> qsa;

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public List<Socio> getQsa() { return qsa; }
    public void setQsa(List<Socio> qsa) { this.qsa = qsa; }
}
