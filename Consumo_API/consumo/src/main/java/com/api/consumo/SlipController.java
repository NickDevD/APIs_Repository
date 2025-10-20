package com.api.consumo;


import com.api.consumo.DTO.PostDTO;
import com.api.consumo.service.AdviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class SlipController {

    private final AdviceService adviceService;

    public SlipController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping("/posts")
    public Flux<PostDTO> getAll(){
        return  adviceService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Mono<PostDTO> getOne(@PathVariable Integer id){
        return adviceService.buscarPost(id);
    }
}
