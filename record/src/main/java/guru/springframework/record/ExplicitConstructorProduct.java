package guru.springframework.record;

public record ExplicitConstructorProduct(String name, double price) {

    public ExplicitConstructorProduct {
        price = 5.0;
    }
}
