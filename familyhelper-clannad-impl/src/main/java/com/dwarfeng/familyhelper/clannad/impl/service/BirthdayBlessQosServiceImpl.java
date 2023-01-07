package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.handler.BirthdayBlessHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.BirthdayBlessQosService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class BirthdayBlessQosServiceImpl implements BirthdayBlessQosService {

    private final BirthdayBlessHandler birthdayBlessHandler;

    private final ServiceExceptionMapper sem;

    public BirthdayBlessQosServiceImpl(BirthdayBlessHandler birthdayBlessHandler, ServiceExceptionMapper sem) {
        this.birthdayBlessHandler = birthdayBlessHandler;
        this.sem = sem;
    }

    @PreDestroy
    public void dispose() throws Exception {
        birthdayBlessHandler.stop();
        birthdayBlessHandler.offline();
    }

    @Override
    public boolean isOnline() throws ServiceException {
        try {
            return birthdayBlessHandler.isOnline();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("判断生日祝福处理器是否上线时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void online() throws ServiceException {
        try {
            birthdayBlessHandler.online();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上线生日祝福处理器时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void offline() throws ServiceException {
        try {
            birthdayBlessHandler.offline();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下线生日祝福处理器时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public boolean isLockHolding() throws ServiceException {
        try {
            return birthdayBlessHandler.isLockHolding();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("判断生日祝福处理器是否正在持有锁时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public boolean isStarted() throws ServiceException {
        try {
            return birthdayBlessHandler.isStarted();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("判断生日祝福处理器是否启动时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void start() throws ServiceException {
        try {
            birthdayBlessHandler.start();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("生日祝福处理器启动时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void stop() throws ServiceException {
        try {
            birthdayBlessHandler.stop();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("生日祝福处理器停止时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public boolean isWorking() throws ServiceException {
        try {
            return birthdayBlessHandler.isWorking();
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("判断生日祝福处理器是否正在工作时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
