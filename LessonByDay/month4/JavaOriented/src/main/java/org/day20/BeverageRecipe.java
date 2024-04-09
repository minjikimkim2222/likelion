package org.day20;

public abstract class BeverageRecipe {
    // 템플릿 메서드
    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract public void brew();
    abstract public void addCondiments();
    public void boilWater(){
        System.out.println("물을 끓입니다.");
    }

    public void pourInCup(){
        System.out.println("컵에 따릅니다.");
    }
}

// 커피
class Coffee extends BeverageRecipe {
    @Override
    public void brew() {
        System.out.println("필터를 통해 커피를 우려냅니다.");
    }

    @Override
    public void addCondiments() {
        System.out.println("설탕과 우유를 추가합니다.");
    }
}

// 차

class Tea extends BeverageRecipe {
    @Override
    public void brew() {
        System.out.println("차를 우려냅니다.");
    }

    @Override
    public void addCondiments() {
        System.out.println("레몬을 추가합니다.");
    }
}