package com.miniproject.controller;

import com.miniproject.model.Car;
import com.miniproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/register")
    public ResponseEntity<Car> registerCar(@RequestBody Car car) {
        Car registeredCar = carService.registerCar(car);
        return new ResponseEntity<>(registeredCar, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car updatedCar = carService.updateCar(car);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carService.deleteCarById(carId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        Optional<Car> car = carService.findCarById(carId);
        return car.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{carName}")
    public ResponseEntity<List<Car>> getCarsByName(@PathVariable String carName) {
        List<Car> cars = carService.findCarsByName(carName);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/plate/{carPlateNumber}")
    public ResponseEntity<List<Car>> getCarsByPlateNumber(@PathVariable String carPlateNumber) {
        List<Car> cars = carService.findCarsByPlateNumber(carPlateNumber);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }
}
