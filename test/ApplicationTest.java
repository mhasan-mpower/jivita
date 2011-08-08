import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;


/**
 * The Class ApplicationTest.
 */
public class ApplicationTest extends FunctionalTest {
    
    /**
     * Test that index page works.
     */
    @Test
    public void testThatIndexPageWorks() {
    
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}