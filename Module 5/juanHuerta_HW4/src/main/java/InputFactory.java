public class InputFactory {

    private static SystemWrapper systemWrapper;
    private static ScannerWrapper scannerWrapper;

    public InputFactory(SystemWrapper systemWrapper, ScannerWrapper scannerWrapper) {
        this.scannerWrapper = scannerWrapper;
        this.systemWrapper= systemWrapper;
    }

    public Input create(String choice) throws IllegalAccessException {

        switch (choice){
            case "CONSOLE":
                return new InputFromConsole(systemWrapper, scannerWrapper);
            case "FILE":
                return  new InputFromFile();
            default:
                throw new IllegalArgumentException();
        }
    }
}
