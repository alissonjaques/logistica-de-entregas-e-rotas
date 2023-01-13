package model;

/**
 *
 * @author Alisson Jaques
 */
public class MotoristaModel {
    private int idMotorista;
    private String nome;
    private String cnh;
    private int idade;
    
    public MotoristaModel(int idMotorista, String nome, String cnh, int idade){
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.cnh = cnh;
        this.idade = idade;        
    }
    
    public MotoristaModel(){
        
    }

    /**
     * @return the idmotorista
     */
    public int getIdMotorista() {
        return idMotorista;
    }

    /**
     * @param idmotorista the idmotorista to set
     */
    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cnh
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * @param cnh the cnh to set
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }    
}
