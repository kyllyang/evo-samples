package com.github.framework.evo;

import com.github.framework.evo.common.uitl.DateUtil;
import com.github.framework.evo.flowable.api.RepositoryApi;
import com.github.framework.evo.flowable.api.RuntimeApi;
import com.github.framework.evo.flowable.model.ProcessInstanceDto;
import com.github.framework.evo.flowable.model.StartDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Kyll
 * Date: 2018-02-26 20:53
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EvoFlowableSampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(EvoFlowableSampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(final RepositoryApi repositoryApi,
	                              final RuntimeApi runtimeApi) {

		return strings -> {
			/*List<ProcessDefinitionDto> processDefinitionDtoList = repositoryApi.findAllProcessDefinition();
			for (ProcessDefinitionDto processDefinitionDto : processDefinitionDtoList) {
				System.out.println(processDefinitionDto);
			}*/

			Map<String, Object> variableMap = new HashMap<>();
			variableMap.put("account", "1234567890");
			variableMap.put("amount", "9999");

			ProcessInstanceDto processInstanceDto = runtimeApi.startProcessInstanceByKey(
					StartDto.builder()
							.processDefinitionKey("notebook_01")
							.businessKey(DateUtil.formatDatetimeCompact(DateUtil.now()))
							.variableMap(variableMap)
							.build()
			);
			System.out.println(processInstanceDto);
		};

	}
}
