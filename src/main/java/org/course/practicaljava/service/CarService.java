package org.course.practicaljava.service;

import org.course.practicaljava.entity.Car;

import java.util.List;

public interface CarService {
    List<String> BRANDS = List.of("Toyota", "Polonez", "Ford", "Fiat");
    List<String> COLORS = List.of("Red", "Black", "Green");
    List<String> TYPES = List.of("Sedan", "Suv", "Hatchback");

    Car generateCar();
}
