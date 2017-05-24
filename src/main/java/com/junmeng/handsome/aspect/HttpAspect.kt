package com.junmeng.handsome.aspect

import com.junmeng.handsome.entity.OperateLog
import com.junmeng.handsome.repository.OperateLogRepo
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*


/**
 * 面向切面（AOP）
 * note:由于使用kotlin,因此修饰符默认都是public final，此时需要加上open关键字，pointcut才会生效
 * Created by HWJ on 2017/3/18.
 */
@Aspect
@Component
class HttpAspect {
    val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    @Autowired
    var operateLogRepo: OperateLogRepo?=null

    // 定义切点Pointcut
    //表示Controller的所有方法
    @Pointcut("execution(public * com.junmeng.handsome.controller.*.*(..))")
    fun log() {
    }

    @Before("log()") //这种方法是减少重复的代码
    fun doBefore(joinPoint: JoinPoint) {
        /*logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = requestAttributes.request
        logger.info("Method={}", request.method)
        logger.info("RequestURI={}", request.requestURI)
        logger.info("RequestURL={}", request.requestURL)
        logger.info("PathInfo={}", request.pathInfo)
        logger.info("ServletPath={}", request.servletPath)
        logger.info("Protocol={}", request.protocol)

        //请求参数
        logger.info("QueryString= {}", request.queryString)
        logger.info("RequestedSessionId={}", request.requestedSessionId)

        logger.info("LocalAddr={}", request.localAddr)
        logger.info("LocalName={}", request.localName)
        logger.info("LocalPort={}", request.localPort)
        logger.info("RemoteAddr={}", request.remoteAddr)
        logger.info("RemoteHost={}", request.remoteHost)
        logger.info("RemotePort={}", request.remotePort)

        logger.info("ContextPath={}", request.contextPath)
        logger.info("AuthType={}", request.authType)
        logger.info("ContentType={}", request.contentType)
        logger.info("CharacterEncoding={}", request.characterEncoding)

        //类方法
        logger.info("class_method={}", joinPoint.signature.declaringTypeName + "." + joinPoint.signature.name)

        //参数
        logger.info("args={}", joinPoint.args)*/
        logger.info("===============================================================")
    }

    //@After("execution(public * com.junmeng.controller.UserController.*(..))")
    @After("log()")
    fun doAfter(joinPoint: JoinPoint) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        val requestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = requestAttributes.request
        logger.info("Method={}", request.method)
        logger.info("RequestURI={}", request.requestURI)
        logger.info("RequestURL={}", request.requestURL)
        logger.info("PathInfo={}", request.pathInfo)
        logger.info("ServletPath={}", request.servletPath)
        logger.info("Protocol={}", request.protocol)

        //请求参数
        logger.info("QueryString= {}", request.queryString)
        logger.info("RequestedSessionId={}", request.requestedSessionId)

        logger.info("LocalAddr={}", request.localAddr)
        logger.info("LocalName={}", request.localName)
        logger.info("LocalPort={}", request.localPort)
        logger.info("RemoteAddr={}", request.remoteAddr)
        logger.info("RemoteHost={}", request.remoteHost)
        logger.info("RemotePort={}", request.remotePort)

        logger.info("ContextPath={}", request.contextPath)
        logger.info("AuthType={}", request.authType)
        logger.info("ContentType={}", request.contentType)
        logger.info("CharacterEncoding={}", request.characterEncoding)

        //类方法
        logger.info("class_method={}", joinPoint.signature.declaringTypeName + "." + joinPoint.signature.name)

        //参数
        logger.info("args={}", joinPoint.args)
        logger.info("===============================================================")
        var operateLog:OperateLog= OperateLog(ip=request.localAddr,note="ddd",queryParam = request.queryString?:"",targetUrl = request.requestURL.toString())
//        operateLog.id=29
//        operateLog.userId=0
//        operateLog.ip=request.localAddr
//        operateLog.note="ddd"
//        operateLog.targetUrl=request.requestURL.toString()
//        operateLog.queryParam= request.queryString?:""
//        operateLog.ua = request.authType?:""

        operateLogRepo?.save(operateLog)
    }

    /**
     * 此注解用来打印返回对象的信息，这个对于调试也是非常有用的

     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    fun doAfterReturning(`object`: Any?) {
        logger.info("response={}", `object`?.toString() ?: "return null")
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
    }


}
