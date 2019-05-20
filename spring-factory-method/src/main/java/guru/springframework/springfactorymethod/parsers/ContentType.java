package guru.springframework.springfactorymethod.parsers;

import guru.springframework.springfactorymethod.avengers.domain.Avenger;
import java.io.Reader;
import java.util.List;

public enum ContentType {

  JSON(TypeConstants.JSON_PARSER) {
    @Override
    public String fileName() {
      return "avengers.json";
    }
  },

  CSV(TypeConstants.CSV_PARSER) {
    @Override
    public String fileName() {
      return "avengers.csv";
    }
  },
  
  XML(TypeConstants.XML_PARSER) {
    @Override
    public String fileName() {
      return "avengers.xml";
    }
  };

  private final String parserName;

  ContentType(String parserName) {
    this.parserName = parserName;
  }
  
  public abstract String fileName();

  @Override
  public String toString() {
    return parserName;
  }

  // object interface
  public interface Parser {

    List<Avenger> parse(Reader r);

    List<Avenger> parse(String payload);
  }

  // factory interface
  public interface ParserFactory {

    Parser getParser(ContentType contentType);
  }

  // parserNames
  public interface TypeConstants {

    String CSV_PARSER = "csvParser";
    String JSON_PARSER = "jsonParser";
    String XML_PARSER = "xmlParser";
  }
}
