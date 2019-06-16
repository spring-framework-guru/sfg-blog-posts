package guru.springframework.springrestexception.controller.v2;

import guru.springframework.springrestexception.domain.model.Pet;
import guru.springframework.springrestexception.service.PetService;
import java.net.URI;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api/v2/pets", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetRestControllerV2 {

  private PetService petService;

  @Autowired
  public PetRestControllerV2(PetService petService) {
    this.petService = petService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> findPetById(@PathVariable int id) {
    return ResponseEntity.ok(petService.findPetById(id));
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
  public ResponseEntity<Void> deletePet(@PathVariable Integer id) {
    petService.deletePet(id);
    return ResponseEntity.ok().build();
  }

  private static URI location(String path, Object... args) {
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path(path).buildAndExpand(args).toUri();
  }
}
