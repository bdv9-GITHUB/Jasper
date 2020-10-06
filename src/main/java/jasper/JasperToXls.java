package jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import java.util.HashMap;
import java.util.Map;

public class JasperToXls {
    public JasperToXls() {
    }

    @SuppressWarnings("unchecked")
    public static void exportToXls(String jrxmlFile, String xlsFile, JRDataSource dataSource) throws JRException {
        // Готовим параметры для отчета (заголовок и т.д.)
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Коммерческое предложение");

        // Компилируем jrxml в бинарный формат jasper
        //String jrxmlFile = "c:\\temp\\TextReport.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile);

        // Получаем отчет на основе шаблона (jrxml) и коллекции с данными
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        /*// Экспорт в pdf
        String pdfFile = "c:\\temp\\TextReport.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);*/

        // Отображение в стандартном просмотрщике
        /*JasperViewer jasperViewer = new JasperViewer(jasperPrint);
        jasperViewer.setVisible(true);*/

        // Готовим экспорт в Excel
        //String xlsFile = "c:\\temp\\TextReport.xls";
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, xlsFile);
        exporter.exportReport();
    }
}
