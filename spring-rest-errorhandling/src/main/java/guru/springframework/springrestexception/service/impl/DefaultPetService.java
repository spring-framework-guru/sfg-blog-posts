package guru.springframework.springrestexception.service.impl;

import guru.springframework.springrestexception.domain.model.Pet;
import guru.springframework.springrestexception.domain.repository.PetRepository;
import guru.springframework.springrestexception.exception.PetAlreadyExistsException;
import guru.springframework.springrestexception.exception.PetNotFoundException;
import guru.springframework.springrestexception.service.PetService;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class DefaultPetService implements PetService {

  private PetRepository petRepository;

  @Autowired
  public DefaultPetService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Pet findPetById(int id) {
    return petRepository
        .findById(id)
        .orElseThrow(() -> new PetNotFoundException("Pet Not found for id " + id));
  }

  @Override
  public Collection<Pet> findAllPets() {
    Collection<Pet> list = new ArrayList<>();
    petRepository.findAll().forEach(list::add);
    return list;
  }

  @Override
  public Integer savePet(Pet pet) {
    Pet saved;
    try {
      saved = petRepository.save(pet);

    } catch (DataIntegrityViolationException ex) {
      throw new PetAlreadyExistsException("Pet already exists with name: " + pet.getName());
    }

    return saved.getId();
  }

  @Override
  public void deletePet(Integer id) {
    petRepository
        .findById(id)
        .ifPresentOrElse(
            pet -> petRepository.delete(pet),
            () -> {
              throw new PetNotFoundException("Pet Not found for id " + id);
            });
  }
}
