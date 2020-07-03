package com.nowak.app.repositories;

import com.nowak.app.entities.ItemCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(
        collectionResourceRel = "item-category",
        path = "item-category"
)
@Repository
public interface ItemCategoryRepository extends PagingAndSortingRepository<ItemCategory, Long> {
}
