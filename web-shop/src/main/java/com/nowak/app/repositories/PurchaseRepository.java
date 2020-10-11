package com.nowak.app.repositories;

import com.nowak.app.entities.Purchase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {
}
