package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import guru.springframework.sfgpetclinic.testhelper.model.ModelImpl;
import guru.springframework.sfgpetclinic.testhelper.service.VetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetService vetService;
    VetController controller;

    @BeforeEach
    void setUp() {
        vetService = new VetMapService(new SpecialityMapService());
        controller = new VetController(vetService);
    }

    @Test
    void listVets_EmptyModel() {
        var model = new ModelImpl();
        var result = controller.listVets(model);
        assertEquals("vets/index", result);
        assertEquals((Integer) 1, model.size());
        Object allVets = model.getByKey("vets");
//        assertTrue(allVets.getClass().isAssignableFrom(HashSet.class));
        assertTrue(allVets instanceof Set);
        assertEquals(0, ((Set<?>) allVets).size());
    }


    @Test
    void listVets_NonEmptyModel() {
        var model = new ModelImpl();
        List<Vet> vets = new ArrayList<>();
        vets.add(new Vet(1L, "John", "Doe", new HashSet<>()));
        vets.add(new Vet(2L, "Sam", "Larry", new HashSet<>()));
        vets.forEach((e) -> vetService.save(e));
        var result = controller.listVets(model);
        assertEquals("vets/index", result);
        assertEquals((Integer) 1, model.size());
        Object allVets = model.getByKey("vets");
        assertTrue(allVets instanceof Set);
        Set<Vet> allVetsSet = (Set<Vet>) allVets;
        assertEquals(2, ((Set<?>) allVets).size());
        assertThat(allVetsSet).containsAll(vets);
    }


}