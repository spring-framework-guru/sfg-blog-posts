package guru.springframework.ehcache.rest;

import guru.springframework.ehcache.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/calculate")
public class CalculationRestController {

  private final CalculationService calculationService;

  @Autowired
  public CalculationRestController(CalculationService calculationService) {
    this.calculationService = calculationService;
  }

  @GetMapping(path = "/areaOfCircle", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Double> areaOfCircle(@RequestParam int radius) {
    double result = calculationService.areaOfCircle(radius);

    return ResponseEntity.ok(result);
  }

  @GetMapping(path = "/pow", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Double> pow(@RequestParam int basis, @RequestParam int exponent) {
    double result = calculationService.pow(basis, exponent);

    return ResponseEntity.ok(result);
  }

  @GetMapping(path = "/multiply", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Double> multiply(@RequestParam int factor1, @RequestParam int factor2) {
    double result = calculationService.multiply(factor1, factor2);

    return ResponseEntity.ok(result);
  }

  @GetMapping(path = "/evict", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> evictCache() {
    calculationService.evictCache();
    return ResponseEntity.ok("Cache successfully evicted!");
  }

}
