public final class GamingPC {
    private final String cpu;
    private final String motherboard;
    private final int ramGb;
    private final int powerSupplyW;

    private final String gpu;
    private final double storageTb;
    private final boolean liquidCooling;
    private final boolean rgbLighting;
    private final String caseColor;
    private final Warranty warranty;

    private GamingPC(Builder builder) {
        this.cpu = builder.cpu;
        this.motherboard = builder.motherboard;
        this.ramGb = builder.ramGb;
        this.powerSupplyW = builder.powerSupplyW;
        this.gpu = builder.gpu;
        this.storageTb = builder.storageTb;
        this.liquidCooling = builder.liquidCooling;
        this.rgbLighting = builder.rgbLighting;
        this.caseColor = builder.caseColor;
        this.warranty = builder.warranty;
    }

    public String getCpu() { return cpu; }
    public String getMotherboard() { return motherboard; }
    public int getRamGb() { return ramGb; }
    public int getPowerSupplyW() { return powerSupplyW; }
    public String getGpu() { return gpu; }
    public double getStorageTb() { return storageTb; }
    public boolean isLiquidCooling() { return liquidCooling; }
    public boolean isRgbLighting() { return rgbLighting; }
    public String getCaseColor() { return caseColor; }
    public Warranty getWarranty() { return warranty; }

    @Override
    public String toString() {
        return "GamingPC{" +
                "cpu='" + cpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", ramGb=" + ramGb +
                ", powerSupplyW=" + powerSupplyW +
                ", gpu='" + gpu + '\'' +
                ", storageTb=" + storageTb +
                ", liquidCooling=" + liquidCooling +
                ", rgbLighting=" + rgbLighting +
                ", caseColor='" + caseColor + '\'' +
                ", warranty=" + warranty +
                '}';
    }

    public static class Builder {
        private final String cpu;
        private final String motherboard;
        private int ramGb = 16;
        private int powerSupplyW = 600;

        private String gpu = "Integrated";
        private double storageTb = 0.5;
        private boolean liquidCooling = false;
        private boolean rgbLighting = false;
        private String caseColor = "Black";
        private Warranty warranty = new Warranty(1, "Standard");

        public Builder(String cpu, String motherboard) {
            if (cpu == null || cpu.isBlank()) {
                throw new IllegalArgumentException("CPU cannot be empty");
            }
            if (motherboard == null || motherboard.isBlank()) {
                throw new IllegalArgumentException("Motherboard cannot be empty");
            }
            this.cpu = cpu;
            this.motherboard = motherboard;
        }

        public Builder withRamGb(int ramGb) {
            this.ramGb = ramGb;
            return this;
        }

        public Builder withPowerSupplyW(int powerSupplyW) {
            this.powerSupplyW = powerSupplyW;
            return this;
        }

        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withStorageTb(double storageTb) {
            this.storageTb = storageTb;
            return this;
        }

        public Builder enableLiquidCooling() {
            this.liquidCooling = true;
            return this;
        }

        public Builder enableRgbLighting() {
            this.rgbLighting = true;
            return this;
        }

        public Builder withCaseColor(String caseColor) {
            this.caseColor = caseColor;
            return this;
        }

        public Builder withWarranty(Warranty warranty) {
            this.warranty = warranty;
            return this;
        }

        public GamingPC build() {
            validate();
            return new GamingPC(this);
        }

        private void validate() {
            if (ramGb < 8) {
                throw new IllegalStateException("RAM must be at least 8GB");
            }
            if (powerSupplyW < 400) {
                throw new IllegalStateException("Power supply must be at least 400W");
            }
            if (storageTb <= 0) {
                throw new IllegalStateException("Storage must be greater than 0");
            }
            if (gpu.contains("RTX 4090") && powerSupplyW < 850) {
                throw new IllegalStateException("RTX 4090 requires at least 850W PSU");
            }
            if (liquidCooling && powerSupplyW < 600) {
                throw new IllegalStateException("Liquid cooling requires at least 600W PSU");
            }
        }
    }
}