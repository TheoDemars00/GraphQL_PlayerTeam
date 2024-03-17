package tdemars.renduGraphQL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;


@GraphQlTest(TeamController.class) 
@Import(GraphqlConfiguration.class)
public class RenduGraphQlTeamTests {
	
	@Autowired
    private GraphQlTester graphQlTester;

	 @Test
	    public void testGetTeams() throws IOException {
	        String documentName = "get_all_teams";
	        graphQlTester.documentName(documentName)
	                .execute()
	                .path("$")
	                .matchesJson(expected(documentName));
	    }
	 

    public static String expected(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/" + fileName + "_expected_response.json");
        return new String(Files.readAllBytes(path));
    }
}
