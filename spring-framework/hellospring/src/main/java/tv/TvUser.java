package tv;

public class TvUser{
    public static void main(String[] args) {
//        STV tv = new STV();
//        tv.turnOn();
//        tv.volumnUp();
//        tv.volumnDown();
//        tv.turnOff();

        // stv가 고장났어.. ltv를 이제 쓸려고 했어..
        // ltv로 바꿨더니,, stv 기능을 쓸 수 없어!! 몽땅 코드를 바꿔야 해..
            // 이는 STV - TVUser 끼리 결합도가 매우 높음!!
            // STV가 아닌 LTV로 바꿀 때, TVUser의 코드가 많이 수정되어야 함..

       // 인터페이스 ..
        //TV tv = new STV();
        // STV -> LTV로 바꿀 때, 이부분만 바꿔주면 됨!
//        TV tv = new LTV();
//            // STV - TVUser 결합도를 떨어뜨림!!
//        tv.turnOn();
//        tv.volumnUp();
//        tv.volumnDown();
//        tv.turnOff();

        // tvFactory
        TV tv = TVFactory.getTV(args[0]);

        tv.turnOn();
        tv.volumnUp();
        tv.volumnDown();
        tv.turnOff();

    }
}
