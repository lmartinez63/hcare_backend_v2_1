
package com.landl.hcare;

import com.landl.hcare.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication

@EnableCaching
public class HcareApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(HcareApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurerAdapter() {
			@Autowired
			PropertyService propertyService;

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry
						.addResourceHandler("/reportfiles/**").addResourceLocations("file:/Users/lmartinez/git/hcare/hcare_backend_v2_1/reports/out/");
			}
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				String frontEndUrl = (String)propertyService.getPropertiesMap().get("frontEndUrl");
				registry.addMapping("/api/loadProperties").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getContent").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getContent/*").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getLabels").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getDoctors").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getExamBundleList").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getAuxiliarExams").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getMedicaments").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getCIE10Codes").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getAllergies").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getNurses").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getRoles").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getPages").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getSections").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getFieldDefinitions").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getMedicalAreas").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getSurgeryTypes").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/generate-token").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/uploadAttachment").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/downloadAttachment").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/downloadAttachment/*").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getBrowseContent/*").allowedOrigins(frontEndUrl);
				registry.addMapping("/api/getBrowseContent").allowedOrigins(frontEndUrl);
			}
		};
	}
}
