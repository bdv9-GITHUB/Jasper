package jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.*;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

public class JasperToXls {
    public JasperToXls() {
    }

    // Экспорт шаблона формата Jasper (jrxmlFile)
    // в файл Excel (xlsFile)
    // с заполнением данными из переданного источника (dataSource)
    @SuppressWarnings("unchecked")
    public static void exportToXls(String jrxmlFile,
                                   String xlsFile,
                                   JRDataSource dataSource) throws JRException {
        // Готовим параметры для отчета (заголовок и т.д.)
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Коммерческое предложение");

        // Компилируем jrxml в бинарный формат jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile);

        // Получаем отчет на основе шаблона (jrxml) и коллекции с данными
        JasperPrint jasperPrint = JasperFillManager
                .fillReport(jasperReport, parameters, dataSource);

        // Экспорт в pdf
//        String pdfFile = "c:\\temp\\TextReport.pdf";
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);

        // Отображение в стандартном просмотрщике
//        JasperViewer jasperViewer = new JasperViewer(jasperPrint);
//        jasperViewer.setVisible(true);

        // Готовим экспорт в Excel
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsFile));
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setDetectCellType(true);
        configuration.setCollapseRowSpan(false);
        exporter.setConfiguration(configuration);

        // Экспорт в Excel
        exporter.exportReport();
    }
}
