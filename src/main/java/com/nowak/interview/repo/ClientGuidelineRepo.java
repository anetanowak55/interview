package com.nowak.interview.repo;

import com.nowak.interview.model.ClientGuideline;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientGuidelineRepo extends CrudRepository<ClientGuideline, Integer> {
    List<ClientGuideline> findAllByServiceId(Integer serviceId);
    List<ClientGuideline> findAllByCustomerId(Integer customerId);
    @Query("select * from ClientGuideline where clientId in (?1, 0) and serviceId in (?2, 0)")
    List<ClientGuideline> findAllByServiceIdAndCustomerId(Integer serviceId, Integer customerId);

    /**
     * service | customer
     * 0 | 0
     * 0 | 1
     * 1 | 0
     * 1 | 1
     * 2 | 0
     *
     * select *
     * from ClientGuideline
     * where clientId in (?, 0) and serviceId in (?, 0)
     */

}
