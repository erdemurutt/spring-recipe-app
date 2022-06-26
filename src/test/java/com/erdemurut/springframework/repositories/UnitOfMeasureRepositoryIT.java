package com.erdemurut.springframework.repositories;

import com.erdemurut.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	@DirtiesContext
	public void findByDescriptionTeaSpoon() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("TeaSpoon");
		assertEquals("TeaSpoon", uomOptional.get().getDescription());
	}

	@Test
	public void findByDescriptionCup() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}
}