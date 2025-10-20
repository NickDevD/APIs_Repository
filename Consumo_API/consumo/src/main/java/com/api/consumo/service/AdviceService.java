package com.api.consumo.service;

import com.api.consumo.DTO.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdviceService {

    private final WebClient webClient;

    public AdviceService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Flux<PostDTO> getAllPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDTO.class);

    }

    public Mono<PostDTO> buscarPost(int id){
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(PostDTO.class);
    }
}
