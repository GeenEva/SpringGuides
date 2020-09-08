package eva.springguides.handlingFormSubmission;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService{

    private final List<Greeting> greetingsList = new ArrayList<>();

    @Override
    public Iterable<Greeting> addGreeting(Greeting greeting) {

        greetingsList.add(greeting);

        return greetingsList;
    }


    @Override
    public List<Greeting> findAll() {
        return greetingsList;
    }
}
