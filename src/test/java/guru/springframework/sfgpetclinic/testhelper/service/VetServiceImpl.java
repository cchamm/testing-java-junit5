package guru.springframework.sfgpetclinic.testhelper.service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

public class VetServiceImpl implements VetService {
    private final Set<Vet> vets = new HashSet<>();


    @Override
    public Set<Vet> findAll() {
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        // not implemented
        throw new NotImplementedException("");
    }

    @Override
    public Vet save(Vet object) {
        vets.add(object);
        return object;
    }

    @Override
    public void delete(Vet object) {
        throw new NotImplementedException("");
    }

    @Override
    public void deleteById(Long aLong) {
        throw new NotImplementedException("");
    }
}
