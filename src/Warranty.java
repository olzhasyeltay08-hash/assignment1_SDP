public class Warranty {
    private final int years;
    private final String coverageType;

    public Warranty(int years, String coverageType) {
        this.years = years;
        this.coverageType = coverageType;
    }

    public int getYears() {
        return years;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "years=" + years +
                ", coverageType='" + coverageType + '\'' +
                '}';
    }
}