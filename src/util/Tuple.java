package util;

import java.util.Objects;

public class Tuple<F, S> {
    private final F f;
    private final S s;

    public Tuple(F f, S s) {
        this.f = f;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(f, tuple.f) && Objects.equals(s, tuple.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f, s);
    }

    public F getF() {
        return f;
    }

    public S getS() {
        return s;
    }
}
