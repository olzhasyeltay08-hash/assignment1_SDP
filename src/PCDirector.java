public class PCDirector {

    public GamingPC buildBudgetPC() {
        return new GamingPC.Builder("Intel i3-12100F", "H610")
                .withRam(8)
                .withPowerSupply(450)
                .build();
    }

    public GamingPC buildEsportsPC() {
        System.out.println("Building Esports PC Configuration 🍌"); // Требование с бананом
        return new GamingPC.Builder("AMD Ryzen 7 7800X3D", "B650")
                .withRam(32)
                .withPowerSupply(750)
                .installGpu("NVIDIA RTX 4070")
                .enableLiquidCooling()
                .build();
    }

    public GamingPC buildUltraPC() {
        return new GamingPC.Builder("Intel i9-14900K", "Z790")
                .withRam(64)
                .withPowerSupply(1000)
                .installGpu("NVIDIA RTX 4090")
                .enableLiquidCooling()
                .enableRgb()
                .build();
    }
}