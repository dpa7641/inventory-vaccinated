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
import java.util.Date;
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
        List<Object[]> list = repository.findAllVo();
        List<VaccinationVo> result = new ArrayList<>(list.size());
        for (Object[] object: list) {
            VaccinationVo vo = new VaccinationVo();
            vo.setId((Integer) object[0]);
            vo.setDate((Date) object[1]);
            vo.setDoses((Integer) object[2]);
            vo.setIdUser((Integer) object[3]);
            vo.setIdVaccine((Integer) object[4]);
            vo.setUserName((String) object[5]);
            vo.setVaccineName((String) object[6]);
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
    public Vaccination persist(int idUser, VaccinationDto dto) {
        Vaccination entity = new Vaccination();
        entity.setDate(dto.getDate());
        entity.setDoses(dto.getDoses());
        entity.setIdVaccine(dto.getIdVaccine());
        entity.setIdUser(idUser);
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
