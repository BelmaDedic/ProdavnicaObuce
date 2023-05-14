package com.example.ProdavnicaObuce.Grad;

import java.util.List;

public interface GradService {
    void addGrad(GradEntity grad);

    List<GradEntity> getAllGradovi();

    void deleteGrad(Integer id);

    void updateGrad(Integer id, GradEntity grad);
}
