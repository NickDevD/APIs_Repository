package com.api.lojastock.repository;

import com.api.lojastock.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<Produto, Long> {

}
