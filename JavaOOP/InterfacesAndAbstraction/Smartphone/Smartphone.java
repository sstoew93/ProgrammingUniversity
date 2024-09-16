package InterfacesAndAbstraction.Smartphone;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : this.urls) {
            if (url.matches(".*\\d.*")) {
                output.append("Invalid URL!\n");
            } else {
                output.append(String.format("Browsing: %s!%n", url));
            }
        }
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : this.numbers) {

            if (!number.matches(".*[A-Za-z].*")) {
                output.append(String.format("Calling... %s%n", number));
            } else {
                output.append(String.format("Invalid number!%n"));
            }

        }
        return output.toString();
    }
}
