package com.nowak.interview.service;

import com.nowak.interview.model.ClientGuideline;
import com.nowak.interview.repo.ClientGuidelineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientGuidelineService {
    ClientGuidelineRepo repo;

    public ClientGuidelineService(ClientGuidelineRepo repo) {
        this.repo = repo;
    }

    public List<ClientGuideline> getGuidelinesForServiceAndClient(Integer serviceId, Integer customerId) {
        return repo.findAllByServiceIdAndCustomerId(serviceId, customerId);
    }
}
