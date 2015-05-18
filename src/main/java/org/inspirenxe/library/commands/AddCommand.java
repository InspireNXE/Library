package org.inspirenxe.library.commands;

import org.inspirenxe.library.Library;
import org.inspirenxe.library.Storage;
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

import static org.spongepowered.api.util.command.args.GenericArguments.playerOrSource;

public class AddCommand implements CommandExecutor {
    public final CommandSpec addCommandSpec = CommandSpec.builder()
            .description(Texts.of("Adds the held book to the library. If another book with the same author and title are present in the library it will append '.#' to the end of the title in the library only."))
            .permission("library.command.add")
            .arguments(playerOrSource(Texts.of("player"), Library.getInstance().game))
            .executor(new AddCommand())
            .build();

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

    public CommandSpec getCommandSpec() {
        return addCommandSpec;
    }
}
