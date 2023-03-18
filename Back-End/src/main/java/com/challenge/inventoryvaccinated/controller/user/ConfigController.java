package com.challenge.inventoryvaccinated.controller.user;


import com.challenge.inventoryvaccinated.commons.ResultResponse;
import com.challenge.inventoryvaccinated.model.entity.user.Config;
import com.challenge.inventoryvaccinated.model.enums.HttpResponseMessage;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.ConfigDto;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.RolDto;
import com.challenge.inventoryvaccinated.service.user.ConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(String name) {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(configService.findAllVo()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<Config> entity = configService.findById(id);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(entity).build(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ConfigDto dto) {
        Optional<Config> entity = configService.findById(id);
        if (entity.isPresent()) {
            Config con = entity.get();
            con.setUsername(dto.getUsername());
            con.setPassword(dto.getPassword());
            configService.update(con);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.UPDATE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

}
