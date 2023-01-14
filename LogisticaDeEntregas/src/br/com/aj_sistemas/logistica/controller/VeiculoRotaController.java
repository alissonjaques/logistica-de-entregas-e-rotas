package br.com.aj_sistemas.logistica.controller;

import java.util.ArrayList;
import br.com.aj_sistemas.logistica.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.aj_sistemas.logistica.model.VeiculoRotaModel;

/**
 *
 * @author Alisson Jaques
 */
public class VeiculoRotaController {

    public boolean inserirComProcedure(VeiculoRotaModel veiculoRota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call inserirVeiculoRota(?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getRota().getIdRota());
            sentenca.setInt(2, veiculoRota.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean inserir(VeiculoRotaModel veiculoRota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "insert into veiculo_rota (idveiculo_rota,idrota,id_veiculo) values (?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getIdVeiculoRota());
            sentenca.setInt(2, veiculoRota.getRota().getIdRota());
            sentenca.setInt(3, veiculoRota.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean editarComProcedure(VeiculoRotaModel veiculoRota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call editarVeiculoRota(?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getIdVeiculoRota());
            sentenca.setInt(2, veiculoRota.getRota().getIdRota());
            sentenca.setInt(3, veiculoRota.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public String editar(VeiculoRotaModel veiculoRota) {
        String retorno = "Erro ao Atualizar!";
        Conexao.conectar();
        String sql = "update veiculo_rota set idrota = ?, id_veiculo = ? where idveiculo_rota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getRota().getIdRota());
            sentenca.setInt(2, veiculoRota.getVeiculo().getIdVeiculo());
            sentenca.setInt(3, veiculoRota.getIdVeiculoRota());
            if (!sentenca.execute()) {
                retorno = "Atualizado com sucesso!";
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean excluir(VeiculoRotaModel veiculoRota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "delete from veiculo_rota where idveiculo_rota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getIdVeiculoRota());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public VeiculoRotaModel selecionar(VeiculoRotaModel veiculoRota) {
        VeiculoRotaModel retorno = null;
        Conexao.conectar();
        String sql = "select * from veiculo_rota where idveiculo_rota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculoRota.getIdVeiculoRota());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                retorno = new VeiculoRotaModel();
                retorno.setIdVeiculoRota(rs.getInt(1));
                retorno.getRota().setIdRota(rs.getInt(2));
                retorno.getVeiculo().setIdVeiculo(rs.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<VeiculoRotaModel> selecionarTodos() {
        ArrayList<VeiculoRotaModel> lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "select * from veiculo_rota";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                VeiculoRotaModel retorno = new VeiculoRotaModel();
                retorno.setIdVeiculoRota(rs.getInt(1));
                retorno.getRota().setIdRota(rs.getInt(2));
                retorno.getVeiculo().setIdVeiculo(rs.getInt(3));
                lista.add(retorno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<VeiculoRotaModel> selecionaView() {
        ArrayList<VeiculoRotaModel> lista = new ArrayList<>();
        String sql = "select * from vw_veiculo_rota order by idveiculo_rota";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                VeiculoRotaModel fa = new VeiculoRotaModel();
                fa.setIdVeiculoRota(rs.getInt(1));
                fa.getVeiculo().setPlaca(rs.getString(2));
                fa.getRota().setDescricao(rs.getString(3));
                lista.add(fa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }
}
