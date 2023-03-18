package com.challenge.inventoryvaccinated.service.user;

import com.challenge.inventoryvaccinated.model.entity.user.Config;
import com.challenge.inventoryvaccinated.model.entity.user.User;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.UserDto;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.UserVo;
import com.challenge.inventoryvaccinated.model.repository.inventory.VaccinationRepository;
import com.challenge.inventoryvaccinated.model.repository.user.ConfigRepository;
import com.challenge.inventoryvaccinated.model.repository.user.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final ConfigRepository configRepository;
    private final VaccinationRepository vaccinationRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, ConfigRepository configRepository, VaccinationRepository vaccinationRepository) {
        this.repository = repository;
        this.configRepository = configRepository;
        this.vaccinationRepository = vaccinationRepository;
    }

    @Override
    public List<UserVo> findAllVo() {
        List<Object[]> list = repository.findAllVo();
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<UserVo> findAllByRol(int id) {
        List<Object[]> list = repository.findAllUserVoByRol(id);
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }


    @Override
    public Optional<User> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<UserVo> findAllVoByName(String name) {
        List<Object[]> list = repository.findAllVoByName(name.trim());
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<UserVo> findAllVoByVaccinated(Boolean vaccinated) {
        List<Object[]> list = repository.findAllVoByVaccinated(vaccinated);
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<UserVo> findAllVoByVacccine(int id) {
        List<Object[]> list = repository.findAllVoByVaccine(id);
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<UserVo> findAllVoByVaccinationDate(Date init, Date end) {
        List<Object[]> list = repository.findAllVoByVaccinationDate(init, end);
        List<UserVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            UserVo vo = new UserVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            vo.setLastName((String) object[2]);
            vo.setCi((Integer) object[3]);
            vo.setEmail((String) object[4]);
            vo.setBirthdate((Date) object[5]);
            vo.setPhone((Integer) object[6]);
            vo.setVaccinated((Boolean) object[7]);
            vo.setIdRol((Integer) object[8]);
            vo.setRolName((String) object[9]);
            result.add(vo);
        }
        return result;
    }

    @Override
    @Transactional
    public User persist(UserDto dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        repository.save(entity);
        persistConfig(entity.getId(), dto.getCi(), dto.getEmail());
        return entity;
    }
    private Config persistConfig (int id, int ci, String email){
        Config entity = new Config();
        entity.setIdUser(id);
        entity.setUsername(email);
        entity.setPassword(String.valueOf(ci));
        entity.setEnabled(true);
        return configRepository.save(entity);
    }


    @Override
    @Transactional
    public void update(User entity) {
        repository.save(entity);
    }


    @Override
    @Transactional
    public void delete(User entity) {
        repository.delete(entity);
    }
}
