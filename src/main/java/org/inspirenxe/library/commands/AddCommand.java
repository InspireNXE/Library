package org.inspirenxe.library.commands;

import org.inspirenxe.library.Storage;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class AddCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        final Player player = args.<Player>getOne("player").get();
        if (player.getItemInHand().isPresent() && player.getItemInHand().get().getItem() == ItemTypes.WRITTEN_BOOK) {
            final ItemStack heldItem = player.getItemInHand().get();
            Storage.addBook(heldItem);
            return CommandResult.success();
        }
        return CommandResult.empty();
    }
}
