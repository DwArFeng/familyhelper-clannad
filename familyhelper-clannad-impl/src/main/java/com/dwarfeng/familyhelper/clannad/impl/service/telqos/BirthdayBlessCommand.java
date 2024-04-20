package com.dwarfeng.familyhelper.clannad.impl.service.telqos;

import com.dwarfeng.familyhelper.clannad.stack.service.BirthdayBlessQosService;
import com.dwarfeng.springtelqos.node.config.TelqosCommand;
import com.dwarfeng.springtelqos.sdk.command.CliCommand;
import com.dwarfeng.springtelqos.stack.command.Context;
import com.dwarfeng.springtelqos.stack.exception.TelqosException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

@TelqosCommand
public class BirthdayBlessCommand extends CliCommand {

    private static final String COMMAND_OPTION_ONLINE = "online";
    private static final String COMMAND_OPTION_OFFLINE = "offline";
    private static final String COMMAND_OPTION_START = "start";
    private static final String COMMAND_OPTION_STOP = "stop";
    private static final String COMMAND_OPTION_STATUS = "status";

    private static final String[] COMMAND_OPTION_ARRAY = new String[]{
            COMMAND_OPTION_ONLINE,
            COMMAND_OPTION_OFFLINE,
            COMMAND_OPTION_START,
            COMMAND_OPTION_STOP,
            COMMAND_OPTION_STATUS
    };

    @SuppressWarnings("SpellCheckingInspection")
    private static final String IDENTITY = "birbless";
    private static final String DESCRIPTION = "生日祝福处服务操作/查看";

    private static final String CMD_LINE_SYNTAX_ONLINE = IDENTITY + " " +
            CommandUtil.concatOptionPrefix(COMMAND_OPTION_ONLINE);
    private static final String CMD_LINE_SYNTAX_OFFLINE = IDENTITY + " " +
            CommandUtil.concatOptionPrefix(COMMAND_OPTION_OFFLINE);
    private static final String CMD_LINE_SYNTAX_START = IDENTITY + " " +
            CommandUtil.concatOptionPrefix(COMMAND_OPTION_START);
    private static final String CMD_LINE_SYNTAX_STOP = IDENTITY + " " +
            CommandUtil.concatOptionPrefix(COMMAND_OPTION_STOP);
    private static final String CMD_LINE_SYNTAX_STATUS = IDENTITY + " " +
            CommandUtil.concatOptionPrefix(COMMAND_OPTION_STATUS);

    private static final String[] CMD_LINE_ARRAY = new String[]{
            CMD_LINE_SYNTAX_ONLINE,
            CMD_LINE_SYNTAX_OFFLINE,
            CMD_LINE_SYNTAX_START,
            CMD_LINE_SYNTAX_STOP,
            CMD_LINE_SYNTAX_STATUS
    };

    private static final String CMD_LINE_SYNTAX = CommandUtil.syntax(CMD_LINE_ARRAY);

    private final BirthdayBlessQosService birthdayBlessQosService;

    public BirthdayBlessCommand(BirthdayBlessQosService birthdayBlessQosService) {
        super(IDENTITY, DESCRIPTION, CMD_LINE_SYNTAX);
        this.birthdayBlessQosService = birthdayBlessQosService;
    }

    @Override
    protected List<Option> buildOptions() {
        List<Option> list = new ArrayList<>();
        list.add(Option.builder(COMMAND_OPTION_ONLINE).desc("上线生日祝福处服务").build());
        list.add(Option.builder(COMMAND_OPTION_OFFLINE).desc("下线生日祝福处服务").build());
        list.add(Option.builder(COMMAND_OPTION_START).desc("启动生日祝福处服务").build());
        list.add(Option.builder(COMMAND_OPTION_STOP).desc("停止生日祝福处服务").build());
        list.add(Option.builder(COMMAND_OPTION_STATUS).desc("查看生日祝福处服务状态").build());
        return list;
    }

    @Override
    protected void executeWithCmd(Context context, CommandLine cmd) throws TelqosException {
        try {
            Pair<String, Integer> pair = CommandUtil.analyseCommand(cmd, COMMAND_OPTION_ARRAY);
            if (pair.getRight() != 1) {
                context.sendMessage(CommandUtil.optionMismatchMessage(COMMAND_OPTION_ARRAY));
                context.sendMessage(CMD_LINE_SYNTAX);
                return;
            }
            switch (pair.getLeft()) {
                case COMMAND_OPTION_ONLINE:
                    birthdayBlessQosService.online();
                    context.sendMessage("生日祝福处服务已上线!");
                    break;
                case COMMAND_OPTION_OFFLINE:
                    birthdayBlessQosService.offline();
                    context.sendMessage("生日祝福处服务已下线!");
                    break;
                case COMMAND_OPTION_START:
                    birthdayBlessQosService.start();
                    context.sendMessage("生日祝福处服务已启动!");
                    break;
                case COMMAND_OPTION_STOP:
                    birthdayBlessQosService.stop();
                    context.sendMessage("生日祝福处服务已停止!");
                    break;
                case COMMAND_OPTION_STATUS:
                    printStatus(context);
                    break;
            }
        } catch (Exception e) {
            throw new TelqosException(e);
        }
    }

    private void printStatus(Context context) throws Exception {
        boolean onlineFlag = birthdayBlessQosService.isOnline();
        boolean latchHoldingFlag = birthdayBlessQosService.isLockHolding();
        boolean startedFlag = birthdayBlessQosService.isStarted();
        boolean workingFlag = birthdayBlessQosService.isWorking();

        context.sendMessage(String.format(
                "online: %b, latch holding: %b, started: %b, working: %b.",
                onlineFlag, latchHoldingFlag, startedFlag, workingFlag
        ));
    }
}
