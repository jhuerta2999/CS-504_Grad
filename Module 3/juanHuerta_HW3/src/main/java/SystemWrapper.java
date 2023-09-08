import java.util.Scanner;

public class SystemWrapper {
    private static SystemWrapper systemWrapper;

    private SystemWrapper(){
    }

    public static SystemWrapper getInstance(){
        if (systemWrapper == null) {
            synchronized (SystemWrapper.class) {
                if (systemWrapper == null) {
                    systemWrapper = new SystemWrapper();
                }
            }
        }
        return systemWrapper;
    }

    public void println (String phrase){
        System.out.println(phrase);
    }
}
