package br.com.aj_sistemas.logistica.controller;

import java.util.ArrayList;
import br.com.aj_sistemas.logistica.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.aj_sistemas.logistica.model.RotaModel;

/**
 *
 * @author Alisson Jaques
 */
public class RotaController {

    public boolean inserirComProcedure(RotaModel rota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call inserirRota(?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, rota.getDescricao());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean inserir(RotaModel rota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "insert into rota (idrota, descricao) values (?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, rota.getIdRota());
            sentenca.setString(2, rota.getDescricao());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean editarComProcedure(RotaModel rota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call editarRota(?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, rota.getIdRota());
            sentenca.setString(2, rota.getDescricao());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public String editar(RotaModel rota) {
        String retorno = "Erro ao Atualizar!";
        Conexao.conectar();
        String sql = "update rota set descricao = ? where idrota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, rota.getDescricao());
            sentenca.setInt(2, rota.getIdRota());
            if (!sentenca.execute()) {
                retorno = "Atualizado com sucesso!";
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean excluir(RotaModel rota) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "delete from rota where idrota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, rota.getIdRota());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public RotaModel selecionar(RotaModel rota) {
        RotaModel retorno = null;
        Conexao.conectar();
        String sql = "select * from rota where idrota = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, rota.getIdRota());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                retorno = new RotaModel();
                retorno.setIdRota(rs.getInt(1));
                retorno.setDescricao(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<RotaModel> selecionarTodos() {
        ArrayList<RotaModel> lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "select * from rota";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                RotaModel retorno = new RotaModel();
                retorno.setIdRota(rs.getInt(1));
                retorno.setDescricao(rs.getString(2));
                lista.add(retorno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<String> selecionaRotas() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("");
        String sql = "select descricao from rota";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<Integer> selecionaIdRotas() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        String sql = "select idrota from rota order by idrota";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }
}
