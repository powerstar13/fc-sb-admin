package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Category;
import com.study.fcsbadmin.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByCategory(Category category);
}
