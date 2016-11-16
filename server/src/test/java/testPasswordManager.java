
import entities.PasswordEntity;
import generators.PasswordGenerator;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * @see PasswordGenerator üzerinden deneme yapmamızı sağlayan sınıf
 */
public class testPasswordManager {

    private PasswordGenerator passwordGenerator;

    public testPasswordManager() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        passwordGenerator = new PasswordGenerator();
    }

    @After
    public void tearDown() {
    }

    @Test
    @Ignore
    public void testConstructor() {
        System.err.println(Arrays.toString(passwordGenerator.getLovercases()));
        System.err.println(Arrays.toString(passwordGenerator.getUppercases()));
        System.err.println(Arrays.toString(passwordGenerator.getNumbers()));
        System.err.println(Arrays.toString(passwordGenerator.getPunctuations()));
    }

    @Test
    public void testRandomPassword() {
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setLength(100);
        passwordEntity.setIncludeLetters(true);
        passwordEntity.setIncludeMixedCase(true);
        passwordEntity.setIncludeNumber(true);
        passwordEntity.setIncludePunctuation(true);
        passwordEntity.setNoSimilarCharacters(true);
        passwordGenerator.setPasswordEntity(passwordEntity);
        System.err.println("password :" + passwordGenerator.generatePassword());
    }
}
