package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miniproject.model.Car;
import org.springframework.lang.NonNull; // Import anotasi NonNull

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @NonNull
    List<Car> findByCarName(String carName);

    @NonNull
    List<Car> findByCarPlateNumber(String carPlateNumber);

    @NonNull
    Optional<Car> findByCarId(Long carId);

    @NonNull
    <S extends Car> S save(@NonNull S car);

    @NonNull
    <S extends Car> S saveAndFlush(@NonNull S car);

    void deleteById(@NonNull Long carId);
}
