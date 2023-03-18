package com.challenge.inventoryvaccinated.controller.inventory;

import com.challenge.inventoryvaccinated.commons.ResultResponse;
import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;
import com.challenge.inventoryvaccinated.model.enums.HttpResponseMessage;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccinationDto;
import com.challenge.inventoryvaccinated.model.pojo.inventory.vo.VaccinationVo;
import com.challenge.inventoryvaccinated.service.inventory.VaccinationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/vacunacion")
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(vaccinationService.findAllVo()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<Vaccination> entity = vaccinationService.findById(id);
        if (entity.isPresent()) {
            VaccinationVo vo = new VaccinationVo();
            BeanUtils.copyProperties(entity.get(), vo);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(vo).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> persist(@PathVariable("id") int id, @RequestBody VaccinationDto dto) {
        Vaccination entity = vaccinationService.persist(id, dto);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.PERSIST_SUCCESSFUL.getValue()).data(entity.getId()).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody VaccinationDto dto) {
        Optional<Vaccination> entity = vaccinationService.findById(id);
        if (entity.isPresent()) {
            Vaccination vaccination = entity.get();
            BeanUtils.copyProperties(dto, vaccination);
            vaccinationService.update(vaccination);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.UPDATE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Vaccination> entity = vaccinationService.findById(id);
        if (entity.isPresent()) {
            vaccinationService.delete(entity.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.DELETE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }
}
