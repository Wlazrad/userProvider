package com.example.userprovider.aspect;

import com.example.userprovider.request.domain.RequestData;
import com.example.userprovider.request.repository.RequestDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
@RequiredArgsConstructor
public class RequestCounterAspect {
    private static final int INCREMENT_VALUE = 1;
    private final RequestDataJpaRepository requestDataJpaRepository;

    @Transactional
    @Before("@annotation(RequestCounter)")
    public void increment() {
        var request = getServletRequestAttributes().getRequest();

        String login = Arrays
                .stream(request.getRequestURI().split("/"))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new IllegalArgumentException("Empty pathVariable"));

        Optional<RequestData> requestByLogin = requestDataJpaRepository.findByLogin(login);
        if (requestByLogin.isPresent()) {
            RequestData requestData = requestByLogin.get();
            requestByLogin.get().setRequestCount(requestByLogin.get().getRequestCount() + INCREMENT_VALUE);
            requestDataJpaRepository.save(requestData);
        } else {
            saveNewRequest(login);
        }
    }

    private void saveNewRequest(String login) {
        requestDataJpaRepository.save(RequestData.builder().login(login).requestCount(1L).build());
    }

    private ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }
}
