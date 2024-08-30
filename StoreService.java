package pet.store.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class StoreService {

 @Autowired
 private PetStoreDao petStoreDao;

 public PetStoreData savePetStore(PetStoreData petStoreData) {
	 PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
     setPetStoreFields(petStoreData, petStore);
     return new PetStoreData(petStoreDao.save(petStore));
    }

private PetStore findOrCreatePetStore(Long petStoreId) {
     return petStoreId == null ? new PetStore() : 
     petStoreDao.findById(petStoreId).orElseThrow(() -> new NoSuchElementException("PetStore with ID=" + petStoreId + " is not found"));
    }

private void setPetStoreFields(PetStoreData petStoreData, PetStore petStore) {
	petStore.setPetStoreName(petStoreData.getPetStoreName());
    petStore.setPetStoreLocation(petStoreData.getPetStoreLocation());
    }
}


	
