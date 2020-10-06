package jasper;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class JasperToXlsTest {
    @Test
    @DisplayName("Тест экспорта в Excel")
    public void testJasperToXls() throws IOException, JRException {
        long time = System.currentTimeMillis();

        // Готовим коллекцию с данными
        ArrayList<DataBean> dataBeans = new DataBeanList().getDataBeanList();
        JRDataSource dataSource = new JRBeanCollectionDataSource(dataBeans);

        // Экспортируем шаблон jrxml в Excel с указанным источником данных
        String jrxmlFile = "c:\\temp\\TextReport.jrxml";
        String xlsFile = "c:\\temp\\TextReport.xls";
        JasperToXls.exportToXls(jrxmlFile, xlsFile, dataSource);

        // Проверяем размер файла и время создания
        BasicFileAttributes attrs = Files.readAttributes(Paths.get(xlsFile), BasicFileAttributes.class);
        Assertions.assertTrue(attrs.size() > 0);
        Assertions.assertTrue(attrs.lastModifiedTime().toMillis() > time);
    }
}
