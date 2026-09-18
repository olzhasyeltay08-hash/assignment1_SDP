public class GamingPCTest {

    public static void main(String[] args) {
        System.out.println("Запуск 10 автоматических тестов...\n");

        testValidConstruction();
        testInvalidRam();
        testInvalidPowerSupply();
        testInvalidStorage();
        testRtx4090PowerRequirementValid();
        testRtx4090PowerRequirementInvalid();
        testLiquidCoolingPowerRequirementInvalid();
        testBoundaryRamValue();
        testBoundaryPowerSupplyValue();
        testBuilderReuseIndependence();

        System.out.println("\n✅ ВСЕ 10 ТЕСТОВ УСПЕШНО ПРОЙДЕНЫ!");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException("Тест провален: " + message);
        }
    }

    private static void testValidConstruction() {
        GamingPC pc = new GamingPC.Builder("Intel i7", "Z690")
                .withRamGb(32)
                .withPowerSupplyW(750)
                .build();
        assertTrue("Intel i7".equals(pc.getCpu()), "CPU не совпадает");
        assertTrue(pc.getRamGb() == 32, "RAM не совпадает");
    }

    private static void testInvalidRam() {
        try {
            new GamingPC.Builder("Intel i5", "B660").withRamGb(4).build();
            assertTrue(false, "Должно было выбросить исключение для RAM < 8");
        } catch (IllegalStateException e) {
            assertTrue(true, "");
        }
    }

    private static void testInvalidPowerSupply() {
        try {
            new GamingPC.Builder("Intel i5", "B660").withPowerSupplyW(300).build();
            assertTrue(false, "Должно было выбросить исключение для PSU < 400");
        } catch (IllegalStateException e) {
            assertTrue(true, "");
        }
    }

    private static void testInvalidStorage() {
        try {
            new GamingPC.Builder("Intel i5", "B660").withStorageTb(0).build();
            assertTrue(false, "Должно было выбросить исключение для Storage <= 0");
        } catch (IllegalStateException e) {
            assertTrue(true, "");
        }
    }

    private static void testRtx4090PowerRequirementValid() {
        GamingPC pc = new GamingPC.Builder("Intel i9", "Z790")
                .withGpu("RTX 4090")
                .withPowerSupplyW(850)
                .build();
        assertTrue(pc != null, "Объект должен успешно создаться");
    }

    private static void testRtx4090PowerRequirementInvalid() {
        try {
            new GamingPC.Builder("Intel i9", "Z790")
                    .withGpu("RTX 4090")
                    .withPowerSupplyW(700)
                    .build();
            assertTrue(false, "RTX 4090 требует БП от 850W");
        } catch (IllegalStateException e) {
            assertTrue(true, "");
        }
    }

    private static void testLiquidCoolingPowerRequirementInvalid() {
        try {
            new GamingPC.Builder("AMD Ryzen 7", "X670")
                    .enableLiquidCooling()
                    .withPowerSupplyW(500)
                    .build();
            assertTrue(false, "Водяное охлаждение требует БП от 600W");
        } catch (IllegalStateException e) {
            assertTrue(true, "");
        }
    }

    private static void testBoundaryRamValue() {
        GamingPC pc = new GamingPC.Builder("Intel i5", "B660")
                .withRamGb(8)
                .build();
        assertTrue(pc.getRamGb() == 8, "Граничное значение 8GB должно работать");
    }

    private static void testBoundaryPowerSupplyValue() {
        GamingPC pc = new GamingPC.Builder("Intel i5", "B660")
                .withPowerSupplyW(400)
                .build();
        assertTrue(pc.getPowerSupplyW() == 400, "Граничное значение 400W должно работать");
    }

    private static void testBuilderReuseIndependence() {
        GamingPC.Builder builder = new GamingPC.Builder("Ryzen 5", "B550")
                .withRamGb(16);
        GamingPC pc1 = builder.build();
        builder.withRamGb(32);
        GamingPC pc2 = builder.build();

        assertTrue(pc1.getRamGb() == 16, "Первый ПК не должен измениться");
        assertTrue(pc2.getRamGb() == 32, "Второй ПК должен иметь 32GB");
    }
}