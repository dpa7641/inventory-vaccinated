package com.challenge.inventoryvaccinated.service.inventory;


import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccinationDto;
import com.challenge.inventoryvaccinated.model.pojo.inventory.vo.VaccinationVo;
import com.challenge.inventoryvaccinated.model.repository.inventory.VaccinationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationServiceImpl implements  VaccinationService{

    private final VaccinationRepository repository;

    @Autowired
    public VaccinationServiceImpl(VaccinationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VaccinationVo> findAllVo() {
        List<Vaccination> list = repository.findAll();
        List<VaccinationVo> result = new ArrayList<>(list.size());
        for (Vaccination entity : list) {
            VaccinationVo vo = new VaccinationVo();
            BeanUtils.copyProperties(entity, vo);
            result.add(vo);
        }
        return result;
    }

    @Override
    public Optional<Vaccination> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Vaccination> finByIdByDoses(int id, int doses) {
        return repository.finByIdByDoses(id, doses);
    }

    @Override
    @Transactional
    public Vaccination persist(VaccinationDto dto) {
        Vaccination entity = new Vaccination();
        BeanUtils.copyProperties(dto, entity);
        return repository.save(entity);
    }

    @Override
    @Transactional
    public Vaccination persistByUpdate(int id, VaccinationDto dto) {
        Vaccination entity = new Vaccination();
        entity.setDate(dto.getDate());
        entity.setDoses(dto.getDoses());
        entity.setIdVaccine(dto.getIdVaccine());
        entity.setIdUser(id);
        return repository.save(entity);
    }



    @Override
    public void update(Vaccination entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Vaccination entity) {
        repository.delete(entity);
    }

}
