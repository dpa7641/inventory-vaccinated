package com.challenge.inventoryvaccinated.service.user;

import com.challenge.inventoryvaccinated.model.entity.user.Config;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.ConfigVo;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.UserVo;
import com.challenge.inventoryvaccinated.model.repository.user.ConfigRepository;
import com.challenge.inventoryvaccinated.model.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigServiceImpl implements ConfigService{

    private final ConfigRepository repository;

    @Autowired
    public ConfigServiceImpl(ConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ConfigVo> findAllVo() {
        List<Object[]> list = repository.findAllVo();
        List<ConfigVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            ConfigVo vo = new ConfigVo();
            vo.setId((Integer) object[0]);
            vo.setUsername((String) object[1]);
            vo.setIdUser((Integer) object[2]);
            vo.setName((String) object[3]);
            vo.setEmail((String) object[4]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public Optional<Config> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Config> findByIdUser(int idUser) {
        return repository.findByIdUser(idUser);

    }

    @Override
    public void update(Config entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Config entity) {
        repository.delete(entity);
    }
}
