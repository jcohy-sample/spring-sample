package com.jcohy.sample.spring_boot.rabbitmq;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:15:36
 * @since 2022.04.0
 */
public interface RabbitCallback {

    void returnCallBack(String message);

}
