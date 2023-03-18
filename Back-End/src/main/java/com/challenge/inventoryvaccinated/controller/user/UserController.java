package com.challenge.inventoryvaccinated.controller.user;


import com.challenge.inventoryvaccinated.commons.ResultResponse;
import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;
import com.challenge.inventoryvaccinated.model.entity.user.Config;
import com.challenge.inventoryvaccinated.model.entity.user.User;
import com.challenge.inventoryvaccinated.model.enums.HttpResponseMessage;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.UserDto;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.UserVo;
import com.challenge.inventoryvaccinated.service.inventory.VaccinationService;
import com.challenge.inventoryvaccinated.service.user.ConfigService;
import com.challenge.inventoryvaccinated.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UserController {

    private final UserService userService;
    private final VaccinationService vaccinationService;
    private final ConfigService configService;

    @Autowired
    public UserController(UserService userService, VaccinationService vaccinationService, ConfigService configService) {
        this.userService = userService;
        this.vaccinationService = vaccinationService;
        this.configService = configService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(String name) {
        if(name != null && !name.isEmpty()){
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(userService.findAllVoByName(name)).build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(userService.findAllVo()).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/v/{vaccinated}")
    public ResponseEntity<?> findAllVoByVaccinated(@PathVariable("vaccinated") Boolean vaccinated) {
        List<UserVo> user = userService.findAllVoByVaccinated(vaccinated);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(user).build(), HttpStatus.OK);
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<?> findAllByRol(@PathVariable("id") int id) {
        List<UserVo> user = userService.findAllByRol(id);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(user).build(), HttpStatus.OK);
    }

    @GetMapping("/va/{vaccine}")
    public ResponseEntity<?> findAllVoByVacccine(@PathVariable("vaccine") int vaccine) {
        List<UserVo> user = userService.findAllVoByVacccine(vaccine);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(user).build(), HttpStatus.OK);
    }

    @GetMapping("/date/{init}/{end}")
    public ResponseEntity<?> findAllVoByVacccinationDate(@PathVariable("init") Date init, @PathVariable("end") Date end) {
        List<UserVo> user = userService.findAllVoByVaccinationDate(init, end);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(user).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<User> entity = userService.findById(id);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.FIND_SUCCESSFUL.getValue()).data(entity).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> persist(@RequestBody UserDto dto) {
        User entity = userService.persist(dto);
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.PERSIST_SUCCESSFUL.getValue()).data(entity.getId()).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UserDto dto) {
        Optional<User> entity = userService.findById(id);
        if (entity.isPresent()) {
            User user = entity.get();
            user.setName(dto.getName());
            user.setLastName(dto.getLastName());
            user.setCi(dto.getCi());
            user.setEmail(dto.getEmail());
            user.setBirthdate(dto.getBirthdate());
            user.setPhone(dto.getPhone());
            user.setVaccinated(dto.getVaccinated());
            user.setIdRol(user.getIdRol());
            userService.update(user);
            if(dto.getVaccinated()){
                Optional<Vaccination> entityVacci = vaccinationService.finByIdByDoses(id, dto.getVacuna().getDoses());
                if(entityVacci.isPresent()){
                    Vaccination vacci = entityVacci.get();
                    vacci.setDate(dto.getVacuna().getDate());
                    vacci.setDoses(dto.getVacuna().getDoses());
                    vacci.setIdVaccine(dto.getVacuna().getIdVaccine());
                    vacci.setIdUser(id);
                    vaccinationService.update(vacci);
                }else{
                    vaccinationService.persist(id, dto.getVacuna());
                }
            }
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.UPDATE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<User> entity = userService.findById(id);
        if (entity.isPresent()) {
            Optional<Config> entityConfig = configService.findByIdUser(id);
            configService.delete(entityConfig.get());
            userService.delete(entity.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpResponseMessage.DELETE_SUCCESSFUL.getValue()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpResponseMessage.NOT_FOUND_RECORD.getValue()).build(), HttpStatus.OK);
    }
}
