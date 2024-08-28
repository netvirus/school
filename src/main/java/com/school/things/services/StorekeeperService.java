package com.school.things.services;

import com.school.things.entities.Storekeeper;
import com.school.things.repositories.StorekeeperRepository;
import com.school.things.utils.PersonDataCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorekeeperService extends GenericService<Storekeeper, Long> {

    @Autowired
    public StorekeeperService(StorekeeperRepository storekeeperRepository) {
        super(storekeeperRepository);
    }

    @Override
    protected void copyProperties(Storekeeper existingStorekeeper, Storekeeper updatedStorekeeper) {
        PersonDataCopier.copyCommonPersonData(existingStorekeeper, updatedStorekeeper);
        existingStorekeeper.setWarehouseName(updatedStorekeeper.getWarehouseName());
    }
}
