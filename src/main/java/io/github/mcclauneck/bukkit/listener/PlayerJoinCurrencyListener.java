package io.github.mcclauneck.bukkit.listener;

import io.github.mcclauneck.common.MCEconomyProvider;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listener that guarantees the configured currencies exist whenever a player joins.
 * <p>
 * On each join it asks the {@link MCEconomyProvider} to verify that every
 * currency declared in {@code config.yml} is present, creating any that are
 * missing. This means currencies a server owner adds to the configuration appear
 * the next time a player joins, without a restart. The check runs asynchronously
 * through the provider's database layer, so it never blocks the server thread.
 */
public class PlayerJoinCurrencyListener implements Listener {

    /**
     * The central economy provider used to inspect and create currencies.
     */
    private final MCEconomyProvider provider;

    /**
     * Logger used to report failures while ensuring the default currencies.
     */
    private final Logger logger;

    /**
     * Constructs the listener.
     * @param provider The central economy provider.
     * @param logger The plugin logger for error reporting.
     */
    public PlayerJoinCurrencyListener(MCEconomyProvider provider, Logger logger) {
        this.provider = provider;
        this.logger = logger;
    }

    /**
     * Ensures all configured currencies exist when a player joins the server.
     * @param event The player join event.
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.provider.ensureDefaultCurrencies().exceptionally(throwable -> {
            this.logger.log(Level.SEVERE, "Failed to ensure configured currencies exist on player join", throwable);
            return null;
        });
    }
}
