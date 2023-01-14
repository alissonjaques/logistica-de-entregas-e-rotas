package br.com.aj_sistemas.logistica.utils;

/**
 *
 * @author Cris
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GeradorDeRelatorio {

    public void relatorio(String nomeDoArquivo, String chave, String parametro) {
        Conexao.conectar();
        try {
            Map<String, Object> parameters = new HashMap<>();
            String nomeRelatorio = "src\\br\\com\\aj_sistemas\\logistica\\relatorios\\" + nomeDoArquivo;

            JasperCompileManager.compileReportToFile(nomeRelatorio + ".jrxml");
            JasperPrint print = JasperFillManager.fillReport(nomeRelatorio + ".jasper", parameters, Conexao.con);
            String aleatorio = System.getProperty("java.io.tmpdir") + "\\" + nomeDoArquivo + getAleatorio() + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, aleatorio);

            Desktop desktop = Desktop.getDesktop();
            File file = new File(aleatorio);
            desktop.open(file);
        } catch (IOException | JRException e) {
            throw new RuntimeException("Impossível abrir relatório! " + e.getMessage(), e);
        } finally {
            if (Conexao.con != null) {
                Conexao.desconectar();
            }
        }
    }

    /**
     * @return um número flutuante aletório entre 0 e 100
     */
    public static double getAleatorio() {
        Random random = new Random();
        return random.nextDouble() * 100;
    }
}
