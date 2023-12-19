package com.example.t07_entidadescoperantes.service;

import com.example.t07_entidadescoperantes.domain.dto.EntidadRequestDTO;
import com.example.t07_entidadescoperantes.domain.dto.EntidadResponseDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;

@Service
public interface EntidadService {
    Mono<EntidadResponseDTO> findById(Integer id);

    Flux<EntidadResponseDTO> findAll();

    Mono<EntidadResponseDTO> create(EntidadRequestDTO request);

    Mono<EntidadResponseDTO> update(Integer id, EntidadRequestDTO request);

    Mono<Void> delete(Integer id);

    Mono<EntidadResponseDTO> activar(Integer id);

    Mono<Mono<byte[]>> exportPdf();

}
