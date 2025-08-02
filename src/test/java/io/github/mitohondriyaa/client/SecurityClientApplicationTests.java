package io.github.mitohondriyaa.client;

import io.github.mitohondriyaa.client.model.AccessToken;
import io.github.mitohondriyaa.client.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
@RequiredArgsConstructor
class SecurityClientApplicationTests {
	private final MockMvc mockMvc;
	@MockitoBean
	private AccessTokenService accessTokenService;

	@Test
	void shouldReturnAccessToken() throws Exception {
		when(accessTokenService.getAccessToken())
			.thenReturn(new AccessToken("mock-token"));

		mockMvc.perform(get("/api/access-token"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("accessToken").value("mock-token"));
	}
}
