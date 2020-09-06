package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get(BeerController.API_V1_BEER + "/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        final BeerDto beerDto = getBasicBeerDto()
                .createdDate(OffsetDateTime.now())
                .build();
        final String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post(BeerController.API_V1_BEER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeer() throws Exception {
        final UUID beerId = UUID.randomUUID();
        final BeerDto beerDto = getBasicBeerDto()
                .id(beerId)
                .lastModifiedDate(OffsetDateTime.now())
                .build();
        final String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put(BeerController.API_V1_BEER + "/" + beerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    private BeerDto.BeerDtoBuilder getBasicBeerDto() {
        return BeerDto.builder()
                .beerName("Gemer")
                .beerStyle(BeerStyle.LAGER)
                .price(BigDecimal.valueOf(0.85))
                .quantityOnHand(500)
                .upc(123456789L)
                .version(1);
    }
}