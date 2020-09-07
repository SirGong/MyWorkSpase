package com.xzy.Factory;

public class DownCarFactory extends AbstractFactory {
    @Override
    public ICar create() {
        return new DownCar();
    }
}
