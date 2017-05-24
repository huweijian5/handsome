package com.junmeng.handsome.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by hwj on 2017/5/22.
 */
class LogInterceptor : HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        println("preHandle")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后)
     */
    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        println("postHandle")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?) {
        println("afterCompletion")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}