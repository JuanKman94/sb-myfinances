package mx.geckox.myfin.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 2 configuration.
 *
 * For a brief tutorial on Swagger 2 with SpringBoot, see
 * <a href="https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/">
 *   SpringGuru's website
 * </a>. For current documentation on springfox' package, see the
 * <a href="https://springfox.github.io/springfox/docs/current/">reference manual</a>.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

  @Value("${mx.geckox.myfin.version}")
  private String apiVersion;

  @Bean
  public Docket devicesApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(metaData())
      .select()
      .apis(RequestHandlerSelectors.basePackage("mx.geckox.myfin.controllers"))
      .build();
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Geckox's My Finances API")
        .description("API ruling the finances, baby")
        .version(apiVersion)
        .contact(new Contact("juankman94", "", "juankman94@github.com"))
        .build();
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
