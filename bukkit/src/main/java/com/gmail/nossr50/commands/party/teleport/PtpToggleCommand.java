package com.gmail.nossr50.commands.party.teleport;

import com.gmail.nossr50.core.datatypes.party.PartyTeleportRecord;
import com.gmail.nossr50.core.locale.LocaleLoader;
import com.gmail.nossr50.core.util.Permissions;
import com.gmail.nossr50.core.data.UserManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PtpToggleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!Permissions.partyTeleportToggle(sender)) {
            sender.sendMessage(command.getPermissionMessage());
            return true;
        }

        PartyTeleportRecord ptpRecord = UserManager.getPlayer(sender.getName()).getPartyTeleportRecord();

        if (ptpRecord.isEnabled()) {
            sender.sendMessage(LocaleLoader.getString("Commands.ptp.Disabled"));
        }
        else {
            sender.sendMessage(LocaleLoader.getString("Commands.ptp.Enabled"));
        }

        ptpRecord.toggleEnabled();
        return true;
    }
}
