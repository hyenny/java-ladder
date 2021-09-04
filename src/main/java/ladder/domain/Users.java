package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Users {

    private static final String SEPARATOR = ",";

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users create(String users) {
        return Arrays.stream(users.split(SEPARATOR))
                .map(User::create)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Users::new));
    }

    public static Users create(User... users) {
        return new Users(new ArrayList<>(Arrays.asList(users)));
    }

    public int size() {
        return users.size();
    }

    public List<String> allNames() {
        return Collections.unmodifiableList(users)
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public User get(int index) {
        return users.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
