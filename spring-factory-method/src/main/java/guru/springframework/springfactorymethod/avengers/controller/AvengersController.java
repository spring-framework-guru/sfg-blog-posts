package guru.springframework.springfactorymethod.avengers.controller;

import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import guru.springframework.springfactorymethod.avengers.service.AvengersService;
import guru.springframework.springfactorymethod.parsers.ContentType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/avengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvengersController {

  private AvengersService service;

  @Autowired
  public AvengersController(AvengersService service) {
    this.service = service;
  }

  @GetMapping("/csv")
  public ResponseEntity<List<Avenger>> getAllFromCsv() {
    return ResponseEntity.ok().body(service.getAll(ContentType.CSV));
  }

  @GetMapping("/json")
  public ResponseEntity<List<Avenger>> getAllFromJson() {
    return ResponseEntity.ok().body(service.getAll(ContentType.JSON));
  }

  @GetMapping("/xml")
  public ResponseEntity<List<Avenger>> getAllFromXml() {
    return ResponseEntity.ok().body(service.getAll(ContentType.XML));
  }
}
