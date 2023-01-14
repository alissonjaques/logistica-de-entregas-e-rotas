package model;

/**
 *
 * @author Alisson Jaques
 */
public class VeiculoModel {

    private int idVeiculo;
    private String modelo;
    private String placa;
    private MotoristaModel motorista;

    public VeiculoModel(int idVeiculo, String modelo, String placa, MotoristaModel motorista) {
        this.idVeiculo = idVeiculo;
        this.modelo = modelo;
        this.placa = placa;
        this.motorista = motorista;
    }

    public VeiculoModel() {
        motorista = new MotoristaModel();
    }

    /**
     * @return the idVeiculo
     */
    public int getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the motorista
     */
    public MotoristaModel getMotorista() {
        return motorista;
    }

    /**
     * @param motorista the motorista to set
     */
    public void setMotorista(MotoristaModel motorista) {
        this.motorista = motorista;
    }
}
