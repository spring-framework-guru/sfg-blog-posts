package guru.springframework.springfactorymethod.avengers.service;

import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import guru.springframework.springfactorymethod.parsers.ContentType;
import java.util.List;

public interface AvengersService {

  List<Avenger> getAll(ContentType contentType);
}
