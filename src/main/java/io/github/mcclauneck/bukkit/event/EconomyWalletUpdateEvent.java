package io.github.mcclauneck.bukkit.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * A Bukkit custom event triggered when an account's wallet balance changes.
 */
public class EconomyWalletUpdateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String accountType;
    private final UUID accountUuid;
    private final String currencySystemCode;
    private final long newBalance;

    /**
     * Constructs the wallet update event.
     * @param accountType The type of account.
     * @param accountUuid The UUID of the account.
     * @param currencySystemCode The system code of the currency.
     * @param newBalance The updated balance of the wallet.
     */
    public EconomyWalletUpdateEvent(String accountType, UUID accountUuid, String currencySystemCode, long newBalance) {
        super(true); // Is async safely triggerable
        this.accountType = accountType;
        this.accountUuid = accountUuid;
        this.currencySystemCode = currencySystemCode;
        this.newBalance = newBalance;
    }

    /**
     * Gets the account type.
     * @return The account type string.
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Gets the account UUID.
     * @return The UUID of the account.
     */
    public UUID getAccountUuid() {
        return accountUuid;
    }

    /**
     * Gets the currency system code.
     * @return The currency system code string.
     */
    public String getCurrencySystemCode() {
        return currencySystemCode;
    }

    /**
     * Gets the new wallet balance.
     * @return The new balance.
     */
    public long getNewBalance() {
        return newBalance;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
