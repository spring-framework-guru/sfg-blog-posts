package guru.springframework.springfactorymethod.avengers.service.impl;

import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import guru.springframework.springfactorymethod.avengers.service.AvengersService;
import guru.springframework.springfactorymethod.parsers.ContentType;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultAvengersService implements AvengersService {

  private ContentType.Parser csvParser, jsonParser, xmlParser;

  @Autowired
  public DefaultAvengersService(ContentType.ParserFactory parserFactory) {
    this.csvParser = parserFactory.getParser(ContentType.CSV);
    this.jsonParser = parserFactory.getParser(ContentType.JSON);
    this.xmlParser = parserFactory.getParser(ContentType.XML);
  }

  @Override
  public List<Avenger> getAllFromCsv() {
    log.info("Fetching list from avengers.csv...");
    return csvParser.parse(getFileHandle("avengers.csv"));
  }

  @Override
  public List<Avenger> getAllFromJson() {
    log.info("Fetching list from avengers.json...");
    return jsonParser.parse(getFileHandle("avengers.json"));
  }

  @Override
  public List<Avenger> getAllFromXml() {
    log.info("Fetching list from avengers.xml...");
    return xmlParser.parse(getFileHandle("avengers.xml"));
  }

  private Reader getFileHandle(String fileName) {
    InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
    return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
  }
}
