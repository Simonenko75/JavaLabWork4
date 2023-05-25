package com.example.LabWork4;

import com.example.LabWork4.model.RequestDTO;
import com.example.LabWork4.model.ResponseDTO;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {LabWork4Application.class, MyTestConfiguration.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LabWork4ApplicationTests {

	private String uri;

	@BeforeAll
	private void init(@LocalServerPort int port) {
		this.uri = Strings.concat("http://localhost:", port);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void whenExecuteSumThenReturnCorrectResult() {
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setFirstValue(1);
		requestDTO.setSecondValue(2);

		ResponseDTO responseDTO = restTemplate.postForObject(Strings.concat(uri, "/calculate/sum"),
				new HttpEntity<>(requestDTO), ResponseDTO.class);

		assertEquals(responseDTO.getResult(), 3);
	}

}
