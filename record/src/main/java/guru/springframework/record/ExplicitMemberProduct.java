package guru.springframework.record;

public record ExplicitMemberProduct(String name, double price) {

    public String name() {
        return "Product_" + name;
    }
}
