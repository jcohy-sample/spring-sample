package com.jcohy.sample.spring_boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:16:26
 * @since 2022.04.0
 */
@Component
public class ProducerMessage implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {

    private static final Logger log = LoggerFactory.getLogger(ProducerMessage.class);

    private final RabbitTemplate rabbitTemplate;

    private RabbitCallback rabbitCallback;

    public ProducerMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this::confirm);
        rabbitTemplate.setReturnsCallback(this::returnedMessage);
        rabbitTemplate.setMandatory(true);
    }

    public void sendMessageToA(String content,RabbitCallback rabbitCallback) {
        this.rabbitCallback = rabbitCallback;
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTE_KEY_A,content,correlationId);
    }

    public void sendMessageToB(String content,RabbitCallback rabbitCallback) {
        this.rabbitCallback = rabbitCallback;
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B,RabbitConfig.ROUTE_KEY_B,content,correlationId);
    }

    /**
     * 如果发送到交换器都没有成功，比如删除了交换器，ack 返回值为 true，
     * 如果发送到交换器成功，但是没有匹配的队列（比如取消了绑定），ack 返回值还是 true.这是一个坑
     *
     * 开启 publisher-confirms，当消息发送到 exchange 成功时，ack 为 true。当发送到 exchange 失败时，ack 为 false
     *
     * 为了防止消息发送异常，我们需要在发送消息前，进行消息本地缓存。在 ReturnCallback 中可以直接进行消息的重新发送
     *
     * 如果 ConfirmCallback 中 ack 返回 true，这里需要注意的是，当 exchange 没有找到匹配队列，ack 也会返回 true，说明消息发送到 exchange
     * 成功，这个时候需要查看 ReturnCallback 中有没有发生异常，如果消息正常投递，可以通过 correlationData 删除 redis 或者数据库中的本地消息
     * 否则需要做异常处理
     *
     * ack 返回 false，也要做异常处理
     *
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("ConsumerA 消息确认 Id： "+ correlationData);

        if(ack) {
            rabbitCallback.returnCallBack("消息发送成功");
            log.info("消息发送成功");
            // todo 发送成功，删除本地数据库或redis消息
        } else {
            rabbitCallback.returnCallBack("消息发送失败");
            log.info("消息发送失败， Id {} | 消息发送失败原因 {}",correlationData,cause);
            // todo 根据本地消息的状态为失败，可以用定时任务去处理数据
        }

    }

    /**
     * 如果发送到交换机成功，但是没有匹配的队列，则会触发这个回调，开启 publisher-returns，发送到交换器成功，但是没有匹配的队列会触发。
     * 这样消息也会丢失
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        rabbitCallback.returnCallBack("returnedMessage [消息从交换器到队列失败]");
        log.info("returnedMessage [消息从交换器到队列失败] message: {}",returned);
    }
}
