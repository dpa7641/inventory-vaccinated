package com.challenge.inventoryvaccinated.controller.inventory;

import com.challenge.inventoryvaccinated.commons.ResultResponse;
import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccine;
import com.challenge.inventoryvaccinated.model.enums.HttpResponseMessage;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccineDto;
import com.challenge.inventoryvaccinated.service.inventory.VaccineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/vacuna")
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(String name) {
        if(name != null && !name.isEmpty()){
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(vaccineService.findAllVoByName(name)).build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(vaccineService.findAllVo()).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<Vaccine> entity = vaccineService.findById(id);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(entity).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> persist(@RequestBody VaccineDto dto) {
        Vaccine entity = vaccineService.persist(dto);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.PERSIST_SUCCESSFUL.getValue()).data(entity.getId()).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody VaccineDto dto) {
        Optional<Vaccine> entity = vaccineService.findById(id);
        if (entity.isPresent()) {
            Vaccine vacuna = entity.get();
            BeanUtils.copyProperties(dto, vacuna);
            vacuna.setName(dto.getName().toLowerCase().trim());
            vaccineService.update(vacuna);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.UPDATE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Vaccine> entity = vaccineService.findById(id);
        if (entity.isPresent()) {
            vaccineService.delete(entity.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.DELETE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

}
