package guru.springframework.msscbeerservice.web.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class BeerDto {
    UUID id;
    Integer version;

    OffsetDateTime createdDate;
    OffsetDateTime lastModifiedDate;

    String beerName;
    BeerStyle beerStyle;

    Long upc;
    BigDecimal price;
    Integer quantityOnHand;
}
