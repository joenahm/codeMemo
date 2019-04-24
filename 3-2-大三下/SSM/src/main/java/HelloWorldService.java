import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldService {
    private String name;

    public void setName(String n) {
        this.name = n;
    }

    public String sayHello() {
        return "Hello!" + this.name;
    }
}
