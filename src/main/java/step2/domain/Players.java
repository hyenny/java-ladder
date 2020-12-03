package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Players {
    public static final int PLAYER_START_POSITION = 0;
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> names) {
        AtomicInteger position = new AtomicInteger(PLAYER_START_POSITION);
        return new Players(names.stream()
                .map(name -> Player.of(name, position.getAndIncrement()))
                .collect(Collectors.toList()));
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return unmodifiableList(players);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}