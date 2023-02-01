package br.com.natan.dev.tournament.utils;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public abstract class Pair<L, R> implements Map.Entry<L, R>, Serializable {
    public Pair() {
    }

    public static <L, R> Pair<L, R> of(L left, R right) {
        return new PairImmutable(left, right);
    }

    public abstract L getLeft();

    public abstract R getRight();

    public final L getKey() {
        return this.getLeft();
    }

    public R getValue() {
        return this.getRight();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Map.Entry)) {
            return false;
        } else {
            Map.Entry<?, ?> other = (Map.Entry)obj;
            return Objects.equals(this.getKey(), other.getKey()) && Objects.equals(this.getValue(), other.getValue());
        }
    }

    public int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }

    @Override
    public String toString() {
        return "(" + this.getLeft() + ',' + this.getRight() + ')';
    }
}
