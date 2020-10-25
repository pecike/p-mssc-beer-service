package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// TODO Use liquibase instead
@Slf4j
@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370101L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370102L)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

        log.debug("Loaded beers: " + beerRepository.count());
    }
}
