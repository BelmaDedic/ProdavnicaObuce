package com.example.ProdavnicaObuce.Grad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradServiceImpl implements GradService{
    @Autowired
    private GradRepository gradRepository;

    @Override
    public void addGrad(GradEntity grad) {
        gradRepository.save(grad);
    }

    @Override
    public List<GradEntity> getAllGradovi() {
        return gradRepository.findAll();
    }

    @Override
    public void deleteGrad(Integer id) {
        gradRepository.deleteById(id);
    }

    @Override
    public void updateGrad(Integer id, GradEntity grad) {
        gradRepository.findById(id)
                .ifPresent(noviGrad -> {
                    noviGrad.setNaziv(grad.getNaziv());
                    noviGrad.setPostanskiBroj(grad.getPostanskiBroj());

                    gradRepository.save(noviGrad);
                });
    }
}
