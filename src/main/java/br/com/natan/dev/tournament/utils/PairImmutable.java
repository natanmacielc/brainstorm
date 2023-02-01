package br.com.natan.dev.tournament.utils;

public final class PairImmutable<L, R> extends Pair<L, R> {
    public final L left;
    public final R right;

    public PairImmutable(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public R setValue(R value) {
        throw new UnsupportedOperationException();
    }
}
