package com.srijan.blog.sbblogapp.repositories;

import com.srijan.blog.sbblogapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
