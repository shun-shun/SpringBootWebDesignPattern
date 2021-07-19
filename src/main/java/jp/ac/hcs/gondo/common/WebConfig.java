package jp.ac.hcs.gondo.common;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.HttpStatusRequestRejectedHandler;
import org.springframework.security.web.firewall.RequestRejectedHandler;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

/**
 * Webシステム全体に関わる設定を行う.
 */
@Configuration
public class WebConfig {

	/** 出力パス */
	public static final String OUTPUT_PATH = "output/";

	/** タスク情報のCSVファイル名 */
	public static final String FILENAME_TASK_CSV = "tasklist.csv";

	@Bean
	public MessageSource messageSource() {

		//メッセージプロパティのファイル設定
		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
		bean.setBasename("classpath:messages");
		bean.setDefaultEncoding("UTF-8");

		return bean;
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {

		// バリデーションのメッセージ設定
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 不正なURLでのリクエストで404エラーを返すための設定
	 * :- https://www.b1a9idps.com/posts/spring-security-invalid-url-request
	 * @return HttpStatusRequestRejectedHandler
	 */
	@Bean
	public RequestRejectedHandler requestRejectedHandler() {
		return new HttpStatusRequestRejectedHandler(HttpStatus.NOT_FOUND.value());
	}

}
