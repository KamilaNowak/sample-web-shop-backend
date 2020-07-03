package com.nowak.app.repositories;

import com.nowak.app.entities.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
