package com.junmeng.handsome

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.http.HttpStatus
import org.springframework.boot.web.server.ErrorPage
import org.springframework.context.annotation.Bean


/**
 * Created by hwj on 2017/5/21.
 */

@SpringBootApplication
@EnableTransactionManagement//开启事务支持
//open关键字指明可以覆写父类的方法，如不希望覆写，则用fianl
open class HandsomeApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(HandsomeApplication::class.java, *args)
        }
    }

    /**
     * 指定错误页
     * note:此处的可见性修饰符必须为open,不写默认是public final，而private或final都会导致编译报错
     */
   /* @Bean
    open  fun containerCustomizer(): EmbeddedServletContainerCustomizer {
        return EmbeddedServletContainerCustomizer { container ->
            val error401Page = ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401")
            val error404Page = ErrorPage(HttpStatus.NOT_FOUND, "/error/404")
            val error500Page = ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500")
            container.addErrorPages(error401Page, error404Page, error500Page)

        }
    }*/


}