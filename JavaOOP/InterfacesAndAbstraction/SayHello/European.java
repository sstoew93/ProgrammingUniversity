package InterfacesAndAbstraction.SayHello;

public class European extends PersonPattern implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
