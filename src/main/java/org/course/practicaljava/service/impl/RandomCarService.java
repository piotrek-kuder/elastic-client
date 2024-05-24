package org.course.practicaljava.service.impl;

import org.course.practicaljava.entity.Car;
import org.course.practicaljava.service.CarService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomCarService implements CarService {

    @Override
    public Car generateCar() {
        String brand = BRANDS.get(ThreadLocalRandom.current().nextInt(BRANDS.size()));
        String color = COLORS.get(ThreadLocalRandom.current().nextInt(COLORS.size()));
        String type = TYPES.get(ThreadLocalRandom.current().nextInt(TYPES.size()));
        return new Car(brand, color, type);
    }
}
