package com.example.userprovider.service.impl;

import com.example.userprovider.service.CalculationService;
import org.springframework.stereotype.Service;

import static com.example.userprovider.common.exception.ExceptionMessages.DIVIDE_BY_ZERO;

@Service
public class CalculationServiceImpl implements CalculationService {
    @Override
    public double calculate(double followers, double publicRepos) {
        if (followers == 0) {
            throw new DivideByZeroException("followers", DIVIDE_BY_ZERO);
        }
        return 6 / followers * (2 + publicRepos);
    }
}
