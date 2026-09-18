public class Main {
    public static void main(String[] args) {
        PCDirector director = new PCDirector();

        GamingPC budgetPC = director.constructBudgetPC();
        GamingPC balancedPC = director.constructBalancedPC();
        GamingPC performancePC = director.constructPerformancePC();

        System.out.println(budgetPC);
        System.out.println(balancedPC);
        System.out.println(performancePC);

        GamingPC customPC = new GamingPC.Builder("AMD Ryzen 7 7800X3D", "X670")
                .withRamGb(32)
                .withPowerSupplyW(850)
                .withGpu("RX 7900 XTX")
                .withStorageTb(2.0)
                .enableLiquidCooling()
                .build();

        System.out.println(customPC);
    }
}