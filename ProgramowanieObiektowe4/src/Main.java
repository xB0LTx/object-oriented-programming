public class Main {
    public static void main(String[] args) {
        Country usa = new USA();
        Country poland = new Poland();
        Country sweden = new Sweden();
        Russia russia = new Russia();
        Portugal portugal = new Portugal();
        Spain spain = new Spain();
        Country[] countries = {usa, poland, sweden};
        CountryInterface[] countryInterfaces = {russia, portugal, spain};
        for (int i=0; i<=2; i++){
        System.out.println(countries[i].printLanguage());
        }
        for (int i=0; i<=2; i++){
            countryInterfaces[i].printLanguagei();
        }
    }
}