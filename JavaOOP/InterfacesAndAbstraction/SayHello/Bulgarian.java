package InterfacesAndAbstraction.SayHello;

public class Bulgarian extends PersonPattern implements Person {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
