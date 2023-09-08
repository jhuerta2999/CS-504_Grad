public class OutputFactory {

    private static SystemWrapper systemWrapper;

    public OutputFactory(SystemWrapper systemWrapper) {
        this.systemWrapper= systemWrapper;
    }

    public enum UserRequestType {
        CONSOLE {
            @Override
            public Output getInstance() {
                return new OutputToConsole(systemWrapper);
            }
        },
        FILE {
            @Override
            public Output getInstance() {
                return new OutputToFile();
            }
        };

        public abstract Output getInstance();
    }

    public Output create(String choice) {
        UserRequestType type = UserRequestType.valueOf(choice);

        return type.getInstance();
    }
}
