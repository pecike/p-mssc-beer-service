package guru.springframework.msscbeerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<BeerDto> {

    public BeerPagedList(final List<BeerDto> content) {
        super(content);
    }

    public BeerPagedList(final List<BeerDto> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }
}
