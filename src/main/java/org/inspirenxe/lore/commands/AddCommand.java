package org.inspirenxe.lore.commands;

import org.inspirenxe.lore.Storage;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class AddCommand implements CommandExecutor {
    public static final CommandSpec ADD_COMMAND_SPEC = CommandSpec.builder()
            .description(Texts.of("Adds the held book to the library. If another book with the same author and title are present in the library it will append '.#' to the end of the title in the library only."))
            .permission("library.command.add")
            .executor(new AddCommand())
            .build();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            final Player player = (Player) src;
            if (player.getItemInHand().isPresent() && player.getItemInHand().get().getItem() == ItemTypes.WRITTEN_BOOK) {
                final ItemStack heldItem = player.getItemInHand().get();
                Storage.addBook(heldItem);
                return CommandResult.success();
            }
        } else {
            src.sendMessage(Texts.of("Only players can perform this command."));
        }
        return CommandResult.empty();
    }
}
