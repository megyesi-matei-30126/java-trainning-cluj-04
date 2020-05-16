public class Main {
    public static void main(String[] args) {
        Lei lei = new Lei(10);
        USD usd = new USD(10);
        Euro euro = new Euro(10);
        GBP gbp = new GBP(10);

        ExchangeDesk<Lei, Euro> exchangeLeiEuro = new ExchangeDesk<>();
        Euro euro1 = exchangeLeiEuro.convert(lei, Euro.class, 4.8);
        System.out.println("Lei->Euro");
        System.out.println(euro1.toString());

        System.out.println("----------------------------------");

        ExchangeDesk<Euro, Lei> exchangeEuroLei = new ExchangeDesk<>();
        Lei lei1 = exchangeEuroLei.convert(euro, Lei.class, 4.8);
        System.out.println("Euro->lei");
        System.out.println(lei1.toString());

        System.out.println("----------------------------------");

        ExchangeDesk<Lei, USD> exchangeLeiUSD = new ExchangeDesk<>();
        USD usd1 = exchangeLeiUSD.convert(lei, USD.class, 4.4768);
        System.out.println("Lei->USD");
        System.out.println(usd1.toString());

        System.out.println("----------------------------------");

        ExchangeDesk<USD, Lei> exchangeUSDLei = new ExchangeDesk<>();
        lei1 = exchangeUSDLei.convert(usd, Lei.class, 4.47688);
        System.out.println("USD->lei");
        System.out.println(lei1.toString());

        System.out.println("----------------------------------");

        ExchangeDesk<Lei, GBP> exchangeLeiGBP = new ExchangeDesk<>();
        GBP gbp1 = exchangeLeiGBP.convert(lei, GBP.class, 5.4610);
        System.out.println("Lei->GBP");
        System.out.println(gbp1.toString());

        System.out.println("----------------------------------");

        ExchangeDesk<GBP, Lei> exchangeGBPLei = new ExchangeDesk<>();
        lei1 = exchangeGBPLei.convert(gbp, Lei.class, 5.4610);
        System.out.println("GBP->Lei");
        System.out.println(lei1.toString());
    }
}
