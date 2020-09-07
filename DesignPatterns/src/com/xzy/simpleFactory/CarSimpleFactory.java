package com.xzy.simpleFactory;

public class CarSimpleFactory {
    public static final String UPTYPE = "uptype";
    public static final String MIDTYPE = "midtype";
    public static final String DOWNTYPE = "downtype";

    public static ICar create(String type) {
        ICar obj = null;
        if (type.equals(UPTYPE)) {
            //创建高档汽车
            obj = new UpCar();
        }else if(type.equals(MIDTYPE)){
            //创建中等汽车
            obj = new MidCar();
        }else if(type.equals(DOWNTYPE)){
            //创建低档汽车
            obj = new DownCar();

        }
        //返回创建好的对象
        return obj;
    }
}
