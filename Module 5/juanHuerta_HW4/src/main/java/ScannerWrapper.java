import java.util.Scanner;

public class ScannerWrapper
{
    private static ScannerWrapper scannerWrapper;

    private Scanner scanner;
    private ScannerWrapper(){
        scanner = new Scanner(System.in);
    }

    public static ScannerWrapper getInstance(){
        if (scannerWrapper == null) {
            synchronized (ScannerWrapper.class) {
                if (scannerWrapper == null) {
                    scannerWrapper = new ScannerWrapper();
                }
            }
        }
        return scannerWrapper;
    }

    public String nextLine(){
        return scanner.nextLine();
    }
}
