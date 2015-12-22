package me.blha303;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

@Plugin(id = "ouch", name = "Ouch", version = "13")
public class Ouch {

    @Listener
    public void blockBreak(ChangeBlockEvent.Break event, @First Player player) {
        if (player.hasPermission("ouch.break")) {
            int transaction_length = event.getTransactions().size();
            if (transaction_length <= 1) {
                player.sendMessage(Texts.of("Ouch. "));
            } else if (transaction_length <= 5) {
                player.sendMessage(Texts.of("Owie."));
            } else if (transaction_length <= 10) {
                player.sendMessage(Texts.of("Owwww *tssss* ahhhhhhh *tsssss* ahhhhhh..."));
            } else if (transaction_length > 10) {
                player.sendMessage(Texts.of("Gahhhhh... Just kill me now."));
            }
        }
    }

    @Listener
    public void blockPlace(ChangeBlockEvent.Place event, @First Player player) {
        if (player.hasPermission("ouch.place")) {
            Text changedBlocks = Texts.join(Texts.of(", and "),
                    event.getTransactions().stream()
                            .map(transaction ->  transaction.getFinal().getState().getType())
                            .distinct()
                            .map(Texts::of)
                            .toArray(Text[]::new));

            player.sendMessage(Texts.of("Ahhhhh..... ", changedBlocks, "!"));
        }
    }

}
