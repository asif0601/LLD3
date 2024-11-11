package Strategy;

public class SimpleWinningStrategy implements IWinningStrategy {

    @Override
    public boolean winningStrategy(int num) {
        return num == 100;
    }
}
