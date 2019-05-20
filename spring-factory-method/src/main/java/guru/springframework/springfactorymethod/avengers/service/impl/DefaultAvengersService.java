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

  private ContentType.ParserFactory parserFactory;

  @Autowired
  public DefaultAvengersService(ContentType.ParserFactory parserFactory) {
    this.parserFactory = parserFactory;
  }

  @Override
  public List<Avenger> getAll(ContentType contentType) {
    String fileName = contentType.fileName();
    log.info("Fetching list from file {}", fileName);

    return parserFactory
        .getParser(contentType)
        .parse(getFileHandle(fileName));
  }

  private Reader getFileHandle(String fileName) {
    InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
    return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
  }
}
