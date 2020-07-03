package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
