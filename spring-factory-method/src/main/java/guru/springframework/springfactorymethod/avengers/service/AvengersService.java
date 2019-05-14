package guru.springframework.springfactorymethod.avengers.service;

import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import java.util.List;

public interface AvengersService {

  List<Avenger> getAllFromCsv();

  List<Avenger> getAllFromJson();

  List<Avenger> getAllFromXml();
}
