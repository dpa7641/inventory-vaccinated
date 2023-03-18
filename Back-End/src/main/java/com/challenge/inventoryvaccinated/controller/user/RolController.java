package com.challenge.inventoryvaccinated.controller.user;


import com.challenge.inventoryvaccinated.commons.ResultResponse;
import com.challenge.inventoryvaccinated.model.entity.user.Rol;
import com.challenge.inventoryvaccinated.model.enums.HttpResponseMessage;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.RolDto;
import com.challenge.inventoryvaccinated.service.user.RolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(String name) {
        if(name != null && !name.isEmpty()){
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(rolService.findAllVoByName(name)).build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(rolService.findAllVo()).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<Rol> entity = rolService.findById(id);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(entity).build(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> persist(@RequestBody RolDto dto) {
        Rol entity = rolService.persist(dto);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.PERSIST_SUCCESSFUL.getValue()).data(entity.getId()).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody RolDto dto) {
        Optional<Rol> entity = rolService.findById(id);
        if (entity.isPresent()) {
            Rol rol = entity.get();
            BeanUtils.copyProperties(dto, rol);
            rol.setName(dto.getName().toLowerCase().trim());
            rolService.update(rol);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.UPDATE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Rol> entity = rolService.findById(id);
        if (entity.isPresent()) {
            rolService.delete(entity.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.DELETE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }
}
