package com.snekold.promo.repository;

import com.snekold.promo.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Long> {


    Prize findPrizeByCod(String code);
}
