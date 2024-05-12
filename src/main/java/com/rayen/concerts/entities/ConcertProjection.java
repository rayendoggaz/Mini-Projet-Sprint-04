package com.rayen.concerts.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomConcert", types = { Concert.class })
public interface ConcertProjection {
    String getNomConcert();
}
