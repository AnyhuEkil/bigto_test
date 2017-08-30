package com.big.to.logger;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // ���������� �����ϴ� bean
@Aspect // AOP bean
public class LogAdvice {

	 // private : �ܺο��� �α׸� ����ä�� ���ϵ��� �ϱ� ����
	 // static final : �α� ������ �ٲ��� �����Ƿ�
	 // �α����� ����ϴ� ���� : sysout��ɾ�� IO���ҽ��� ���� ����Ͽ� �ý����� ������ �� �ִ�, �α׸� ���Ϸ� �����Ͽ� �м��� �ʿ䰡 �ִ�.
	 private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	 // PointCut - ���� ����
	 // @Before, @After, @Around
	 // ��Ʈ�ѷ�, ����, DAO�� ��� method�� ���� ���Ŀ� logPrint method�� �ڵ����� ����ȴ�.
	 // .. : ������ ��� ���丮�� �ǹ�
	 // *(..) : * - ������ ��� �޼���, (..) - ��� �Ű�����
	 @Around("execution(* com.big.to.controller..*Controller.*(..))"
	         + " or execution(* com.big.to.service..*Service.*(..))"
	         + " or execution(* com.big.to.repository..*DAO.*(..))")
	 public Object logPrinnt(ProceedingJoinPoint joinPoint) throws Throwable{
	     // ���� �ð� üũ : ���۽ð�
	     double start = System.currentTimeMillis();
	     // �ٽɷ������� �̵�
	     Object result = joinPoint.proceed();
	     // Ŭ���� �̸�
	     String type = joinPoint.getSignature().getDeclaringTypeName();
	     String name = "";
	     if (type.indexOf("Controller") > -1) {
	         name = "Controller:";
	     } else if (type.indexOf("Service") > -1) {
	         name = "Service:";
	     } else if (type.indexOf("DAO") > -1) {
	         name = "DAO:";
	     }
	     // �޼��� �̸�
	     logger.info(name+type+"."+joinPoint.getSignature().getName()+"()");
	     // �Ķ���� �̸�
	     logger.info(Arrays.toString(joinPoint.getArgs()));
	     // ���� �ð� üũ : ����ð�
	     double end = System.currentTimeMillis();
	     // ���� �ð� üũ : ����
	     double time = end-start;
	     logger.info("���� �ð�: "+time/1000+"��");
	     return result;
	 }
}
