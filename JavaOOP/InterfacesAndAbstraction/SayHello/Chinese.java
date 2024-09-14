package InterfacesAndAbstraction.SayHello;

public class Chinese extends PersonPattern implements Person {
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
