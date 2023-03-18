package com.challenge.inventoryvaccinated.service.user;

import com.challenge.inventoryvaccinated.model.entity.user.Rol;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.RolDto;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.RolVo;
import com.challenge.inventoryvaccinated.model.repository.user.RolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

    private final RolRepository repository;


    @Autowired
    public RolServiceImpl(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RolVo> findAllVo() {
        List<Object[]> list = repository.findAllVo();
        List<RolVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            RolVo vo = new RolVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            result.add(vo);
        }
        return result;
    }

    @Override
    public Optional<Rol> findById(int id) {
        return repository.findById(id);
    }


    @Override
    public List<RolVo> findAllVoByName(String name) {
        List<Object[]> list = repository.findAllVoByName(name.toLowerCase().trim());
        List<RolVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            RolVo vo = new RolVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            result.add(vo);
        }
        return result;
    }

    @Override
    @Transactional
    public Rol persist(RolDto dto) {
        Rol entity = new Rol();
        BeanUtils.copyProperties(dto, entity);
        entity.setName(dto.getName().toLowerCase().trim());
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void update(Rol entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Rol entity) {
        repository.delete(entity);
    }
}
