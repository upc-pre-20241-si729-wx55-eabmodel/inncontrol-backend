package com.github.inncontrol.inventory.application.queryservices;


import com.github.inncontrol.inventory.domain.model.aggregates.Inventory;
import com.github.inncontrol.inventory.domain.model.queries.GetAllItems;
import com.github.inncontrol.inventory.domain.model.queries.GetItemById;
import com.github.inncontrol.inventory.domain.model.queries.GetItemByProviderId;
import com.github.inncontrol.inventory.domain.services.ItemQueryService;
import com.github.inncontrol.inventory.infrastructure.persistence.jpa.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemQueryServiceImpl implements ItemQueryService {
    private final ItemRepository itemRepository;

    public ItemQueryServiceImpl(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    @Override
    public List<Inventory> handle(GetAllItems query){
        return itemRepository.findAll();
    }

    @Override
    public Optional<Inventory> handle(GetItemById query){
        return itemRepository.GetItemById(query.ItemId());
    }

    @Override
    public Optional<Inventory>handle(GetItemByProviderId query){
        return itemRepository.GetItemByProviderId(query.providerId());
    }

}
