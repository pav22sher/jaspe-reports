package com.example.jaspereports.service;

import com.example.jaspereports.domain.Employee;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {
    @SneakyThrows
    public JasperPrint report(List<Employee> employees) {
        FileInputStream template = new FileInputStream(ResourceUtils.getFile("classpath:employee-template.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(template);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Test T.T.");
        return JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    }
}
