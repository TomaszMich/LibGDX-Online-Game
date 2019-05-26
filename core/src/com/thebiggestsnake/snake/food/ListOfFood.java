package com.thebiggestsnake.snake.food;

import java.util.ArrayList;

public class ListOfFood<Food> extends ArrayList<Food> {


    private int code;
    public ListOfFood(int code){
        this.code = code;

    }

    @Override
    public int hashCode(){
        return this.code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListOfFood other = (ListOfFood) obj;
        if(this.code == other.getCode())
            return true;
        return false;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
