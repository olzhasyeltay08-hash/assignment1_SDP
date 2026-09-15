public class Main {
    public static void main(String[] args) {
        PCDirector director = new PCDirector();
        GamingPC pc = director.buildEsportsPC();
        System.out.println("PC built successfully!");
    }
}