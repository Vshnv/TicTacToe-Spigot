package io.github.vshnv.mc.tictactoe.command;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

@Command("playGame")
public class PlayCommand {
    @Default
    public void onChallenge(CommandSender sender, UUID id) {
        if (id == null) return;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may play! Scram!");
            return;
        }

    }
}
