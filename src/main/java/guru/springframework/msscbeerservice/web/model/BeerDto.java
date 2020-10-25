package guru.springframework.msscbeerservice.web.model;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class BeerDto {
    @Null
    UUID id;
    @Null
    Integer version;

    @Null
    OffsetDateTime createdDate;
    @Null
    OffsetDateTime lastModifiedDate;

    @NotBlank
    String beerName;
    @NotNull
    BeerStyle beerStyle;

    @NotNull
    @Positive
    Long upc;
    @NotNull
    @Positive
    BigDecimal price;
    Integer quantityOnHand;
}
