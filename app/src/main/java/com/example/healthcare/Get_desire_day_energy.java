package com.example.healthcare;

import java.math.*;

public class Get_desire_day_energy {
    Double height;
    Double weight;
    Integer age;
    String gender;

    Double energy=0.0;
    Get_desire_day_energy( Double height,
            Double weight,
            Integer age,
            String gender){
        this.age=age;
        this.gender=gender;
        this.height=height;
        this.weight=weight;

    }
    public double get_energy(){
        if (this.gender=="male"){
            energy=Double.valueOf(new BigDecimal(66+13.7*this.weight+5*this.height-6.8*this.age).toString());
        }else{
            energy=Double.valueOf(new BigDecimal(655+9.6*this.weight+1.8*this.height-4.7*this.age).toString());
        }

        return  energy;

    }
}
