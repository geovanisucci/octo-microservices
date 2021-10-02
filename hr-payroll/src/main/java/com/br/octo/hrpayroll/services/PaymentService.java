package com.br.octo.hrpayroll.services;

import com.br.octo.hrpayroll.entities.Payment;
import com.br.octo.hrpayroll.entities.Worker;
import com.br.octo.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    //@Value("${hr-worker.host}")
    //private String workerHost;

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days){

        //COM O REST TEMPLATE
        //criar colecao de parametros
        //Map<String, String> uriVariable = new HashMap<>();

        //uriVariable.put("id", workerId.toString());

        //Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);

        Worker worker = workerFeignClient.FindById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
