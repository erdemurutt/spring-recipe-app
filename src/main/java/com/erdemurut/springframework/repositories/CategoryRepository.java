package com.erdemurut.springframework.repositories;

import com.erdemurut.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
