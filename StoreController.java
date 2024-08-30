package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.StoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class StoreController {
@Autowired
private StoreService storeService;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {

	log.info("Creating pet store: {}", petStoreData);
	return storeService.savePetStore(petStoreData);
	    }

@PutMapping("/{petStoreId}")
public PetStoreData modifyPetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
	log.info("Modifying pet store with ID {}: {}", petStoreId, petStoreData);
	petStoreData.setPetStoreId(petStoreId);
	return storeService.savePetStore(petStoreData);
	    }
	}