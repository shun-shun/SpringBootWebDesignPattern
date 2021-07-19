package jp.ac.hcs.gondo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * アスペクト指向のログ出力を行う.
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

	/**
	 * Controllerの処理開始前後にログを出力する.
	 * @param jp
	 * @return 進行オブジェクト
	 * @throws Throwable
	 */
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object controllerLog(ProceedingJoinPoint jp) throws Throwable {

		// ログイン情報取得
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		log.info("[" + auth.getName() + "]メソッド開始： " + jp.getSignature());

		try {
			Object result = jp.proceed();
			log.info("[" + auth.getName() + "]メソッド終了： " + jp.getSignature());
			return result;

		} catch (Exception e) {
			log.warn("[" + auth.getName() + "]メソッド異常終了： " + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Repositoryの処理開始前後にログを出力する.
	 * @param jp
	 * @return 進行オブジェクト
	 * @throws Throwable
	 */
	@Around("execution(* *..*.*Repository*.*(..))")
	public Object serviceLog(ProceedingJoinPoint jp) throws Throwable {

		// ログイン情報取得
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		log.info("[" + auth.getName() + "]メソッド開始： " + jp.getSignature());

		try {
			Object result = jp.proceed();
			log.info("[" + auth.getName() + "]メソッド終了： " + jp.getSignature());
			return result;

		} catch (Exception e) {
			log.warn("[" + auth.getName() + "]メソッド異常終了： " + jp.getSignature());
			e.printStackTrace();
			throw e;
		}

	}

}
