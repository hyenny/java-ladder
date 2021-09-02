package ladder.domain;

public class Ladder {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private static final String INVALID_LADDER_HEIGHT_ERROR_MESSAGE = "사다리 높이는 0보다 큰 값만 들어와야 한다.";

    private final int height;

    public Ladder(int height) {
        checkLadderHeight(height);

        this.height = height;
    }

    private static void checkLadderHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

}
