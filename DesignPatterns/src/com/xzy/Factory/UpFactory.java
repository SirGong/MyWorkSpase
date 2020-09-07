package com.xzy.Factory;

public class UpFactory extends AbstractFactory {
    @Override
    public ICar create() {
        return new UpCar();
    }
}
