package guru.springframework.springrestexception.controller.v1;

import guru.springframework.springrestexception.domain.model.Pet;
import guru.springframework.springrestexception.controller.ErrorMessage;
import guru.springframework.springrestexception.exception.PetNotFoundException;
import guru.springframework.springrestexception.service.PetService;
import java.net.URI;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/v1/pets", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetRestControllerV1 {

  private PetService petService;

  @Autowired
  public PetRestControllerV1(PetService petService) {
    this.petService = petService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findPetById(@PathVariable int id) {
    try {
      return ResponseEntity.ok(petService.findPetById(id));

    } catch (PetNotFoundException e) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage()));
    }
  }

  @GetMapping
  public ResponseEntity<Collection<Pet>> findAllPets() {
    return ResponseEntity.ok(petService.findAllPets());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> savePet(@RequestBody Pet pet) {
    Integer created = petService.savePet(pet);
    return ResponseEntity
        .created(location("/{id}", created))
        .header("Id", String.valueOf(created))
        .build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletePet(@PathVariable Integer id) {
    try {
      petService.deletePet(id);
      return ResponseEntity.ok().build();

    } catch (PetNotFoundException e) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage()));
    }
  }

  private static URI location(String path, Object... args) {
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path(path).buildAndExpand(args).toUri();
  }
}
