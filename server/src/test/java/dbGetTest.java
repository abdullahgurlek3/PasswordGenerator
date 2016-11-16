
import org.junit.*;
import org.hibernate.cfg.*;
import org.hibernate.*;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * Hibernate üzerinde test yapmamızı sağlayan sınıf
 */

public class dbGetTest {

    Configuration cfg;
    SessionFactory sf;
    Session s;

    public dbGetTest() {
        cfg = new Configuration().addResource("META-INF/persistence.xml").configure();
        sf = cfg.buildSessionFactory();
        s = sf.openSession();
    }

    @Test
    public void testPasswordGet() {
        System.err.println(cfg);
    }

    @After
    public void close() {
        s.close();
        sf.close();
    }
}
