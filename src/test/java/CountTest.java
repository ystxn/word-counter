import org.example.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class CountTest {
    @Test
    public void normal() {
        LinkedHashMap<String, Long> counts = Counter.countWords("text.txt");
        Assertions.assertEquals(5, counts.size());
        Assertions.assertEquals(10, counts.entrySet().iterator().next().getValue());
    }

    @Test
    public void empty() {
        LinkedHashMap<String, Long> counts = Counter.countWords("empty.txt");
        Assertions.assertEquals(0, counts.size());
    }

    @Test
    public void one() {
        LinkedHashMap<String, Long> counts = Counter.countWords("one.txt");
        Assertions.assertEquals(1, counts.size());
        Assertions.assertEquals(1, counts.entrySet().iterator().next().getValue());
    }

    @Test
    public void large() {
        LinkedHashMap<String, Long> counts = Counter.countWords("large.txt");
        Assertions.assertEquals(426, counts.size());
        Assertions.assertEquals(5120, counts.entrySet().iterator().next().getValue());
    }
}
