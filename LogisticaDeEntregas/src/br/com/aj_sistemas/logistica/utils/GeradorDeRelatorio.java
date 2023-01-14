package br.com.aj_sistemas.logistica.utils;

/**
 *
 * @author Cris
 */
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GeradorDeRelatorio {

    public void relatorio(String nomeRelatorio, String chave, String parametro) {
        Conexao.conectar();
        try {

            Map<String, Object> parameters = new HashMap<>();
            //parameters.put(chave, parametro);

            JasperCompileManager.compileReportToFile(nomeRelatorio + ".jrxml");
            JasperPrint print = JasperFillManager.fillReport(nomeRelatorio + ".jasper", parameters, Conexao.con);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
            JasperExportManager.exportReportToPdfFile(print, nomeRelatorio + ".pdf");

        } catch (JRException e) {
            throw new RuntimeException("Impossível abrir relatório! ", e);
        } finally {
            if (Conexao.con != null) {
                Conexao.desconectar();
            }
        }

    }
}

