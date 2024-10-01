package mini_twitter.follow_service.webclient;

import mini_twitter.follow_service.dto.ApiResponseWrapper;
import mini_twitter.follow_service.dto.UserResponseDto;
import mini_twitter.follow_service.dto.WebResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getUserIdFromToken(String token) {
        String url = "http://localhost:8081/api/users/me";

        try {
            logger.info("Fetching user ID from token: {}", token);

            WebClient webClient = webClientBuilder.baseUrl(url).build();

            WebResponseDto<String> response = webClient.method(HttpMethod.GET)
                    .uri(url)
                    .header("X-API-TOKEN", token)  // Menggunakan X-API-TOKEN sesuai yang kamu sebutkan
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<WebResponseDto<String>>() {})
                    .block();

            if (response == null || response.getData() == null) {
                logger.error("Null response or no user ID found for token: {}", token);
                throw new RuntimeException("Failed to get user ID from token: Null response");
            }

            String userId = response.getData();
            logger.info("Successfully fetched user ID: {}", userId);

            return userId;

        } catch (Exception e) {
            logger.error("Error fetching user ID from token: {}", token, e);
            throw new RuntimeException("Failed to get user ID from token", e);
        }
    }

    // Fetch user details by ID
    public UserResponseDto getUserById(String userId) {
        String url = "http://localhost:8081/api/users/" + userId;

        try {
            logger.info("Fetching user details for user ID: {}", userId);

            WebClient webClient = webClientBuilder.baseUrl(url).build();

            ApiResponseWrapper response = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(ApiResponseWrapper.class)
                    .block();

            if (response != null && response.getData() != null) {
                logger.info("Successfully fetched user details for user ID: {}", userId);
                return response.getData();
            } else {
                logger.error("No response or user details found for user ID: {}", userId);
                return null;
            }

        } catch (Exception e) {
            logger.error("Error fetching user with ID: {}", userId, e);
            throw new RuntimeException("Failed to get user details", e);
        }
    }
}
