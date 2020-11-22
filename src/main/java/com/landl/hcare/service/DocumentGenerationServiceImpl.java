package com.landl.hcare.service;

import com.google.gson.Gson;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.hibernate.mapping.UniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class DocumentGenerationServiceImpl implements DocumentGenerationService{

    @Autowired
    PropertyService propertyService;

    public String generateDocument(String templateCode, String outputFormat, Map dataSource) throws Exception{
        String finalUrl = "";
        /*
        Map<String, Object> parametersDs = new HashMap<>();
        Patient patient = new Patient();
        patient.setFirstName("Luis");
        patient.setLastName("Martinez");
        parametersDs.put("patient", patient);
        */
        Map parametersDs = (Map)dataSource.get("dataSourceParameters");
        Gson gson = new Gson();
        String rawJsonDataSource = gson.toJson(parametersDs);

        //InputStream reportStream = new FileInputStream(ResourceUtils.getFile("classpath:documentsTemplate/"+templateCode+".jasper"));

        //InputStream reportStream = new FileInputStream(ResourceUtils.getFile("classpath:documentsTemplate/"+templateCode+".jasper"));
        String reportPath = "/Users/lmartinez/git/hcare/hcare_backend_v2_1/reports/jasper"+File.separator;
        InputStream reportStream = new FileInputStream(ResourceUtils.getFile(reportPath + templateCode+".jasper"));

        //JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
        //JRSaver.saveObject(jasperReport, "/Users/luis/Downloads/anesthesiaReport.jasper");

        //Convert json string to byte array.
        ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(rawJsonDataSource.getBytes());
        //Create json datasource from json stream
        JsonDataSource ds = new JsonDataSource(jsonDataStream);

        Map parameters = (Map)dataSource.get("reportParameters");
        parameters.put("reportPath",reportPath);
        parameters.put("dateformat",propertyService.getPropertyValue("dateformat"));
        //Add title parameter. Make sure the key is same name as what you named the parameter in jasper report.
        //parameters.put("title", "Jasper PDF Example");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        String reportOutPath = "/Users/lmartinez/git/hcare/hcare_backend_v2_1/reports/out"+File.separator;
        String uKey = UUID.randomUUID().toString();
        finalUrl = File.separator+"reportfiles"+File.separator+uKey+"."+outputFormat;
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportOutPath+uKey+"."+outputFormat));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("hcare");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

        return finalUrl;
    }

}
