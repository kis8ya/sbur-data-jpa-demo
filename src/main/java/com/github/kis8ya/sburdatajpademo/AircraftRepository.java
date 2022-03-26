package com.github.kis8ya.sburdatajpademo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
}
