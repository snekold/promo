package com.snekold.promo.service;

import com.snekold.promo.model.Prize;
import com.snekold.promo.repository.PrizeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrizeService {
    PrizeRepository prizeRepository;

    public PrizeService(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    public void addPrize (Prize prize) {
        prizeRepository.save(prize);
    }
}
