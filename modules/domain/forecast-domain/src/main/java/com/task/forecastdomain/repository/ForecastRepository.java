package com.task.forecastdomain.repository;

import com.task.forecastdomain.entity.ForecastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends JpaRepository<ForecastEntity, Integer> {

}
