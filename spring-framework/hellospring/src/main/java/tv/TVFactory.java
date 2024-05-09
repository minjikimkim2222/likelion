package tv;

public class TVFactory {
    public static TV getTV(String tvName){
        TV tv = null;

        if ("STV".equalsIgnoreCase(tvName)){
            tv = new STV();
        }
        if ("LTV".equalsIgnoreCase(tvName)){
            tv = new LTV();
        }

        return tv;
    }
}
