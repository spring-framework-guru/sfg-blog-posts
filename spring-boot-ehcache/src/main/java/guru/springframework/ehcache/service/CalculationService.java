package guru.springframework.ehcache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

  private final Logger LOG = LoggerFactory.getLogger(CalculationService.class);

  @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
  public double areaOfCircle(int radius) {
    LOG.info("calculate the area of a circle with a radius of {}", radius);
    return Math.PI * Math.pow(radius, 2);
  }

  @Cacheable(value = "powCache", key = "{#basis, #exponent}")
  public double pow(int basis, int exponent) {
    LOG.info("raise {} to the power of {}", basis, exponent);
    return Math.pow(basis, exponent);
  }

  @Cacheable(value = "multiplyCache", keyGenerator = "multiplyKeyGenerator")
  public double multiply(int factor1, int factor2) {
    LOG.info("Multiply {} with {}", factor1, factor2);
    return factor1 * factor2;
  }

  @CacheEvict(cacheNames = {"areaOfCircleCache", "multiplyCache"}, allEntries = true)
  public void evictCache() {
    LOG.info("Evict all cache entries...");
  }

}
