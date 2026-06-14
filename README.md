# MCEconomy Bukkit (`plugin-bukkit`)

The shared Bukkit module for the **MCEconomy** multi-platform Minecraft economy plugin. It
holds the core event structures and listeners reused by every platform, and compiles against
the SpigotMC API only.

> Part of the MCEconomy multi-repository project. This repository was split out of the
> original `plugin` monorepo. The Maven artifactId is kept as **`bukkit`** so coordinates
> remain `io.github.mcclauneck:bukkit`.

## Contents

| Component | Description |
| --- | --- |
| `event/EconomyWalletUpdateEvent` | Custom Bukkit event fired when a wallet balance changes. |
| `listener/PlayerJoinCurrencyListener` | Re-verifies the configured default currencies on player join. |

## Dependencies

- `io.github.mcclauneck:api` — exposed transitively (`api` configuration).
- `io.github.mcclauneck:common` — `implementation` scope.
- `org.spigotmc:spigot-api` — `compileOnly`.

## Published coordinates

```
io.github.mcclauneck:bukkit:<project-version>-<project-iteration>
```

Published to GitHub Packages at `https://maven.pkg.github.com/MCClauneck/plugin-bukkit`.

## Building

```bash
./gradlew build
./gradlew publish   # publishes to GitHub Packages (requires credentials)
```

## Related repositories

- [`plugin-api`](https://github.com/MCClauneck/plugin-api) — pure data contracts.
- [`plugin-common`](https://github.com/MCClauneck/plugin-common) — database implementations and provider.
- [`plugin-papermc`](https://github.com/MCClauneck/plugin-papermc) / [`plugin-spigotmc`](https://github.com/MCClauneck/plugin-spigotmc) / [`plugin-foliamc`](https://github.com/MCClauneck/plugin-foliamc) — platform entry points.

## License

See [LICENSE](LICENSE).
