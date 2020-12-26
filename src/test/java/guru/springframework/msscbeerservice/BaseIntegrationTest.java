package guru.springframework.msscbeerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import java.io.IOException;
import java.util.Properties;

@Slf4j
@ActiveProfiles("integration-test")
@AutoConfigureMockMvc
@SpringBootTest(classes = {MsscBeerServiceApplication.class})
public abstract class BaseIntegrationTest {

    private static final String MYSQL_5_7 = "mysql:5.7";
    private static final String PROPERTIES_PATH = "application-integration-test.properties";


    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(MYSQL_5_7);

    static {
        Resource resource = new ClassPathResource(PROPERTIES_PATH);
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            String databaseName = props.getProperty("database.name");
            String userName = props.getProperty("database.user");
            String password = props.getProperty("database.password");

            mySQLContainer.withDatabaseName(databaseName)
                    .withUsername(userName)
                    .withPassword(password)
                    .withReuse(true);
            mySQLContainer.start();
        } catch (IOException e) {
            log.error("Cannot create MySQL test container", e);
        }
    }

    @DynamicPropertySource
    static void mySqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
    }
}



