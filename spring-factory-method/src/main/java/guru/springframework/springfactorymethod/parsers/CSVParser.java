package guru.springframework.springfactorymethod.parsers;

import static java.util.stream.Collectors.toList;

import guru.springframework.springfactorymethod.parsers.ContentType.TypeConstants;
import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import guru.springframework.springfactorymethod.avengers.domain.exception.ParserIOException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.simpleflatmapper.csv.CsvParser;
import org.springframework.stereotype.Component;

@Component(TypeConstants.CSV_PARSER)
@Slf4j
public class CSVParser implements ContentType.Parser {

  private static CsvParser.MapToDSL _cached;

  static {
    _cached = CsvParser
        .separator(',')
        .trimSpaces()
        .mapTo(Avenger.class);
  }

  @Override
  public List<Avenger> parse(Reader r) {
    try {
      return (List<Avenger>) _cached.stream(r).collect(toList());

    } catch (IOException e) {
      throw new ParserIOException("Io error while parsing CSV file", e);
    }
  }

  @Override
  public List<Avenger> parse(String payload) {
    try {
      return (List<Avenger>) _cached.stream(payload).collect(toList());

    } catch (IOException e) {
      throw new ParserIOException("Io error while parsing CSV file", e);
    }
  }
}
