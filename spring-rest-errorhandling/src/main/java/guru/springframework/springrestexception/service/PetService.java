package guru.springframework.springrestexception.service;

import guru.springframework.springrestexception.domain.model.Pet;
import java.util.Collection;

public interface PetService {

  Pet findPetById(int id);

  Collection<Pet> findAllPets();

  Integer savePet(Pet pet);

  void deletePet(Integer id);
}
