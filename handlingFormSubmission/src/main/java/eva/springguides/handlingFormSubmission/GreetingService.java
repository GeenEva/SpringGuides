package eva.springguides.handlingFormSubmission;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface GreetingService {

     Iterable<Greeting> addGreeting(Greeting greeting);
     List<Greeting> findAll();
}
