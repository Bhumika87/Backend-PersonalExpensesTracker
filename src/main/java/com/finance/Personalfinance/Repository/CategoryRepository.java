package com.finance.Personalfinance.Repository;

import com.finance.Personalfinance.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
