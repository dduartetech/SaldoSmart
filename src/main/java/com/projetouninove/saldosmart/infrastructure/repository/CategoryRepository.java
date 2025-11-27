package com.projetouninove.saldosmart.infrastructure.repository;

import com.projetouninove.saldosmart.infrastructure.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
     
}
