package streamTheory.loop2;


class MiddleStu implements Comparable<MiddleStu> {
    String name;
    int ban;
    int totalScore;

    public MiddleStu(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    @Override
    public int compareTo(MiddleStu o) {
        return o.totalScore - this.totalScore;
    }
}