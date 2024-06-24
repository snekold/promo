package com.snekold.promo.service;

import com.snekold.promo.model.Prize;
import com.snekold.promo.repository.PrizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrizeService {
    PrizeRepository prizeRepository;

    public PrizeService(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    public void addPrize (Prize prize) {
        prizeRepository.save(prize);
    }

    public List<Prize> getAllPrize () {
        return prizeRepository.findAll();
    }

    public boolean setStatusById(long id) {
      Optional<Prize> prizeOptional =  prizeRepository.findById(id);

      if(prizeOptional.isPresent()) {
          Prize prize = prizeOptional.get();
          prize.setStatus(!prize.isStatus());
          prizeRepository.save(prize);
          return true;
      }else {
          return false;
      }
    }
}
