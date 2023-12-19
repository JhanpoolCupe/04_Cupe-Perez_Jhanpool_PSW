package com.example.t07_entidadescoperantes.util;

import com.example.t07_entidadescoperantes.domain.model.Entidad;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntidadReportGenerator {

    private final Scheduler jdbcScheduler = Schedulers.boundedElastic();

    public Mono<byte[]> exportToPdf(List<Entidad> list) {
        return Mono.fromCallable(() -> generatePdf(list))
                .subscribeOn(jdbcScheduler);
    }

    private byte[] generatePdf(List<Entidad> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list));
    }

    private JasperPrint getReport(List<Entidad> list) throws FileNotFoundException, JRException{
        Map<String, Object> params = new HashMap<>();
        params.put("entiData", new JRBeanCollectionDataSource(list));

        JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:microservicio.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());

            return report;
    }
}
