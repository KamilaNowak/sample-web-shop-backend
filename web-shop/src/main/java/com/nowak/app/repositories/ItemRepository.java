package com.nowak.app.repositories;

import com.nowak.app.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    //http://localhost:8080/items/search/findByItemCategory_Id?id=1
    Page<Item> findByItemCategory_Id(@RequestParam("id") Long id, Pageable pageable);

    Page<Item> findByTitleContaining(@RequestParam("q") String query, Pageable pageable);
}
