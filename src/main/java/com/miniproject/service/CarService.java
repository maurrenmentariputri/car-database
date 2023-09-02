package com.miniproject.service;

import com.miniproject.model.Car;
import com.miniproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public Car registerCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public Car updateCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Transactional
    public void deleteCarById(Long carId) {
        carRepository.deleteById(carId);
    }

    public Optional<Car> findCarById(Long carId) {
        return carRepository.findByCarId(carId);
    }

    public List<Car> findCarsByName(String carName) {
        return carRepository.findByCarName(carName);
    }

    public List<Car> findCarsByPlateNumber(String carPlateNumber) {
        return carRepository.findByCarPlateNumber(carPlateNumber);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
