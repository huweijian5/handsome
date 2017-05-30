package com.junmeng.handsome.interceptor

import com.junmeng.handsome.common.ConstantValue
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 权限拦截器
 * Created by hwj on 2017/5/30.
 */
class AccessInterceptor : HandlerInterceptor {
    //private val ACCESS_SESSION = "account"
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        println("preHandle11")
        val sessionObj = request?.getSession()?.getAttribute(ConstantValue.LOGIN_SESSION)
        if (sessionObj != null) {
            return true
        }
        response?.sendRedirect("/login")
        return false// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后)
     */
    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        println("postHandle11")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?) {
        println("afterCompletion11")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}