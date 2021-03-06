package com.aibang.web.move.site;

import com.aibang.framework.activemq.SendMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;

/**
 * Created by Administrator on 2016/3/5.
 * activemq 发送消息测试
 */
//bobo@Controller
public class SpringJmsTest {
    /**
     * 队列名 登录
     */
    //bobo@Autowired
    private Destination queueDestinationLogin;
    /**
     * 队列名 注册
     */
    //bobo@Autowired
    private Destination queueDestinationRegist;



    /**
     * 队列消息发送对象
     */
  //bobo@Autowired
  //bobo@Qualifier("activemqSendMessage")
    private SendMessage activemqSendMessage;


    /**
     * 消息发送测试
     */
  //bobo@RequestMapping(value="/testjms")
    public void testSend() {
        activemqSendMessage.sendMessage(queueDestinationLogin, "Hello word");
    }
  //bobo@RequestMapping(value="/testjms2")
    public void testSend2() {
        activemqSendMessage.sendMessage(queueDestinationRegist, "Hello word");
    }



}
