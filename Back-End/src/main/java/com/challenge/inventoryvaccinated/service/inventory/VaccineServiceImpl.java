package com.challenge.inventoryvaccinated.service.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccine;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccineDto;
import com.challenge.inventoryvaccinated.model.pojo.inventory.vo.VaccineVo;
import com.challenge.inventoryvaccinated.model.repository.inventory.VaccineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService{

    private final VaccineRepository repository;

    @Autowired
    public VaccineServiceImpl(VaccineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VaccineVo> findAllVo() {
        List<Vaccine> list = repository.findAll();
        List<VaccineVo> result = new ArrayList<>(list.size());
        for (Vaccine entity : list) {
            VaccineVo vo = new VaccineVo();
            BeanUtils.copyProperties(entity, vo);
            result.add(vo);
        }
        return result;
    }

    @Override
    public Optional<Vaccine> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<VaccineVo> findAllVoByName(String name) {
        List<Object[]> list = repository.findAllVoByName(name.toLowerCase().trim());
        List<VaccineVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            VaccineVo vo = new VaccineVo();
            vo.setId((Integer) object[0]);
            vo.setName((String) object[1]);
            result.add(vo);
        }
        return result;
    }

    @Override
    @Transactional
    public Vaccine persist(VaccineDto dto) {
        Vaccine entity = new Vaccine();
        BeanUtils.copyProperties(dto, entity);
        entity.setName(dto.getName().toLowerCase().trim());
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void update(Vaccine entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Vaccine entity) {
        repository.delete(entity);
    }

}
