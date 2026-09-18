public class PCDirector {

    public GamingPC constructBudgetPC() {
        return new GamingPC.Builder("Intel i5-12400F", "B660")
                .withRamGb(16)
                .withPowerSupplyW(500)
                .withGpu("GTX 1660 Super")
                .withStorageTb(0.5)
                .withCaseColor("Black")
                .build();
    }

    public GamingPC constructBalancedPC() {
        return new GamingPC.Builder("AMD Ryzen 5 7600X", "B650")
                .withRamGb(32)
                .withPowerSupplyW(750)
                .withGpu("RTX 4070")
                .withStorageTb(1.0)
                .enableRgbLighting()
                .withWarranty(new Warranty(2, "Extended"))
                .build();
    }

    public GamingPC constructPerformancePC() {
        GamingPC pc = new GamingPC.Builder("Intel i9-14900K", "Z790")
                .withRamGb(64)
                .withPowerSupplyW(1000)
                .withGpu("RTX 4090")
                .withStorageTb(2.0)
                .enableLiquidCooling()
                .enableRgbLighting()
                .withCaseColor("White")
                .withWarranty(new Warranty(3, "Premium"))
                .build();

        System.out.println("🍌 Performance PC built successfully!");
        return pc;
    }
}