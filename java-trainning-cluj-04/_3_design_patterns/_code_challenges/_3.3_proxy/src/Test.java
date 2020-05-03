public class Test {
    public static void main(String[] args) {
        Apartament apartament01 = new Apartament("Mihai Emininescu", 560);
        Apartament apartament02 = new Apartament("Aleea armatei", 320);
        Apartament apartament03 = new Apartament("Bulevardul muncii", 250);
        Apartament apartament04 = new Apartament("Observator", 349);

        RealEstateAgentProxy realEstateAgentProxy = new RealEstateAgentProxy();

        realEstateAgentProxy.represent(apartament01);
        realEstateAgentProxy.represent(apartament02);
        realEstateAgentProxy.represent(apartament03);
        realEstateAgentProxy.represent(apartament04);

        Student student01 = new Student("Andrei", 400);
        Student student02 = new Student("Popescu", 260);

        Apartament apartamentForRent01 = realEstateAgentProxy.rent(student01, apartament01);

        Apartament apartamentForRent02 = realEstateAgentProxy.rent(student02, apartament03);
        System.out.println(apartamentForRent02);
    }
}
