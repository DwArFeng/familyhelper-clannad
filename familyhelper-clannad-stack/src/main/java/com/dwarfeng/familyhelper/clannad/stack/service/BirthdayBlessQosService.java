package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 生日祝福 QOS 服务。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
public interface BirthdayBlessQosService extends Service {

    /**
     * 生日祝福服务是否上线。
     *
     * @return 是否上线。
     * @throws ServiceException 服务异常。
     */
    boolean isOnline() throws ServiceException;

    /**
     * 上线生日祝福服务。
     *
     * @throws ServiceException 服务异常。
     */
    void online() throws ServiceException;

    /**
     * 下线生日祝福服务。
     *
     * @throws ServiceException 服务异常。
     */
    void offline() throws ServiceException;

    /**
     * 生日祝福服务是否正在持有锁。
     *
     * @return 生日祝福服务是否正在持有锁。
     * @throws ServiceException 服务异常。
     */
    boolean isLockHolding() throws ServiceException;

    /**
     * 生日祝福服务是否启动。
     *
     * @return 生日祝福服务是否启动。
     * @throws ServiceException 服务异常。
     */
    boolean isStarted() throws ServiceException;

    /**
     * 生日祝福服务启动。
     *
     * @throws ServiceException 服务异常。
     */
    void start() throws ServiceException;

    /**
     * 生日祝福服务停止。
     *
     * @throws ServiceException 服务异常。
     */
    void stop() throws ServiceException;

    /**
     * 生日祝福服务是否正在工作。
     *
     * @return 生日祝福服务是否正在工作。
     * @throws ServiceException 服务异常。
     */
    boolean isWorking() throws ServiceException;
}
