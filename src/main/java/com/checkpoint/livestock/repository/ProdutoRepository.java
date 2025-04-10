package com.checkpoint.livestock.repository;

import com.checkpoint.livestock.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByCategoriaAsc();

}

