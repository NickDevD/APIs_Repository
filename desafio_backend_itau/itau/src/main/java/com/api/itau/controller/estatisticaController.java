package com.api.itau.controller;

import com.api.itau.dto.EstatisticaDTO;
import com.api.itau.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statisticas")
public class estatisticaController {

    private final EstatisticaService service;

    public estatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping("/resgatar")
    public ResponseEntity<EstatisticaDTO> coletar(@RequestParam (value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca){
        return ResponseEntity.ok(service.estatisticaDTO(intervaloBusca));


    }
}
