package Strategy;

import java.util.Random;

public class RoleDiceByRandom implements IRoleDice{

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return 1 + random.nextInt(6);
    }
}
