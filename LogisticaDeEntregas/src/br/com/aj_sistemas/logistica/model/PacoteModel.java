package br.com.aj_sistemas.logistica.model;

/**
 *
 * @author Alisson Jaques
 */
public class PacoteModel {
    private int idPacote;
    private String descricao;
    private double peso;
    private double volume;
    private String destinatario;
    private VeiculoModel veiculo;
    
    public PacoteModel(int idPacote, String descricao, double peso, double volume, 
            String destinatario, VeiculoModel veiculo){
        this.idPacote = idPacote;
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
        this.destinatario = destinatario;
        this.veiculo = veiculo;
    }
    
    public PacoteModel(){
        veiculo = new VeiculoModel();
    }

    /**
     * @return the idpacote
     */
    public int getIdPacote() {
        return idPacote;
    }

    /**
     * @param idpacote the idpacote to set
     */
    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @return the veiculo
     */
    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }
}
