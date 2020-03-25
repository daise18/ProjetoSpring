package br.com.dms.pets.catalogopet.controllers;

import br.com.dms.pets.catalogopet.models.Cadastre;
import br.com.dms.pets.catalogopet.repositories.ChatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    @Autowired
    private ChatoRepository chatoRepository;

    @GetMapping
    public List<Cadastre> list() {
        return chatoRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Cadastre get(@PathVariable Integer id) {
        return chatoRepository.getOne(id);
    }

    @PostMapping
    public Cadastre create(@RequestBody final Cadastre cadastre) {
        return chatoRepository.saveAndFlush(cadastre);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        chatoRepository.deleteById(id);
}

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Cadastre update(@PathVariable Integer id, @RequestBody Cadastre cadastre) {
        Cadastre existingCadastre = chatoRepository.getOne(id);
        BeanUtils.copyProperties(cadastre, existingCadastre);
        return chatoRepository.saveAndFlush(existingCadastre);
    }
}
