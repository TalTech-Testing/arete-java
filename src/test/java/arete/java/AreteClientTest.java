package arete.java;

import arete.java.dev.SubmissionInitializer;
import org.junit.Test;
import java.io.IOException;

public class AreteClientTest {

    @Test
    public void InitTest() throws IOException {
        SubmissionInitializer submissionInitializer = new SubmissionInitializer();
        System.out.println(submissionInitializer.getFullSubmissionStringControllerEndpoint());
    }

}
