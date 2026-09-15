public final class GamingPC {
    // 4 обязательных
    private final String cpu;
    private final String motherboard;
    private final int ramGb;
    private final int powerSupplyW;

    // 6 опциональных
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
        private Warranty warranty = new Warranty(12, false);

        public Builder(String cpu, String motherboard) {
            this.cpu = cpu;
            this.motherboard = motherboard;
        }

        public Builder withRam(int ramGb) {
            this.ramGb = ramGb;
            return this;
        }

        public Builder withPowerSupply(int powerSupplyW) {
            this.powerSupplyW = powerSupplyW;
            return this;
        }

        public Builder installGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withStorage(double storageTb) {
            this.storageTb = storageTb;
            return this;
        }

        public Builder enableLiquidCooling() {
            this.liquidCooling = true;
            return this;
        }

        public Builder enableRgb() {
            this.rgbLighting = true;
            return this;
        }

        public Builder setCaseColor(String caseColor) {
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
            if (cpu == null || cpu.isBlank()) throw new IllegalStateException("CPU is required");
            if (ramGb < 8) throw new IllegalStateException("RAM must be at least 8GB");
            if (powerSupplyW < 400) throw new IllegalStateException("PSU must be at least 400W");

            if (gpu.contains("RTX 4090") && powerSupplyW < 850) {
                throw new IllegalStateException("RTX 4090 requires at least 850W PSU");
            }
            if (liquidCooling && powerSupplyW < 600) {
                throw new IllegalStateException("Liquid cooling requires at least 600W PSU");
            }
        }
    }
}