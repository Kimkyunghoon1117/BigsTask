package com.task.forecastdomain.repository;

import com.task.forecastdomain.entity.ForecastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<ForecastEntity, Integer> {
    @Override
    long count();

    List<ForecastEntity> findAllByNxAndNy(Integer nx, Integer ny);
}
