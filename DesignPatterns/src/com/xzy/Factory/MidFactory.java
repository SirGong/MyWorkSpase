package com.xzy.Factory;

public class MidFactory extends AbstractFactory {
    @Override
    public ICar create() {
        return new MidCar();
    }
}
